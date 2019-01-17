package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load layout for onCreate instance
        setContentView(R.layout.activity_main);
        //EditText editText = (EditText)findViewById(R.id.editText);
        //EditText editText2 = (EditText)findViewById(R.id.editText2);
        findViewById(R.id.button);
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

    public void onClick(View v) {
        Intent mainScreenIntent = new Intent(this,Mainscreen.class);
        this.startActivity(mainScreenIntent);

    }
}

