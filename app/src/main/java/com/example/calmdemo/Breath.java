package com.example.calmdemo;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import java.util.Random;

public class Breath extends AppCompatActivity {

    MediaPlayer player;
    ImageView IVBreathe;
    String[] Breathe = {"breathe1","breathe2","breathe3","breathe4","breathe5","breathe6","breathe7"};
    Random random =  new Random();
    int i, BreatheCount=0;
    Button BtnBreathe;
    TextView TxtIHEMain;

    TextView TxtCount,TxtBreatheCount;
    CountDownTimer count;
    Animation Inhale;
    Animation Hold1;
    Animation Exhale;
    Animation Hold2;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breath);

        IVBreathe = findViewById(R.id.IVBreathe);
        BtnBreathe = findViewById(R.id.BtnBreathe);

        TxtIHEMain = findViewById(R.id.TxtIHEMain);
        TxtCount =  findViewById(R.id.TxtCount);
        TxtBreatheCount =  findViewById(R.id.TxtBreatheCount);
        BtnBreathe.setText("Breathe");
        Inhale = AnimationUtils.loadAnimation(Breath.this,R.anim.fadein);
        Hold1 = AnimationUtils.loadAnimation(Breath.this,R.anim.hold);
        Exhale = AnimationUtils.loadAnimation(Breath.this,R.anim.fadeout);
        Hold2 = AnimationUtils.loadAnimation(Breath.this,R.anim.hold);

        TxtBreatheCount.setText("No. of Breathe's Taken: "+BreatheCount);

        i =  random.nextInt(7);
        res=getResources();

        IVBreathe.setImageResource(res.getIdentifier(Breathe[i],"drawable",getPackageName()));
        count = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int Count = ((int) millisUntilFinished/1000);
                TxtCount.setText(""+Count);
            }

            @Override
            public void onFinish() {
                TxtCount.setVisibility(View.GONE);
                TxtIHEMain.setVisibility(View.VISIBLE);

                Breathe1();
            }
        };
        BtnBreathe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BtnBreathe.getText().toString().equals("Breathe")) {
                    BtnBreathe.setText("Stop");

                    count.start();

                }else if(BtnBreathe.getText().toString().equals("Stop")){
                    TxtIHEMain.setVisibility(View.GONE);
                    TxtIHEMain.clearAnimation();
                    TxtCount.setText("");
                    TxtCount.setVisibility(View.VISIBLE);

                    BtnBreathe.setText("Breathe");

                    BreatheCount=0;
                    TxtBreatheCount.setText("No. of Breathe's Taken: "+BreatheCount);
                }

            }
        });
    }


    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.deepmeditation);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    public void pause(View v) {
        if (player != null) {
            player.pause();
        }
    }

    public void stop(View v) {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }








    public void Breathe1() {


        TxtIHEMain.startAnimation(Inhale);
        Inhale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TxtIHEMain.clearAnimation();
                TxtIHEMain.setText("Hold");
                TxtIHEMain.startAnimation(Hold1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Hold1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TxtIHEMain.clearAnimation();
                TxtIHEMain.setText("Exhale");
                TxtIHEMain.startAnimation(Exhale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Exhale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                TxtIHEMain.clearAnimation();
                TxtIHEMain.setText("Hold");
                TxtIHEMain.startAnimation(Hold2);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Hold2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                BreatheCount++;
                TxtBreatheCount.setText("No. of Breathe's Taken: "+BreatheCount);
                i =  random.nextInt(7);
                res=getResources();

                IVBreathe.setImageResource(res.getIdentifier(Breathe[i],"drawable",getPackageName()));
                TxtIHEMain.clearAnimation();
                TxtIHEMain.setText("Inhale");
                TxtIHEMain.startAnimation(Inhale);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
