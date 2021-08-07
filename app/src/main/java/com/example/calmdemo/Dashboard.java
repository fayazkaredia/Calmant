package com.example.calmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    private Button button;
    private ImageView img;
    private ImageView img1;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        img=(ImageView) findViewById(R.id.imageView1);
        img1=(ImageView) findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArgame();
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArtimegame();
            }
        });

    }





    public void openArgame()
    {
        Intent intent=new Intent(this,ARCore.class);
        startActivity(intent);
    }


    public void openArtimegame()
    {
        Intent intent=new Intent(this,ARCoreTime.class);
        startActivity(intent);
    }




}
