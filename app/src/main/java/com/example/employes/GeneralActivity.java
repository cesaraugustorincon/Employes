package com.example.employes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GeneralActivity extends AppCompatActivity {

    Button btnback;
    TextView tvMedSalario,tvMenSalario,tvMaxSalario,tvViejo,tvJoven;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        Bundle ext = this.getIntent().getExtras();
        btnback = findViewById(R.id.btnBack);
        tvJoven  = findViewById(R.id.tvJoven);
        tvViejo= findViewById(R.id.tvViejo);
        tvMaxSalario= findViewById(R.id.tvMaxSalario);
        tvMenSalario= findViewById(R.id.tvMenSalario);
        tvMedSalario = findViewById(R.id.tvMedSalario);

        int maxsalary,minsalary,medsalary,minage,maxage;
        maxsalary = ext.getInt("MaxSalario");
        medsalary = ext.getInt("MedSalario");
        minsalary = ext.getInt("MinSalario");
        maxage =ext.getInt("MaxEdad");
        minage =ext.getInt("MinEdad");
        Log.d("ACTGeneral", Integer.toString(medsalary));


        tvMaxSalario.setText(Integer.toString(maxsalary));
        tvMedSalario.setText(Integer.toString(medsalary));
        tvMenSalario.setText(Integer.toString(minsalary));
        tvJoven.setText(Integer.toString(minage));
        tvViejo.setText(Integer.toString(maxage));
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ACTGeneral", Integer.toString(medsalary));
                Intent intent = new Intent(GeneralActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}