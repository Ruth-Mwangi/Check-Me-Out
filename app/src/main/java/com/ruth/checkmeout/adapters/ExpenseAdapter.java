package com.ruth.checkmeout.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.ruth.checkmeout.models.Expense;

import java.util.ArrayList;

public class ExpenseAdapter extends ArrayAdapter {
    private Context mContext;
    //private String[] months;
    private ArrayList<Expense> expenses;

    public ExpenseAdapter(Context mContext, int resource,ArrayList<Expense> expenses) {
        super(mContext, resource);
        this.mContext=mContext;
        //this.months = months;
        this.expenses = expenses;
    }
    @Override
    public Object getItem(int position) {
        //String month=months[position];
        int expense=expenses.get(position).getTotal();
        int month=expenses.get(position).getLocalDate().getMonth();
        return String.format("%s \n %d KES",month,expense);
    }
    @Override
    public int getCount() {
        return expenses.size();
    }
}
