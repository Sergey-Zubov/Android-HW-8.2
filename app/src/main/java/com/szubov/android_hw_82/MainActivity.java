package com.szubov.android_hw_82;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinnerLoc;
    private Button mBtnOk;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        mSpinnerLoc.findViewById(R.id.spinnerLoc);
        mBtnOk.findViewById(R.id.btnOk);
        mTextView.findViewById(R.id.textView);

        initSpinnerLoc();

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v) {
                    case "Русский":

                        break;
                }
            }
        });

    }

    private void initSpinnerLoc() {
        ArrayAdapter<CharSequence> adapterLoc = ArrayAdapter.createFromResource
                (this, R.array.spinner_loc_array, android.R.layout.simple_spinner_item);
        adapterLoc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerLoc.setAdapter(adapterLoc);

        mSpinnerLoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] language = getResources().getStringArray(R.array.spinner_loc_array);
                choiceLoc(language[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void choiceLoc(String s) {

    }
}