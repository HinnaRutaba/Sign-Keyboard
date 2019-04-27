package com.example.slate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class AlphabetsAdapter extends ArrayAdapter<Alphabets>
{
    private List<Alphabets> alphabetsFull;

    public AlphabetsAdapter(@NonNull Context context , @NonNull List<Alphabets> alphabetsList) {
        super(context, 0, alphabetsList);

        alphabetsFull = new ArrayList<>(alphabetsList);

    }



}
