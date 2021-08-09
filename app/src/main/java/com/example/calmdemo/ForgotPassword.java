package com.example.calmdemo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    EditText Uname,Pass,Cpass;
    Button Reset;
    TextView Signin;
    DBHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        Uname = findViewById(R.id.ETUName);
        Pass = findViewById(R.id.ETPass);
        Cpass = findViewById(R.id.ETConfirmPass);
        Reset = findViewById(R.id.BtnLogin);
        Signin =findViewById(R.id.TXTLogin);
        Db = new DBHelper(this);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = Reset.getText().toString();
                if(str.equals("Verify User")){
                    String User =  Uname.getText().toString();
                    if(User.equals("")){
                        Toast.makeText(ForgotPassword.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Boolean checkuser = Db.checkusername(User);
                        if(checkuser==false){
                            Toast.makeText(ForgotPassword.this, "User does not exists!!!", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Uname.setText(User);
                            Uname.setEnabled(false);

                            Pass.setVisibility(View.VISIBLE);
                            Cpass.setVisibility(View.VISIBLE);
                            Reset.setText("Reset Password");
                        }
                    }
                }
                else if(str.equals("Reset Password")){
                    String User =  Uname.getText().toString();
                    String Password =  Pass.getText().toString();
                    String Cpassword =  Cpass.getText().toString();
                    if(Password.equals("")||Cpassword.equals("")){
                        Toast.makeText(ForgotPassword.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(Password.equals(Cpassword)){
                            Boolean update = Db.Updatedata(User,Password);
                            if(update == true){
                                Toast.makeText(ForgotPassword.this, "Password updated successfully, Please Login!!!", Toast.LENGTH_SHORT).show();
                                Uname.setText("");
                                Uname.setEnabled(true);

                                Pass.setVisibility(View.GONE);
                                Cpass.setVisibility(View.GONE);
                                Reset.setText("Verify User");
                                Intent intent=new Intent(getApplicationContext(), Login.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(ForgotPassword.this, "Update Password Failed!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(ForgotPassword.this, "Password does not match the Confirm Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });


    }
}
