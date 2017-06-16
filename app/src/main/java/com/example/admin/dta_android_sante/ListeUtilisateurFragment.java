package com.example.admin.dta_android_sante;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.dta_android_sante.database.modele.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 16/06/2017.
 */

public class ListeUtilisateurFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter rvAdapter;
    private List<User> utilisateurs = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {

        View view = inflater.inflate(R.layout.list_utilisateurs, container, false);

        // Instanciation du recyclerview :
        recyclerView = (RecyclerView) view;

        rvAdapter = new RecyclerViewAdapter(utilisateurs, android.R.layout.simple_list_item_1, this);
        recyclerView.setAdapter(rvAdapter);

        return view;
    }



}
