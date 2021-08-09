package com.example.calmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText uname,pass;
    TextView create,forgotpass;
    Button login;
    DBHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname=findViewById(R.id.ETUsername);
        pass=findViewById(R.id.ETPassword);
        login=findViewById(R.id.BTLogin);
        create=findViewById(R.id.TXTCreate);
        forgotpass=findViewById(R.id.TxtForgotPass);
        Db = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String User =  uname.getText().toString();
                String Pass = pass.getText().toString();

                if(User.equals("") || Pass.equals("")){
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = Db.checkusernamepass(User,Pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this, "Sign In Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), MainDashboard.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Signup.class);
                startActivity(intent);
            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(intent);
            }
        });
    }
}