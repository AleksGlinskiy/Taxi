package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    EditText tvName, tvSurname, tvPhone;

    SharedPreferences sPref;
    final String SAVED_TEXT_NAME = "my_saved_name";
    final String SAVED_TEXT_SURNAME = "my_saved_surname";
    final String SAVED_TEXT_PHONE = "my_saved_phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadText();
    }

    public void initViews() {
        tvName = (EditText) findViewById(R.id.tvName);
        tvSurname = (EditText) findViewById(R.id.tvSurname);
        tvPhone = (EditText) findViewById(R.id.tvPhone);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("saveTvName", tvName.getText().toString());
                intent.putExtra("saveTvSurname", tvSurname.getText().toString());
                intent.putExtra("saveTvPhone", tvPhone.getText().toString());
                startActivity(intent);
            break;
        }
    }

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(SAVED_TEXT_NAME, tvName.getText().toString());
        editor.putString(SAVED_TEXT_SURNAME, tvSurname.getText().toString());
        editor.putString(SAVED_TEXT_PHONE, tvPhone.getText().toString());
        editor.commit();
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT_NAME, "");
        String savedTextSurname = sPref.getString(SAVED_TEXT_SURNAME, "");
        String savedTextPhone = sPref.getString(SAVED_TEXT_PHONE, "");
        tvName.setText(savedText);
        tvSurname.setText(savedTextSurname);
        tvPhone.setText(savedTextPhone);
        if (!tvName.getText().toString().equals("")) btnRegister.setText("Авторизоваться");
        Toast.makeText(this, "Данные загружены", Toast.LENGTH_SHORT).show();
    }


}
