package com.sandydalvi.agroapp.trading;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.trading.models.Post;
import com.sandydalvi.agroapp.trading.util.RotateBitmap;
import com.sandydalvi.agroapp.trading.util.UniversalImageLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PostFragment extends Fragment implements com.sandydalvi.agroapp.trading.SelectPhotoDialog.OnPhotoSelectedListner{

    private static final String TAG = "PostFragment";

    @Override
    public void getImagePath(Uri imagePath) {

        UniversalImageLoader.setImage(imagePath.toString(),mPostImage);
        mSelectedBitmap=null;
        mSelectedUri=imagePath;
    }

    @Override
    public void getImageBitmap(Bitmap bitmap) {

        mPostImage.setImageBitmap(bitmap);
        mSelectedBitmap=bitmap;
        mSelectedUri=null;

    }

    //widgets
    private ImageView mPostImage;
    private EditText mTitle, mDescription, mPrice, mCountry, mStateProvince, mCity, mContactEmail;
    private Button mPost;
    private ProgressBar mProgressBar;

    //vars
    private Bitmap mSelectedBitmap;
    private Uri mSelectedUri;
    private byte[] mUploadBytes;
    private double mProgress=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        mPostImage = view.findViewById(R.id.post_image);
        mTitle = view.findViewById(R.id.input_title);
        mDescription = view.findViewById(R.id.input_description);
        mPrice = view.findViewById(R.id.input_price);
        mCountry = view.findViewById(R.id.input_country);
        mStateProvince = view.findViewById(R.id.input_state_province);
        mCity = view.findViewById(R.id.input_city);
        mContactEmail = view.findViewById(R.id.input_email);
        mPost = view.findViewById(R.id.btn_post);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        init();
        return view;
    }

    private void init(){

        //FirebaseDatabase.getInstance().getReference().child("users").push().setValue("hi sandy");

        mPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog to choose new photo");
                com.sandydalvi.agroapp.trading.SelectPhotoDialog dialog=new com.sandydalvi.agroapp.trading.SelectPhotoDialog();
                dialog.show(getFragmentManager(),getString(R.string.dialog_select_photo));
                dialog.setTargetFragment(PostFragment.this,1);
            }
        });

        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(mTitle.getText().toString())
                     && !isEmpty(mDescription.getText().toString())
                        && !isEmpty(mPrice.getText().toString())
                        && !isEmpty(mCountry.getText().toString())
                        && !isEmpty(mStateProvince.getText().toString())
                        && !isEmpty(mCity.getText().toString())
                        && !isEmpty(mContactEmail.getText().toString()))
                {
                    if(mSelectedBitmap!=null && mSelectedUri==null)
                    {
                        uploadNewPhoto(mSelectedBitmap);
                    }
                    else if(mSelectedBitmap==null && mSelectedUri!=null)
                    {
                        uploadNewPhoto(mSelectedUri);
                    }
                }
                else
                {
                    Toast.makeText(getActivity(),"you must fill out all the fields",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void uploadNewPhoto(Bitmap bitmap)
    {
        BackgroundImageResize resize=new BackgroundImageResize(bitmap);
        Uri uri=null;
        resize.execute(uri);
    }

    private void uploadNewPhoto(Uri imagePath)
    {
        BackgroundImageResize resize=new BackgroundImageResize(null);
        resize.execute(imagePath);
    }

    public class BackgroundImageResize extends AsyncTask<Uri,Integer,byte[]> {
        Bitmap mBitmap;

        public BackgroundImageResize(Bitmap bitmap) {
            if (bitmap != null) {
                this.mBitmap = bitmap;
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getActivity(), "compressing image", Toast.LENGTH_SHORT).show();
            showProgressBar();
        }

        @Override
        protected byte[] doInBackground(Uri... uris) {

            if(mBitmap==null)
            {
                try {
                    //mBitmap= MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uris[0]);
                    RotateBitmap rotateBitmap=new RotateBitmap();
                    mBitmap=rotateBitmap.HandleSamplingAndRotationBitmap(getActivity(),uris[0]);

                }catch (IOException e)
                {
                    Log.e(TAG,"doinbackground :"+e.getMessage());
                }
            }
            byte[] bytes = null;
            bytes=getBytesFromBitmap(mBitmap,100);
            return bytes;
        }

        @Override
        protected void onPostExecute(byte[] bytes) {
            super.onPostExecute(bytes);
            mUploadBytes=bytes;
            hideProgressBar();
            executeUploadTask();
        }
    }

    private void executeUploadTask(){
        Toast.makeText(getActivity(), "uploading image", Toast.LENGTH_SHORT).show();

        final String postId = FirebaseDatabase.getInstance().getReference().push().getKey();

        final StorageReference storageReference = FirebaseStorage.getInstance().getReference()
                .child("posts/users/" + FirebaseAuth.getInstance().getCurrentUser().getUid() +
                        "/" + postId + "/post_image");

        UploadTask uploadTask = storageReference.putBytes(mUploadBytes);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                if (taskSnapshot.getMetadata() != null) {
                    if (taskSnapshot.getMetadata().getReference() != null) {
                        Task<Uri> result = taskSnapshot.getStorage().getDownloadUrl();
                        result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                String imageUrl = uri.toString();

                                Log.d(TAG, "onSuccess: firebase download url: " + imageUrl);
                                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

                                Post post = new Post();
                                post.setImage(imageUrl);
                                post.setCity(mCity.getText().toString());
                                post.setContact_email(mContactEmail.getText().toString());
                                post.setCountry(mContactEmail.getText().toString());
                                post.setDescription(mDescription.getText().toString());
                                post.setPost_id(postId);
                                post.setPrice(mPrice.getText().toString());
                                post.setState_provience(mStateProvince.getText().toString());
                                post.setTitle(mTitle.getText().toString());
                                post.setUser_id(FirebaseAuth.getInstance().getCurrentUser().getUid());

                                reference.child(getString(R.string.node_posts))
                                        .child(postId)
                                        .setValue(post);

                                resetFields();

                            }
                        });
                    }
                }
            }}).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "could not upload photo", Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double currentProgress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                if( currentProgress > (mProgress + 15)){
                    mProgress = (100 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                    Log.d(TAG, "onProgress: upload is " + mProgress + "& done");
                    Toast.makeText(getActivity(), mProgress + "%", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static byte[] getBytesFromBitmap(Bitmap bitmap,int quality)
    {
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,quality,stream);
        return stream.toByteArray();
    }

    private void resetFields(){
        UniversalImageLoader.setImage("", mPostImage);
        mTitle.setText("");
        mDescription.setText("");
        mPrice.setText("");
        mCountry.setText("");
        mStateProvince.setText("");
        mCity.setText("");
        mContactEmail.setText("");
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);

    }

    private void hideProgressBar(){
        if(mProgressBar.getVisibility() == View.VISIBLE){
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Return true if the @param is null
     * @param string
     * @return
     */
    private boolean isEmpty(String string){
        return string.equals("");
    }

}
