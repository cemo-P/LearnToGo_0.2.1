package com.example.cemo1.menuwithwelcomescreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

public class MatheAufgabeFragment extends Fragment implements View.OnClickListener {
    View view;
    private TextView tvZahl1,tvZahl2;
    private int x,y,z,a,b;
    public Timer timer;
    public Button start;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout. fragment_mathe_aufgabe, container, false);
        tvZahl1 = view.findViewById(R.id. tvz1);
        tvZahl2 = view.findViewById(R.id. tvz2);


        start = view.findViewById(R.id. btnStrt);
        start.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        Random zu = new Random();
        x = zu.nextInt(10)+1;
        y = zu.nextInt(20)+1;
        String s = String.valueOf(x);
        String s1 = String.valueOf(y);
        tvZahl1.setText(s);
        tvZahl2.setText(s1);


    }
}
