package com.ruth.checkmeout;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ExpenseAdapter extends ArrayAdapter {
    private Context context;
    private String[] months;
    private int[] expenses;

    public ExpenseAdapter(Context context, int resource, String[] months, int[] expenses) {
        super(context, resource);
        this.context=context;
        this.months = months;
        this.expenses = expenses;
    }
    @Override
    public Object getItem(int position) {
        String month=months[position];
        int expense=expenses[position];
        return String.format("%s \n %d KES",month,expense);
    }
}
