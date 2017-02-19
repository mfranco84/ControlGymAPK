package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button Loginn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Loginn=(Button) findViewById(R.id.btn_login);
        Loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Loginn=new Intent(Login.this, PlanNutrional.class);
                startActivity(Loginn);

            }
        });
    }
}
