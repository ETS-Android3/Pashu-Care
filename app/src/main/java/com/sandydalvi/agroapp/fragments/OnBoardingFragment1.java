package com.sandydalvi.agroapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sandydalvi.agroapp.IntroActivity;
import com.sandydalvi.agroapp.MainActivity;
import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.trading.account.LoginActivity;

public class OnBoardingFragment1 extends Fragment {

    TextView skip;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root=(ViewGroup)inflater.inflate(R.layout.fragment_on_boarding1,container,false);

        skip=(TextView)root.findViewById(R.id.skip1);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), IntroActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}