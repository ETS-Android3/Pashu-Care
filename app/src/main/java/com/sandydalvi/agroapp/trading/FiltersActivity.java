package com.sandydalvi.agroapp.trading;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sandydalvi.agroapp.R;

public class FiltersActivity extends AppCompatActivity {

    private static final String TAG = "FiltersActivity";

    private Button mSave;
    private EditText mzcity,mState,mCountry;
    private ImageView mBackArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        mSave=(Button) findViewById(R.id.btnSave);
        mzcity=findViewById(R.id.input_city);
        mCountry=findViewById(R.id.input_country);
        mState=findViewById(R.id.input_state_province);
        mBackArrow=findViewById(R.id.backArrow);

        init();
    }

    private void init()
    {
        getFilterPrefernces();

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(FiltersActivity.this);
                SharedPreferences.Editor editor=preferences.edit();

                editor.putString(getString(R.string.prefernces_city),mzcity.getText().toString());
                editor.apply();

                editor.putString(getString(R.string.prefernces_country),mCountry.getText().toString());
                editor.apply();

                editor.putString(getString(R.string.prefernces_state),mState.getText().toString());
                editor.apply();
            }
        });

        mBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getFilterPrefernces() {

        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(this);

        String coutry=preferences.getString(getString(R.string.prefernces_country),"");
        String city=preferences.getString(getString(R.string.prefernces_city),"");
        String state=preferences.getString(getString(R.string.prefernces_state),"");

        mCountry.setText(coutry);
        mzcity.setText(city);
        mState.setText(state);

    }


}