package eu.grzegorzsovngarde.grzegorzsosnowski;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import eu.grzegorzsovngarde.grzegorzsosnowski.adapter.CustomAdapter;
import eu.grzegorzsovngarde.grzegorzsosnowski.model.RetroPhoto;
import eu.grzegorzsovngarde.grzegorzsosnowski.network.GetDataService;
import eu.grzegorzsovngarde.grzegorzsosnowski.network.RetrofitClientInstance;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Mainscreen extends AppCompatActivity {
        public Boolean isSignedin;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    ProgressDialog progressDoalog;


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
        progressDoalog = new ProgressDialog(Mainscreen.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {

            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDoalog.dismiss();
               generateDataList(response.body());



            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(Mainscreen.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onClick(View v) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        String Signout = "Signed Out";
        //Perform sign out only if user was signed in
        if(isSignedin) {
            //Pass information that user was signed out
            Intent mainIntent = new Intent(this, MainActivity.class);
            mainIntent.putExtra("Signout",Signout);
            pref.edit().remove("SignedIn").apply();
            this.startActivity(mainIntent);
        }
    }
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPhoto> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Mainscreen.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
