package com.ruth.checkmeout.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.*;
import java.time.ZoneId;
import java.util.Date;

public class Expense {

    private int total;
    //private Date date=new Date();
    private LocalDate localDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Expense(int total) {
        this.total = total;
        this.localDate = LocalDate.now();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
