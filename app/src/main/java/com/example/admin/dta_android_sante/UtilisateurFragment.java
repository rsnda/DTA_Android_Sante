package com.example.admin.dta_android_sante;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by admin on 16/06/2017.
 */

public class UtilisateurFragment extends Fragment{
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    TextView article;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState) {
        if(savedInstaceState != null) {
            mCurrentPosition = savedInstaceState.getInt(ARG_POSITION);
        }
        View view = inflater.inflate(R.layout.utilisateur, container, false);
        article = (TextView) view.findViewById(R.id.article);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position) {
        if (article != null) {
            article.setText("");
            mCurrentPosition = position;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
