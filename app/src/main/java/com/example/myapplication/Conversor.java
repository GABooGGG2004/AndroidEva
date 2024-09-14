package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Conversor extends AppCompatActivity {

    EditText monto;
    EditText dolar;
    EditText euro;
    Button conver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        monto = findViewById(R.id.txtMonto);
        dolar = findViewById(R.id.txtDolar);
        euro = findViewById(R.id.txtEURO);
        conver = findViewById(R.id.btnConv);

        conver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String moneda = monto.getText().toString();
                Double money = Double.parseDouble(moneda);
                Double dol = money*924.27;
                String dolare = String.valueOf(dol);
                dolar.setText(dolare);
                Double eur = money * 1024.52;
                String euros = String.valueOf(eur);
                euro.setText(euros);

            }
        });

    }
}