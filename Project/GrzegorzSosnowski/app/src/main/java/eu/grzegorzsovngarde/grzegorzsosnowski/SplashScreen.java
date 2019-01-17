package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    public  boolean condition = false;
    public int SPLASH_WAIT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        if(savedInstanceState != null) {
            condition = savedInstanceState.getBoolean("condition");
            cancelSplash();
        }
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!condition)
                        cancelSplash();

                }
            }, SPLASH_WAIT);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(!condition)
            cancelSplash();
    }

    private void cancelSplash() {
        condition = true;
        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("condition",true);
    }
}


