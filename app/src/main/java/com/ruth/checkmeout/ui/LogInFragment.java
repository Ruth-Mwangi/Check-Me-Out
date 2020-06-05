package com.ruth.checkmeout.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.ruth.checkmeout.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogInFragment extends Fragment implements View.OnClickListener {
    private Class fragmentClass;
    private Fragment fragment = null;
    private String email;
    private String name;
    private String password;
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
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private ProgressDialog mAuthProgressDialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_login,container,false);
        ButterKnife.bind(this,view);

        link_signup.setOnClickListener(this);
        logInButton.setOnClickListener(this);

        Bundle bundle = this.getArguments();
        if(bundle!=null){
            email = bundle.getString("email");
            name = bundle.getString("name");
            password = bundle.getString("password");
            logInEmail.setText(email);
            logInPassword.setText(password);

        }
        //Log.i(TAG, "onCreateView: "+ email);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==link_signup){
            fragmentClass=SignUpFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


        }
        else if(v==logInButton){
            Bundle bundle = new Bundle();
            email=logInEmail.getText().toString();
            password=logInPassword.getText().toString();
            bundle.putString("name",email);
            bundle.putString("email",email);
            fragmentClass=MyAccountFragment.class;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
                fragment.setArguments(bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        }

    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
}
