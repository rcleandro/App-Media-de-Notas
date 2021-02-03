package com.example.mediadenota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;
    EditText edt5;
    TextView txt1;
    TextView txt2;
    TextView txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.editTextNumberDecimal);
        edt2 = (EditText) findViewById(R.id.editTextNumberDecimal2);
        edt3 = (EditText) findViewById(R.id.editTextNumberDecimal3);
        edt4 = (EditText) findViewById(R.id.editTextNumberDecimal4);
        edt5 = (EditText) findViewById(R.id.editTextNumberDecimal5);
        txt1 = (TextView) findViewById(R.id.textView8);
        txt2 = (TextView) findViewById(R.id.textView9);
        txt3 = (TextView) findViewById(R.id.textView10);
    }

    public void calcular (View v) {
        double ava1=0, ava2=0, a1=0, a2=0, a3=0, media=0, aprovado=0;

        if (edt1.getText().length() == 0) {
            edt1.setError("Campo vazio");
        }
        else {
            ava1 = Double.parseDouble(edt1.getText().toString());
            if (ava1 > 10) {
                edt1.setError("Campo inválido");
            }
        }
        if (edt2.getText().length() == 0) {
            edt2.setError("Campo vazio");
        }
        else {
            ava2 = Double.parseDouble(edt2.getText().toString());
            if (ava2 > 10) {
                edt2.setError("Campo inválido");
            }
        }
        if (edt4.getText().length() == 0) {
            edt4.setError("Campo vazio");
        }
        else {
            a2 = Double.parseDouble(edt4.getText().toString());
            if (a2 > 10) {
                edt4.setError("Campo inválido");
            }
        }
        if (edt5.getText().length() == 0) {
            edt5.setError("Campo vazio");
        }
        else {
            a3 = Double.parseDouble(edt5.getText().toString());
    if (a3 > 10) {
                edt5.setError("Campo inválido");
            }
        }

        a1 = (ava1+ava2)/2;
        DecimalFormat precision = new DecimalFormat("#.##");
        edt3.setText(String.valueOf(precision.format(a1)));

        if (a1 > 0) {
            if (a2 > a3) {
                media = (a1 * 0.4) + (a2 * 0.6);
                if (media >= 6) {
                    aprovado = 1;
                } else {
                    aprovado = 2;
                }
            } else {
                media = (a1 * 0.4) + (a3 * 0.6);
                if (media >= 6) {
                    aprovado = 1;
                } else {
                    aprovado = 2;
                }
            }
            if (aprovado == 1) {
                txt2.setText("");
                txt3.setText("Sua média é de " + (String.valueOf(precision.format(media))) + "  pontos");
                txt1.setText("Parabéns! Você foi aprovado.");
            } else {
                txt1.setText("");
                txt3.setText("Sua média é de " + (String.valueOf(precision.format(media))) + "  pontos");
                txt2.setText("Sinto muito! Você foi reprovado.");
            }
        }
        else {
            txt1.setText("");
            txt3.setText("Sua média na A1 foi 0");
            txt2.setText("Sinto muito! Você foi reprovado.");
        }
    }

    public void limpar (View v) {
        double ava1=0, ava2=0, a1=0, a2=0, a3=0;

        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
        edt5.setText("");
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
    }
}