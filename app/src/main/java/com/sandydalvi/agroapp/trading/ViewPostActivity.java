package com.sandydalvi.agroapp.trading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.trading.models.Post;
import com.sandydalvi.agroapp.trading.util.UniversalImageLoader;

import java.io.File;

public class ViewPostActivity extends AppCompatActivity {

    private static final String TAG = "ViewPostFragment";

    //widgets
    private TextView  mTitle, mDescription, mPrice, mLocation, mSavePost;
    private AppCompatButton mContactSeller;
    private ImageView mClose, mWatchList, mPostImage;

    //vars
    private String mPostId;
    private Post mPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);


        mContactSeller = (AppCompatButton) findViewById(R.id.post_contact);
        mTitle = (TextView) findViewById(R.id.post_title);
        mDescription = (TextView) findViewById(R.id.post_description);
        mPrice = (TextView)findViewById(R.id.post_price);
        mLocation = (TextView) findViewById(R.id.post_location);
        mClose = (ImageView) findViewById(R.id.post_close);
        mWatchList = (ImageView) findViewById(R.id.add_watch_list);
        mPostImage = (ImageView) findViewById(R.id.post_image);
        mSavePost = (TextView) findViewById(R.id.save_post);

        init();
        //hideSoftKeyboard();
    }

    private void init(){
        getPostInfo();

        mContactSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {mPostId});
                ViewPostActivity.this.startActivity(emailIntent);
            }
        });

//        mClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: closing post.");
//                ViewPostActivity.this.getSupportFragmentManager().popBackStack();
//            }
//        });

//        mSavePost.setShadowLayer(5, 0 , 0, Color.BLUE);
//        mWatchList.setImageBitmap(createOutline(BitmapFactory.decodeResource(getResources(), R.drawable.ic_save_white)));
//        mWatchList.setColorFilter(Color.BLUE);
//        mClose.setImageBitmap(createOutline(BitmapFactory.decodeResource(getResources(), R.drawable.ic_x_white)));
//        mClose.setColorFilter(Color.BLUE);
    }

    private void getPostInfo(){
        Log.d(TAG, "getPostInfo: getting the post information.");

        Intent intent=getIntent();
        String title=intent.getStringExtra("name");
        String price=intent.getStringExtra("price");
        String contry=intent.getStringExtra("country");
        String state=intent.getStringExtra("state");
        String city=intent.getStringExtra("city");
        String link=intent.getStringExtra("img");
        mPostId=intent.getStringExtra("email");

        //Glide.with(getApplicationContext()).load(link).into(mPostImage);

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//
//        Query query = reference.child(getString(R.string.node_posts))
//                .orderByKey()
//                .equalTo(mPostId);
//
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                DataSnapshot singleSnapshot = dataSnapshot.getChildren().iterator().next();
//                if(singleSnapshot != null){
//                    mPost = singleSnapshot.getValue(Post.class);
//                    Log.d(TAG, "onDataChange: found the post: " + mPost.getTitle());
//
                    mTitle.setText(title);
                    //mDescription.setText(mPost.getDescription());

                    //String price = "FREE";
                    //if(mPost.getPrice() != null){
                       price =price.concat("₹");
                    //}
                    mPrice.setText(price);
                    String location = city+ ", " + state + ", " +
                            contry;
                    mLocation.setText(location);
                    UniversalImageLoader.setImage(link, mPostImage);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

//    private void hideSoftKeyboard(){
//        final Activity activity = ViewPostActivity.this;
//        final InputMethodManager inputManager = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
//
//        inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//    }

//    private Bitmap createOutline(Bitmap src){
//        Paint p = new Paint();
//        p.setMaskFilter(new BlurMaskFilter(2, BlurMaskFilter.Blur.OUTER));
//        return src.extractAlpha(p, null);
//    }
}


