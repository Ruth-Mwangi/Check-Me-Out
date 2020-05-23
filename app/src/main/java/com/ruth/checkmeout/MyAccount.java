package com.ruth.checkmeout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAccount extends AppCompatActivity {

    @BindView(R.id.profileName) TextView profileName;
    @BindView(R.id.profileEmail) TextView profileEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        ButterKnife.bind(this);
        Intent intent=getIntent();

        profileName.setText(intent.getStringExtra("name"));
        profileEmail.setText(intent.getStringExtra("email"));





    }
}
