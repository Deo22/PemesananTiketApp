package com.wahidev.baru.firstbelajarapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    Animation app_splash, btt;
    ImageView app_logo;
    TextView app_subtitle;

    DatabaseReference reference, reference2;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //load animation
        app_splash = AnimationUtils.loadAnimation(this,R.anim.app_splash);
        btt = AnimationUtils.loadAnimation(this,R.anim.btt);

        //load element
        app_logo = findViewById(R.id.app_logo);
        app_subtitle = findViewById(R.id.app_subtitle);

        //run animation
        app_logo.startAnimation(app_splash);
        app_subtitle.startAnimation(btt);

        getUsernameLocal();

    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key,"");
        if(username_key_new.isEmpty()){
            //setting timer splash screen selama 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //mengubah activity ke activity lain
                    Intent gogetstarted = new Intent(MainActivity.this, GetStartedAct.class);
                    startActivity(gogetstarted);
                    finish();
                }
            }, 2000);
        }else {
            //setting timer splash screen selama 2 detik
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //mengubah activity ke activity lain
                    Intent gogetstarted = new Intent(MainActivity.this, HomeAct.class);
                    startActivity(gogetstarted);
                    finish();
                }
            }, 2000);
        }
    }
}
