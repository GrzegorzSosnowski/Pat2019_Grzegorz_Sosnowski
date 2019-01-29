package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    public  boolean splashcondition = false;
    public int SPLASH_WAIT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        boolean signedIn = pref.getBoolean("SignedIn", false);
        if(!signedIn) {
            if (savedInstanceState != null) {
                splashcondition = savedInstanceState.getBoolean("splashcondition");
                cancelSplash();
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!splashcondition)
                            cancelSplash();

                    }
                }, SPLASH_WAIT);
            }
        }
        else {
            Boolean isSignedin = true;
            Intent mainScreenIntent = new Intent(this, Mainscreen.class);
            mainScreenIntent.putExtra("isSignedin",isSignedin);
            this.startActivity(mainScreenIntent);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(!splashcondition)
            cancelSplash();
    }

    private void cancelSplash() {
        splashcondition = true;
        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("splashcondition",true);
    }
}


