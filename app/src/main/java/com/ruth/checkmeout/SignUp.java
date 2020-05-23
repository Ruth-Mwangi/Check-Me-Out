package com.ruth.checkmeout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private ActionBarDrawerToggle t;
    @BindView(R.id.activity_main)
    DrawerLayout dl;
    @BindView(R.id.navigation)
    NavigationView nv;
    @BindView(R.id.signUpEmail)
    EditText signUpEmail;
    @BindView(R.id.signUpName)
    EditText signUpName;
    @BindView(R.id.signUpPassword)
    EditText signUpPassword;
    @BindView(R.id.signUpbutton)
    Button signUpButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ButterKnife.bind(this);
        t=new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){

                    case R.id.about:
                        Toast.makeText(SignUp.this, "About",Toast.LENGTH_SHORT).show();break;
                    case R.id.expenses:
                        Toast.makeText(SignUp.this, "Expenses",Toast.LENGTH_SHORT).show();break;
                    case R.id.shop:
                        Toast.makeText(SignUp.this, "Shop",Toast.LENGTH_SHORT).show();break;

                    case R.id.account:
                        Toast.makeText(SignUp.this, "My Account",Toast.LENGTH_SHORT).show();break;

                    case  R.id.home:
                        Toast.makeText(SignUp.this, "Home",Toast.LENGTH_SHORT).show();break;

                    default:
                        return true;
                }
                return true;
            }
        });
        signUpButton.setOnClickListener(this);

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


    @Override
    public void onClick(View v) {
        if(v==signUpButton){
            String name=signUpName.getText().toString();
            String email=signUpEmail.getText().toString();
            String password=signUpPassword.getText().toString();
            Intent intent=new Intent(SignUp.this,LogIn.class);
            intent.putExtra("email",email);
            intent.putExtra("password",password);
            startActivity(intent);

        }
    }
}
