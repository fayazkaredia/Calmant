package com.example.calmdemo;

import android.content.Intent;
import android.graphics.Point;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;

import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.sceneform.Camera;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.collision.Ray;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.rendering.Texture;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.Random;

public class ARCore extends AppCompatActivity {

    private Scene scene;
    private Camera camera;
    private ModelRenderable bulletRenderable;
    //private boolean shouldStartTimer = true;
    //private int balloonsLeft = 20;
    private Point point;
    //private TextView balloonsLeftTxt;
    private SoundPool soundPool;
    private int sound;
    private Button button2;
    private Node MainNode;
    private int flag=0;
    CustomArFragment arFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getRealSize(point);

        setContentView(R.layout.activity_arcore);
        button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });
        loadSoundPool();

        //balloonsLeftTxt = findViewById(R.id.balloonsCntTxt);
       arFragment =
                (CustomArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);


        scene = arFragment.getArSceneView().getScene();
        camera = scene.getCamera();

        addBalloonsToScene();
       // buildBulletModel();


        Button shoot = findViewById(R.id.shootButton);

        shoot.setOnClickListener(v -> {

//            if (shouldStartTimer) {
//                startTimer();
//                shouldStartTimer = false;
//            }

            shoot();

        });


        Button shoot1 = findViewById(R.id.shootButton1);

        shoot1.setOnClickListener(v -> {

//            if (shouldStartTimer) {
//                startTimer();
//                shouldStartTimer = false;
//            }

            shoot1();

        });

        Button shoot2 = findViewById(R.id.shootButton2);

        shoot2.setOnClickListener(v -> {

//            if (shouldStartTimer) {
//                startTimer();
//                shouldStartTimer = false;
//            }

            shoot2();

        });




    }

    public void openDashboard()
    {
        Intent intent=new Intent(this,Dashboard.class);
        startActivity(intent);
    }

    private void loadSoundPool() {

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build();

        sound = soundPool.load(this, R.raw.blop_sound, 1);

    }



    private void shoot2() {

        Ray ray = camera.screenPointToRay(point.x / 2f, point.y / 2f);
        Node node = new Node();
        //node.setRenderable(bulletRenderable);
        //scene.addChild(node);

        ModelRenderable.builder()
                .setSource(this, R.raw.sandals)
                .build()
                .thenAccept( renderable -> {
                    node.setRenderable(renderable);

                    scene.addChild(node);

                });

        new Thread(() -> {

            for (int i = 0;i < 200;i++) {

                int finalI = i;
                runOnUiThread(() -> {

                    Vector3 vector3 = ray.getPoint(finalI * 0.1f);
                    node.setWorldPosition(vector3);

                    Node nodeInContact = scene.overlapTest(node);

                    if (nodeInContact != null) {

//                        balloonsLeft--;
//                        balloonsLeftTxt.setText("Balloons Left: " + balloonsLeft);
//                        scene.removeChild(nodeInContact);

                        soundPool.play(sound, 1f, 1f, 1, 0
                                , 1f);
                        scene.removeChild(MainNode);

                        flag =1;

                        addBalloonsToScene();

                    }

                });

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            runOnUiThread(() -> scene.removeChild(node));

        }).start();

    }








    private void shoot1() {

        Ray ray = camera.screenPointToRay(point.x / 2f, point.y / 2f);
        Node node = new Node();
        //node.setRenderable(bulletRenderable);
        //scene.addChild(node);

        ModelRenderable.builder()
                .setSource(this, R.raw.model)
                .build()
                .thenAccept( renderable -> {
                    node.setRenderable(renderable);

                    scene.addChild(node);

                });

        new Thread(() -> {

            for (int i = 0;i < 200;i++) {

                int finalI = i;
                runOnUiThread(() -> {

                    Vector3 vector3 = ray.getPoint(finalI * 0.1f);
                    node.setWorldPosition(vector3);

                    Node nodeInContact = scene.overlapTest(node);

                    if (nodeInContact != null) {

//                        balloonsLeft--;
//                        balloonsLeftTxt.setText("Balloons Left: " + balloonsLeft);
//                        scene.removeChild(nodeInContact);

                        soundPool.play(sound, 1f, 1f, 1, 0
                                , 1f);
                        scene.removeChild(MainNode);

                        flag =1;

                        addBalloonsToScene();

                    }

                });

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            runOnUiThread(() -> scene.removeChild(node));

        }).start();

    }


    private void shoot() {

        Ray ray = camera.screenPointToRay(point.x / 2f, point.y / 2f);
        Node node = new Node();
        //node.setRenderable(bulletRenderable);
        //scene.addChild(node);

        ModelRenderable.builder()
                .setSource(this, R.raw.boxing)
                .build()
                .thenAccept( renderable -> {
                    node.setRenderable(renderable);

                    scene.addChild(node);

                });

        new Thread(() -> {

            for (int i = 0;i < 200;i++) {

                int finalI = i;
                runOnUiThread(() -> {

                    Vector3 vector3 = ray.getPoint(finalI * 0.1f);
                    node.setWorldPosition(vector3);

                    Node nodeInContact = scene.overlapTest(node);

                    if (nodeInContact != null) {

//                        balloonsLeft--;
//                        balloonsLeftTxt.setText("Balloons Left: " + balloonsLeft);
//                        scene.removeChild(nodeInContact);

                        soundPool.play(sound, 1f, 1f, 1, 0
                                , 1f);
                        scene.removeChild(MainNode);

                        flag =1;

                        addBalloonsToScene();

                    }

                });

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            runOnUiThread(() -> scene.removeChild(node));

        }).start();

    }

//    private void startTimer() {
//
//        TextView timer = findViewById(R.id.timerText);
//
//        new Thread(() -> {
//
//            int seconds = 0;
//
//            while (balloonsLeft > 0) {
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                seconds++;
//
//                int minutesPassed = seconds / 60;
//                int secondsPassed = seconds % 60;
//
//                runOnUiThread(() -> timer.setText(minutesPassed + ":" + secondsPassed));
//
//            }
//
//        }).start();
//
//    }

//    private void buildBulletModel() {
//
//        Texture
//                .builder()
//                .setSource(this, R.drawable.pubgg)
//                .build()
//                .thenAccept(texture -> {
//
//
//                    MaterialFactory
//                            .makeOpaqueWithTexture(this, texture)
//                            .thenAccept(material -> {
//                                Vector3 vector3 = new Vector3(0.50f, 0.50f,0.50f);
//                                bulletRenderable = ShapeFactory.makeCube(vector3, Vector3.zero(), material);
//
//
//                            });
//
//
//                });
//
//    }

    private void addBalloonsToScene() {

        ModelRenderable
                .builder()
                .setSource(this,R.raw.p)
                .build()
                .thenAccept(renderable -> {

                    MainNode = new Node();
                    TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
                    transformableNode.setParent(MainNode);
                    transformableNode.setRenderable(renderable);
                    scene.addChild(MainNode);
                    if(flag ==0){
                        MainNode.setLocalPosition(new Vector3((float)0.00,(float)-5.00,(float) -10));

                    }
                    else {
                        int[] a = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                        Random random = new Random();
                        int i = random.nextInt(20) - 1;
                        MainNode.setLocalPosition(new Vector3((float) a[i], (float) -5.00, (float) -10));
                    }

                });

    }
}
