package com.ruth.checkmeout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle t;

    @BindView(R.id.activity_main)DrawerLayout dl;
    @BindView(R.id.navigation) NavigationView nv;
    //@BindView(R.id.signInLink) TextView signIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ButterKnife.bind(this);

        //dl=(DrawerLayout)findViewById(R.id.activity_main);
        //signIn=(TextView)findViewById(R.id.signInLink);

        t=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //nv=(NavigationView) findViewById(R.id.navigation);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent loginIntent=getIntent();
                int id=item.getItemId();
                switch (id){
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home",Toast.LENGTH_SHORT).show();break;
                    case R.id.about:
                        Toast.makeText(MainActivity.this, "About",Toast.LENGTH_SHORT).show();break;
                    case R.id.expenses:
                        Toast.makeText(MainActivity.this, "Expenses",Toast.LENGTH_SHORT).show();break;
                    case R.id.shop:
                        Toast.makeText(MainActivity.this, "Shop",Toast.LENGTH_SHORT).show();break;

                    case R.id.account:
                        Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity.this,MyAccount.class);
                        intent.putExtra("name",loginIntent.getStringExtra("name"));
                        intent.putExtra("email",loginIntent.getStringExtra("email"));
                        startActivity(intent);break;
                    case R.id.signInLink:
                        Intent signInIntent=new Intent(MainActivity.this,LogIn.class);
                        startActivity(signInIntent);

                    default:
                        return true;
                }
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
