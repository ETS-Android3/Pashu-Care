package com.sandydalvi.agroapp.trading;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sandydalvi.agroapp.R;

public class SearchFragment extends Fragment {

    private static final String TAG = "SearchFragment";

    private ImageView mFilters;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_search,container,false);

        mFilters=(ImageView) view.findViewById(R.id.ic_search);

        init();

        return view;
    }

    private void init() {

        mFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"filters activity");
                Intent intent=new Intent(getActivity(),FiltersActivity.class);
                startActivity(intent);
            }
        });

    }
}
