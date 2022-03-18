package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Homepage extends AppCompatActivity {


    private Button UserLogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        UserLogoutButton = findViewById(R.id.LogoutButton);
        UserLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Homepage.this,"Admin Loggedout Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Homepage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}