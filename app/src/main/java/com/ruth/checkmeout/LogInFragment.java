package com.ruth.checkmeout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogInFragment extends Fragment implements View.OnClickListener {
    private Class fragmentClass;
    private Fragment fragment = null;
    @BindView(R.id.activity_main)
    DrawerLayout dl;
    @BindView(R.id.navigation)
    NavigationView nv;
    @BindView(R.id.link_signup)
    TextView link_signup;
    @BindView(R.id.logInButton)
    Button logInButton;
    @BindView(R.id.logInEmail)
    EditText logInEmail;
    @BindView(R.id.logInPassword) EditText logInPassword;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_login,container,false);
        ButterKnife.bind(this,view);

        link_signup.setOnClickListener(this);
        logInButton.setOnClickListener(this);

        Intent intent=getActivity().getIntent();
        logInEmail.setText(intent.getStringExtra("email"));
        logInPassword.setText(intent.getStringExtra("password"));
        //profileHeadName.setText(intent.getStringExtra("name"));
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==link_signup){
//            Intent intent=new Intent(getActivity(),SignUp.class);
//            startActivity(intent);
            fragmentClass=SignUpFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            //dl.closeDrawers();


        }
        else if(v==logInButton){
            Intent signUpIntent=getActivity().getIntent();
            Intent intent=new Intent(getActivity(),MainActivity.class);
            intent.putExtra("name",signUpIntent.getStringExtra("name"));
            intent.putExtra("email",signUpIntent.getStringExtra("email"));
            startActivity(intent);


        }

    }
}
