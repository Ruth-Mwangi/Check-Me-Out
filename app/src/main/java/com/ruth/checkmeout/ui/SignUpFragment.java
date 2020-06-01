package com.ruth.checkmeout.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ruth.checkmeout.R;
import com.ruth.checkmeout.models.CheckMeOutSearchResponse;
import com.ruth.checkmeout.networks.CheckMeOutApi;
import com.ruth.checkmeout.networks.CheckMeOutClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpFragment extends Fragment implements View.OnClickListener{
    private Class fragmentClass;
    private Fragment fragment = null;
    @BindView(R.id.signUpEmail)
    EditText signUpEmail;
    @BindView(R.id.signUpName)
    EditText signUpName;
    @BindView(R.id.signUpPassword)
    EditText signUpPassword;
    @BindView(R.id.signUpbutton)
    Button signUpButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_sign_up,container,false);

        ButterKnife.bind(this,view);
        signUpButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v==signUpButton){
            String name=signUpName.getText().toString();
            String email=signUpEmail.getText().toString();
            String password=signUpPassword.getText().toString();

            Bundle bundle=new Bundle();
            bundle.putString("name",name);
            bundle.putString("email",email);
            bundle.putString("password",password);
            fragmentClass=LogInFragment.class;
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
}
