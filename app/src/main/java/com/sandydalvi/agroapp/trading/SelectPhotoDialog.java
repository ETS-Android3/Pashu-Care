package com.sandydalvi.agroapp.trading;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.sandydalvi.agroapp.R;

import java.util.Objects;

public class SelectPhotoDialog extends DialogFragment {

    private static final String TAG="SelectPhotoDialog";
    private static final int PICKFILE_REQUEST_CODE = 1234;
    private static final int CAPTURE_REQUEST_CODE = 4321;

    public interface OnPhotoSelectedListner
    {
        void getImagePath(Uri imagePath);
        void getImageBitmap(Bitmap bitmap);
    }

    OnPhotoSelectedListner onPhotoSelectedListner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_selectphoto,container,false);

        TextView selectPhoto=view.findViewById(R.id.dialogChoosePhoto);
        selectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"accesing phones memory.");
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,PICKFILE_REQUEST_CODE);
            }
        });

        TextView takePhoto=view.findViewById(R.id.dialogOpenCamera);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"accesing phones memory.");
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAPTURE_REQUEST_CODE);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PICKFILE_REQUEST_CODE && resultCode== Activity.RESULT_OK)
        {
            assert data != null;
            Uri selectedImageUri=data.getData();
            Log.d(TAG,"OnActivityResult image uri: "+selectedImageUri);
            onPhotoSelectedListner.getImagePath(selectedImageUri);
            Objects.requireNonNull(getDialog()).dismiss();

        }
        else if(requestCode==CAPTURE_REQUEST_CODE && resultCode== Activity.RESULT_OK)
        {
            Log.d(TAG,"OnActivityResult taking new image ");
            Bitmap bitmap;
            assert data != null;
            bitmap=(Bitmap) data.getExtras().get("data");

            onPhotoSelectedListner.getImageBitmap(bitmap);
            Objects.requireNonNull(getDialog()).dismiss();

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {

        try {
            onPhotoSelectedListner=(OnPhotoSelectedListner)getActivity();
        }
        catch (ClassCastException e)
        {
            Log.e(TAG,"OnAttach classCastException: "+e.getMessage());
        }
        super.onAttach(context);
    }
}
