package edu.upi.cs.sukidaa.fluida;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView logo_holder;
    Animation anim_logo;
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo_holder = (ImageView) findViewById(R.id.title);
        logo_holder.setVisibility(View.INVISIBLE);
        anim_logo = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_pop_out);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, Premateri.class);
                startActivity(i);
                finish();
                overridePendingTransition(R.anim.fade_in_activity,R.anim.fade_out_activity);
            }
        }, SPLASH_TIME_OUT);
    }
    protected void onStart(){
        super.onStart();

    }


    protected void onPause() {
        super.onPause();
        logo_holder.setVisibility(View.INVISIBLE);
    }

    protected void onResume() {
        super.onResume();
        logo_holder.startAnimation(anim_logo);

        Handler handler = new Handler();
        Runnable startMain = new Runnable() {

            @Override
            public void run() {
                if (!isFinishing()){

                }
            }
        };

        handler.postDelayed(startMain, 200);
    }
}
