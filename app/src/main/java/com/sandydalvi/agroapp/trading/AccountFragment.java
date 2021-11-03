package com.sandydalvi.agroapp.trading;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.trading.account.LoginActivity;


public class AccountFragment extends Fragment {

    private static final String TAG = "AccountFragment";

    private FirebaseAuth.AuthStateListener mAuthStateListner;
    private Button mSignOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_account,container,false);
        mSignOut=view.findViewById(R.id.sign_out);

        setupFirebaseListner();
        mSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"attempting to sign out the user.");
                FirebaseAuth.getInstance().signOut();

            }
        });

        return view;
    }

    private void setupFirebaseListner()
    {
        Log.d(TAG,"setup firebaseListner");
        mAuthStateListner=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null)
                {
                    Log.d(TAG,"signed in :"+user.getUid());
                }
                else
                {
                    Log.d(TAG,"signed out");
                    Toast.makeText(getActivity(),"signed out",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getActivity(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListner);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mAuthStateListner!=null)
        {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthStateListner);
        }

    }
}
