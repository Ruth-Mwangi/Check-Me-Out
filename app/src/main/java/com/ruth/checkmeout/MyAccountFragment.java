package com.ruth.checkmeout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class MyAccountFragment extends Fragment {
    @BindView(R.id.profileName)
    TextView profileName;
    @BindView(R.id.profileEmail) TextView profileEmail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_my_account,container,false);
        ButterKnife.bind(this,view);
        Bundle bundle = this.getArguments();
        if(bundle!=null){
            profileName.setText(bundle.getString("name"));
            profileEmail.setText(bundle.getString("email"));


        }
        return view;
    }
}
