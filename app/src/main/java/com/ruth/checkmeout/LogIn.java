package com.ruth.checkmeout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogIn extends AppCompatActivity {
    private Context context;
    private ActionBarDrawerToggle t;

    @BindView(R.id.activity_main) DrawerLayout dl;
    @BindView(R.id.navigation) NavigationView nv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ButterKnife.bind(this);
        t=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
