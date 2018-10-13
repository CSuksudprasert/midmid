package com.example.midmid;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainMidmid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_midmid);

        final Button calculatorButton = findViewById(R.id.calculator_button);

        calculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.Height_editText);
                EditText weightEditText = findViewById(R.id.Weight_editText);

                int h = Integer.parseInt(heightEditText.getText().toString());
                int w = Integer.parseInt(weightEditText.getText().toString());

                float bmi = calculatorBmi(h, w);

                String resultText = null;
                if (bmi < 18.5)
                    resultText = "ผอมเกินไป";
                else if(bmi <25)
                    resultText = "น้ำหนักปกติ";
                else if(bmi <30)
                    resultText ="อ้วน";
                else
                    resultText = "อ้วนมาก";

                String msg = "เกณฑ์น้ำหนักของคุณ: "+resultText;
               // Toast t =Toast.makeText(MainMidmid.this,msg,Toast.LENGTH_LONG);
                //t.show();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainMidmid.this);
                dialog.setTitle("Result");
                dialog.setMessage(msg);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo : Code ที่ให้ทำเมื่อ User คลิก OK ใน dialog
                    }
                });
               // dialog.setNegativeButton("No",null);
                dialog.setCancelable(false);
                //todo : ถ้าไม่ใส่ dialog.setCancelable(false); เราจะสามารถออกจากหน้าต่างของ dialog โดยการกดข้างนอกปุ่มได้ แต่ถ้าใส่ เราต้องกดปุ่มใน dialog เท่านั้นจึงจะออกจากหน้าต่างของ dialog ได้
                dialog.show();
                //todo : show dialog

                //todo :สามารถเขียนdialog อีกแบบได้ เช่น บรรทัดที่ 75-79
                //new AlertDialog.Builder(MainActivity.this)
                // .setTitle("Result")
                // .setMessage(msg)
                // .setPositiveButton("OK",nul)
                // .setNegativeButton("No",null).show;

                //todo : libraly Glide เป็น libraly ที่เอาไว้โหลดรูปจาก internet (บรรทัด 82)
                //Glide.with(context).load(URL).into(imageview);
            }
        });

    }
    private  float calculatorBmi(int heightIncm,int weightKg){
        // bmi = kg / m^2

        float height = heightIncm / 100f;

        float bmi = weightKg/(height * height);
        return bmi;

    }
}
