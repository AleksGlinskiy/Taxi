package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaxiActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOk;
    TextView tvStreetRoute, tvHouseRoute, tvFlatRoute, tvStreet2Route, tvHouse2Route, tvFlat2Route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);

        initViews();
    }

    public void initViews() {
        tvStreetRoute = (TextView) findViewById(R.id.tvStreetRoute);
        tvHouseRoute = (TextView) findViewById(R.id.tvHouseRoute);
        tvFlatRoute = (TextView) findViewById(R.id.tvFlatRoute);

        tvStreet2Route = (TextView) findViewById(R.id.tvStreet2Route);
        tvHouse2Route = (TextView) findViewById(R.id.tvHouse2Route);
        tvFlat2Route = (TextView) findViewById(R.id.tvFlat2Route);

        btnOk = (Button) findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                Intent intent = new Intent();
                intent.putExtra("saveTvStreetRoute", tvStreetRoute.getText().toString());
                intent.putExtra("saveTvHouseRoute", tvHouseRoute.getText().toString());
                intent.putExtra("saveTvFlatRoute", tvFlatRoute.getText().toString());

                intent.putExtra("saveTvStreet2Route", tvStreet2Route.getText().toString());
                intent.putExtra("saveTvHouse2Route", tvHouse2Route.getText().toString());
                intent.putExtra("saveTvFlat2Route", tvFlat2Route.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }


}
