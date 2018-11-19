package com.example.cemo1.menuwithwelcomescreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class MatheAufgabeFragment extends MatheFragment implements View.OnClickListener {
    View view;
    private TextView tvZahl1,tvZahl2, zeit,punkt;
    private EditText ergbebnis;
    private int x,y,z;
    public Button start;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout. fragment_mathe_aufgabe, container, false);
        tvZahl1 = view.findViewById(R.id. tvz1);
        tvZahl2 = view.findViewById(R.id. tvz2);
        zeit = view.findViewById(R.id.tvTime);
        punkt = view.findViewById(R.id.tvPunktStand);
        ergbebnis = view.findViewById(R.id.etErgebnis);
        String ss = String.valueOf(a);
        punkt.setText(ss);



        start = view.findViewById(R.id. btnStrt);
        start.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        Random zu = new Random();

        int i = 0;
        do {

            x = zu.nextInt(a - b) + 1;
            y = zu.nextInt(a - b) + 1;
            String s = String.valueOf(x);
            String s1 = String.valueOf(y);
            tvZahl1.setText(s);
            tvZahl2.setText(s1);
            i++;
        }while(i<c);


    }
}
