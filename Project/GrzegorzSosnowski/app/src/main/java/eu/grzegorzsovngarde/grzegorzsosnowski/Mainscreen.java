package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Mainscreen extends AppCompatActivity {
   public Boolean isSignedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        findViewById(R.id.button2);
        //Receiving data from previous activity
        Bundle status = getIntent().getExtras();
        if (status != null) {
            isSignedin = status.getBoolean("isSignedin");
            }
    }
    public void onClick(View v) {
        String Signout = "Signed Out";
        //Perform sign out only if user was signed in
        if(isSignedin) {
            //Pass information that user was signed out
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("Signout",Signout);
            this.startActivity(mainIntent);
        }
    }
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
