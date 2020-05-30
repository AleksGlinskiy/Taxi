package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvNameProfile, tvPhoneProfile, tvAddressProfile;
    Button btnCall, btnProfile;

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();

        Intent intent = getIntent();
        tvNameProfile.setText(intent.getStringExtra("saveTvName") + " " + intent.getStringExtra("saveTvSurname"));
        tvPhoneProfile.setText(intent.getStringExtra("saveTvPhone"));

        if (tvAddressProfile.getText().toString().equals("")) btnCall.setEnabled(false);
    }

    public void initViews() {
        tvNameProfile = (TextView) findViewById(R.id.tvNameProfile);
        tvPhoneProfile = (TextView) findViewById(R.id.tvPhoneProfile);
        tvAddressProfile = (TextView) findViewById(R.id.tvAddressProfile);

        btnCall = (Button) findViewById(R.id.btn_call);
        btnProfile = (Button) findViewById(R.id.btn_profile);

        btnProfile.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_profile:
                Intent intent = new Intent("android.intent.action.TaxiActivity");
                startActivityForResult(intent, 1);
                break;
            case R.id.btn_call:
                Toast.makeText(this, "Такси в пути. Ожидайте!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }

        String saveTvStreetRoute = data.getStringExtra("saveTvStreetRoute");
        String saveTvHouseRoute = data.getStringExtra("saveTvHouseRoute");
        String saveTvFlatRoute = data.getStringExtra("saveTvFlatRoute");

        String saveTvStreet2Route = data.getStringExtra("saveTvStreet2Route");
        String saveTvHouse2Route = data.getStringExtra("saveTvHouse2Route");
        String saveTvFlat2Route = data.getStringExtra("saveTvFlat2Route");
        tvAddressProfile.setText("Маршрут построен от ул. " + saveTvStreetRoute + ", д. " + saveTvHouseRoute + ", кв. " + saveTvFlatRoute + " до ул. " + saveTvStreet2Route + ", д. " + saveTvHouse2Route + ", кв. " + saveTvFlat2Route + "\nТакси будет на месте через 5 минут после вызова.");
        btnCall.setEnabled(true);
    }

}
