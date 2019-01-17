package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Mainscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        findViewById(R.id.button2);
    }
    public void onClick(View v) {
        Intent mainIntent = new Intent(this,MainActivity.class);
        this.startActivity(mainIntent);

    }
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
