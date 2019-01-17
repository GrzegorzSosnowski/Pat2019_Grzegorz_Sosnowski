package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load layout for onCreate instance
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

}

