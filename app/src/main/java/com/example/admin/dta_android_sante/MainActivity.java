package com.example.admin.dta_android_sante;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste);

        if (findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null) {
                return;
            }

            ListeUtilisateurFragment firstFragment = new ListeUtilisateurFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();

        }
    }

    // Triggered when the Floating Action Button is clicked
    public void onFABClick(View view){
        Log.d("FAB", "I was clicked");
        Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
        startActivity(intent);
    }
}
