package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText UserName;
    private EditText UserPassword;
    private Button UserLoginButton;

    private String UserNameCredentials = "admin";
    private String UserPasswordCredentials = "admin123";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = findViewById(R.id.UserNameId);
        UserPassword = findViewById(R.id.UserPassword);
        UserLoginButton = findViewById(R.id.SubmitButton);

        UserLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserNameInput = UserName.getText().toString();
                String UserPasswordInput = UserPassword.getText().toString();

                if(UserNameInput.isEmpty() || UserPasswordInput.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter UserName and Password",Toast.LENGTH_SHORT).show();
                }else{
                    //validate credentials
                    isValid = validate(UserNameInput,UserPasswordInput);
                    if(!isValid){
                        Toast.makeText(MainActivity.this,"Enter valid user and password",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Login Successful !",Toast.LENGTH_SHORT).show();

                        // code to go to the next activity
                        Intent intent = new Intent(MainActivity.this,Homepage.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    // function to validate user credentilas

    private boolean validate(String name, String password){
        if(name.equals(UserNameCredentials) && password.equals(UserPasswordCredentials)){
            return true;
        }
        return false;
    }
}