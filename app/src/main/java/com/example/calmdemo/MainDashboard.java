package com.example.calmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainDashboard extends AppCompatActivity {

    private Button button;
    private ImageView img22;
    private ImageView img23;
    private ImageView img24;
    private ImageView img25;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        img22=(ImageView) findViewById(R.id.imageView4a);
        img23=(ImageView) findViewById(R.id.imageView41);
        img24=(ImageView) findViewById(R.id.imageView42);
        img25=(ImageView) findViewById(R.id.imageView43);
        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArdashboard();
            }
        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openbreath();
           }
       });
        img24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openyoga();
            }
        });
        img25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMusic();
            }
        });

    }




    public void openMusic()
    {
        Intent intent=new Intent(this,Music.class);
        startActivity(intent);
    }


    public void openArdashboard()
    {
        Intent intent=new Intent(this,Dashboard.class);
        startActivity(intent);
    }

    public void openyoga()
    {
        Intent intent=new Intent(this,yogadashboard.class);
        startActivity(intent);
    }



    public void openbreath()
    {
        Intent intent=new Intent(this,Breath.class);
        startActivity(intent);
    }


//    public void openArtimegame()
//    {
//        Intent intent=new Intent(this,ARCoreTime.class);
//        startActivity(intent);
//    }

}
