package com.ruth.checkmeout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpensesFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.expenseList)
    ListView expenseList;

    private String[] months=new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
    private int[] expenses=new int[]{1000,1800,2000,3000,5000,1000,4990,1234,2000,1299,4267,7464};
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_expenses,container,false);
        ButterKnife.bind(this,view);
        ExpenseAdapter adapter1=new ExpenseAdapter(view.getContext(),android.R.layout.simple_list_item_1,months,expenses);
        expenseList.setAdapter(adapter1);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
