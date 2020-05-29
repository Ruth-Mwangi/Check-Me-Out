package com.ruth.checkmeout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShopFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.btnScan)
    FloatingActionButton btnScan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this,view);
        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        btnScan.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        if(v==btnScan){
            Snackbar.make(v, "FB clicked", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }

    }
}
