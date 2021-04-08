package com.example.employes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView LVEmploye;
    List<Employee> lst;
    Button btnSave,btnGeneral;
    EditText etlname,etfname,etemail,etage,etsalary,etpost;

    public int saldo=0, maySalario=0, medSalario =0,menSalario,cont=0, mayEdad=0,menEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = new ArrayList<>();
        LVEmploye = findViewById(R.id.ListVEmployee);

        etfname = findViewById(R.id.edtFirstName);
        etlname = findViewById(R.id.edtLastName);
        etage = findViewById(R.id.edtEdad);
        etemail = findViewById(R.id.edtEmail);
        etpost = findViewById(R.id.edtPost);
        etsalary = findViewById(R.id.edtSalary);


        AdapterEmployee adapter = new AdapterEmployee(this,lst);
        LVEmploye.setAdapter(adapter);

        btnSave = findViewById(R.id.btnSave);
        btnGeneral = findViewById(R.id.btnGeneral);

//        lst.add(new Employee("a","b","c@mail.com",1,"p1",6));
//        lst.add(new Employee("a","b","c@mail.com",3,"p1",4));

        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GeneralActivity.class);
                Log.d("LIST", Integer.toString(medSalario));
                intent.putExtra("MaxSalario",maySalario);
                intent.putExtra("MedSalario",medSalario);
                intent.putExtra("MinSalario",menSalario);
                intent.putExtra("MaxEdad",mayEdad);
                intent.putExtra("MenEdad",menEdad);
                startActivity(intent);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lst.add(new Employee(etfname.getText().toString(),etlname.getText().toString(),
                        etemail.getText().toString(),Integer.parseInt(etage.getText().toString()),
                        etpost.getText().toString(),Integer.parseInt(etsalary.getText().toString())));
                adapter.notifyDataSetChanged();

                clear();
                general();
                minCalc();
            }
        });
    }

    private void clear() {
        etfname.setText("");
        etlname.setText("");
        etage.setText("");
        etemail.setText("");
        etpost.setText("");
        etsalary.setText("");
    }

    private void general() {
        Employee k;

        for (int i =0;i<lst.size();i++){
            k = lst.get(i);
            saldo+=k.getSalary();

            if (k.getAge()>mayEdad){
                mayEdad =k.getAge();

            }

            if (k.getSalary()>maySalario){
                maySalario=k.getSalary();

            }


            cont++;
            medSalario = (saldo/cont);
            Log.d("LIST", Integer.toString(medSalario));


        }


    }

    private void minCalc() {

        menSalario = maySalario;
        menEdad = mayEdad;
//
        for (int j = lst.size()-1; j >= 0; j--) {
            Employee k = lst.get(j);
            if (menSalario > k.getSalary()) {
                menSalario = k.getSalary();
            }

            if (menEdad > k.getAge()) {
                mayEdad = k.getAge();

                Log.d("LIST", Integer.toString(j));
            }


        }


    }
}