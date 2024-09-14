package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMC extends AppCompatActivity {

    EditText txtEdad;
    EditText txtPeso;
    EditText txtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtEdad = findViewById(R.id.txtNumeroEdad);
        txtPeso = findViewById(R.id.txtNumeroPeso);
        txtAltura = findViewById(R.id.txtNumeroAltura);
    }
    public void imc(View vista){
        String txtStringEdad = txtEdad.getText().toString();
        String txtStringPeso = txtPeso.getText().toString();
        String txtStringAltura = txtPeso.getText().toString();

        if (txtStringEdad.equals("") || txtStringPeso.equals("") || txtStringAltura.equals("")){
            Toast.makeText(getApplicationContext(),"Porfavor rellene los siguientes campos.",Toast.LENGTH_LONG).show();
        }else{
            int edad = Integer.parseInt(txtStringEdad);
            float peso = Float.parseFloat(txtStringPeso);
            float altura = Float.parseFloat(txtStringAltura);

            altura = altura/100;

            float imc = peso/(float)Math.pow(altura,2);

            String imcTexto = String.format("%.1f",imc);
            if (imc<18.5f)
                Toast.makeText(getApplicationContext(),"Su edad es: " + txtEdad + " y su IMC es de: " + imcTexto + ", Usted tiene desnutricion",Toast.LENGTH_LONG).show();
            if (imc >=18.5 && imc < 25)
                Toast.makeText(getApplicationContext(),"Su edad es: "+ txtEdad + " Y su IMC es de: " + imcTexto + ", Usted tiene peso normal", Toast.LENGTH_LONG).show();
            if (imc >=25 &&imc <30)
                Toast.makeText(getApplicationContext(),"Su edad es: "+ txtEdad + " Y su IMC es de: " + imcTexto + ", Usted tiene sobre peso", Toast.LENGTH_LONG).show();
            if (imc >=30 && imc <35)
                Toast.makeText(getApplicationContext(),"Su edad es: "+ txtEdad + " Y su IMC es de: " + imcTexto + ", Usted tiene Obecidad grado 1", Toast.LENGTH_LONG).show();
            if (imc >=35 && imc <40)
                Toast.makeText(getApplicationContext(),"Su edad es: "+ txtEdad + " Y su IMC es de: " + imcTexto + ", Usted tiene Obecidad grado 2", Toast.LENGTH_LONG).show();
            if (imc <=40)
                Toast.makeText(getApplicationContext(),"Su edad es: "+ txtEdad + " Y su IMC es de: " + imcTexto + ", Usted tiene Obecidad grado 3", Toast.LENGTH_LONG).show();


        }

    }
}