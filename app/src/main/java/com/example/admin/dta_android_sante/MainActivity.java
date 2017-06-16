package com.example.admin.dta_android_sante;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.dta_android_sante.database.datasource.DataSource;
import com.example.admin.dta_android_sante.database.modele.User;
import com.google.gson.Gson;

public class MainActivity extends FragmentActivity {

    DataSource<User> dataSource;

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
        Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        String flux = data.getStringExtra("NEWUSER"); // Tester si pas null ;-)
        User utilisateur = new Gson().fromJson(flux, User.class);

        try {
            dataSource.insert(utilisateur);
        } catch (Exception e) {
            // Que faire :-(
            e.printStackTrace();
        }

        // Indiquer un changement au RecycleView
        //chargerUtilisateurs();
        //adapter.notifyDataSetChanged();
    }
}
