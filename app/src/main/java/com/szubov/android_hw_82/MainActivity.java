package com.szubov.android_hw_82;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinnerLoc;
    private Button mBtnOk;
    private TextView mTextView;
    private Locale choiceLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        mBtnOk = findViewById(R.id.btnOk);
        mTextView = findViewById(R.id.textView);
        mSpinnerLoc = findViewById(R.id.spinnerLoc);

        initSpinnerLoc();

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Locale.getDefault().equals(choiceLoc)) {
                    changeLoc(choiceLoc);
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
                if (language[position].equals("Английский") || language[position].equals("English")) {
                    choiceLoc = new Locale("en");
                } else {
                    choiceLoc = new Locale("ru");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void changeLoc(Locale choiceLoc) {
        Locale.setDefault(choiceLoc);
        Configuration configuration = new Configuration();
        configuration.setLocale(choiceLoc);
        getResources().updateConfiguration(configuration,
                getBaseContext().getResources().getDisplayMetrics());

        recreate();
    }
}