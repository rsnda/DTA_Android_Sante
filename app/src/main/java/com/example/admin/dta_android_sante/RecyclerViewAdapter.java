package com.example.admin.dta_android_sante;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.example.admin.dta_android_sante.database.modele.User;

/**
 * Created by admin on 15/06/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    /**
     * List items
     */
    private List<User> items;
    /**
     * the resource id of item Layout
     */
    private int itemLayout;

    private Fragment fragment;

    /**
     * Constructor RecyclerSimpleViewAdapter
     * @param items : the list items
     * @param itemLayout : the resource id of itemView
     */
    public RecyclerViewAdapter(List<User> items, int itemLayout, Fragment f) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.fragment = f;
    }

    /**
     * Create View Holder by Type
     * @param parent, the view parent
     * @param viewType : the type of View
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // get inflater and get view by resource id itemLayout
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        // return ViewHolder with View
        return new ViewHolder(v);
    }

    /**
     * Get the size of items in adapter
     * @return the size of items in adapter
     */
    @Override
    public int getItemCount() {
        return items.size();
    }
    /**
     * Bind View Holder with Items
     * @param holder: the view holder
     * @param position : the current position
     */
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {
        // find item by position
        User item = items.get(position);
        // save information in holder, we have ne type in this adapter
        holder.primaryText.setText(item.getNom());
        holder.primaryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UtilisateurFragment articleFrag = (UtilisateurFragment)
                        fragment.getFragmentManager().findFragmentById(R.id.article_fragment);

                if (articleFrag != null) {
                    articleFrag.updateArticleView(position);
                } else {
                    UtilisateurFragment newFragment = new UtilisateurFragment();
                    Bundle args = new Bundle();
                    args.putInt(UtilisateurFragment.ARG_POSITION, position);
                    newFragment.setArguments(args);
                    FragmentTransaction transaction = fragment.getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }

        });
        holder.itemView.setTag(item);

        // Alterne les couleurs du recycler (1 couleur clair / 1 couleur sombre)
        if ((position % 2) == 0) {
            holder.itemView.setBackgroundResource(R.color.colorPrimary);
        } else {
            holder.itemView.setBackgroundResource(R.color.colorPrimaryDark);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // TextViex
        public TextView primaryText;
        /**
         * Constructor ViewHolder
         * @param itemView: the itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);
            // link primaryText
           // primaryText = (TextView) itemView.findViewById(R.id.);
        }
    }
}

