package com.example.calmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {


    EditText uname,pass,cpass;
    TextView login;
    Button signup;
    DBHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        uname=findViewById(R.id.ETUsername);
        pass=findViewById(R.id.ETPassword);
        cpass=findViewById(R.id.ETCpassword);
        signup=findViewById(R.id.BTsignup);
        login=findViewById(R.id.TXTlogin);
        Db = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String User =  uname.getText().toString();
                String Pass = pass.getText().toString();
                String CPass = cpass.getText().toString();
                if(User.equals("") || Pass.equals("") || CPass.equals("")){
                    Toast.makeText(Signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(Pass.equals(CPass)){
                        Boolean checkuser = Db.checkusername(User);
                        if(checkuser==false){
                            Boolean insert = Db.insertdata(User,Pass);
                            if(insert == true){
                                Toast.makeText(Signup.this, "User Registered, Please Login!!!", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Signup.this, "Registration Failed!!!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(Signup.this, "User already exists!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Signup.this, "Password does not match the Confirm Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
