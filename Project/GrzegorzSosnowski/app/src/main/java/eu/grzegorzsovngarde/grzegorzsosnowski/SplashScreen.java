package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;



public class SplashScreen extends AppCompatActivity {
    public int condition = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        int SPLASH_WAIT = 5000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (condition==1)
                    cancelSplash();

            }
        }, SPLASH_WAIT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        condition=0;
        cancelSplash();
    }

    private void cancelSplash() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }

}


