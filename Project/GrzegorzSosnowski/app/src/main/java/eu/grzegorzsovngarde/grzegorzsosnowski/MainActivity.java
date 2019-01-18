package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load layout for onCreate instance
        setContentView(R.layout.activity_main);
        findViewById(R.id.button);
    }

    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

    public void onClick(View v) {
        final EditText editText = (EditText) findViewById(R.id.editText);
        String login = editText.getText().toString();
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        String password = editText2.getText().toString();

        String lPATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String pPATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        Pattern lpattern = Pattern.compile(lPATTERN);
        Pattern ppattern = Pattern.compile(pPATTERN);
        Matcher lmatcher = lpattern.matcher(login);
        Matcher pmatcher = ppattern.matcher(password);
        boolean lvalid = lmatcher.matches();
        boolean pvalid = pmatcher.matches();
        if(!lvalid||!pvalid) {
            editText.setText(getString(R.string.incorrect_credentials));
        }
        else {
            Intent mainScreenIntent = new Intent(this, Mainscreen.class);
            this.startActivity(mainScreenIntent);
        }
    }
}

