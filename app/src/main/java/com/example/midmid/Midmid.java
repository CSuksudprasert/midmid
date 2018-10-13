package com.example.midmid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Midmid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midmid);

        Button startButton = findViewById(R.id.button_strat);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Hello";
                Toast t = Toast.makeText(Midmid.this , message, Toast.LENGTH_SHORT);
                t.show();
                Intent i = new Intent(Midmid.this,MainMidmid.class);
                startActivity(i);
            }
        });

        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Bye Bye";
                Toast t1 = Toast.makeText(Midmid.this,message,Toast.LENGTH_SHORT);
                t1.show();
                finish();
            }
        });
    }
}
