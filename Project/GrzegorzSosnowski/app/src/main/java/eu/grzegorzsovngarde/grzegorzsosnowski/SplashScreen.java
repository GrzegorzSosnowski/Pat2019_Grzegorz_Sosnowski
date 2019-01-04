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


    Timer sTimer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // splashTimer();

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        sCondition();
    }

    private void splashTimer() {


        try {
            Thread.sleep(5000);
            sCondition();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    private TimerTask sCondition() {
        sTimer.cancel();

        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
        this.finish();

        return null;
    }

}


