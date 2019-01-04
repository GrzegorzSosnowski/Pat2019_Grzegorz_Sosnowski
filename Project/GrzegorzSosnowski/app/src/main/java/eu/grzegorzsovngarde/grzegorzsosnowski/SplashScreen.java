package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private int SPLASH_WAIT = 5000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                cancelSplash();
            }
        }, SPLASH_WAIT);
    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();
        cancelSplash();


    }






    private void cancelSplash() {


        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
        this.finish();


    }

}


