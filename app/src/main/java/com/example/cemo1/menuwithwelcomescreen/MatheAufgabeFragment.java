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
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class MatheAufgabeFragment extends MatheFragment implements View.OnClickListener {
    View view;
    private TextView tvZahl1,tvZahl2, operand, zeit,punkt;
    private EditText ergebnis,etOG, etUG, etTime,etAnzahlAufgabe;
    public Button start;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout. fragment_mathe_aufgabe, container, false);
        tvZahl1 = view.findViewById(R.id. tvz1);
        tvZahl2 = view.findViewById(R.id. tvz2);
        zeit = view.findViewById(R.id.tvTime);
        punkt = view.findViewById(R.id.tvPunktStand);
        ergebnis = view.findViewById(R.id.etErgebnis);


        start = view.findViewById(R.id. btnStrt);
        start.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        etOG = view.findViewById(R.id.etEnde);
        etUG = view.findViewById(R.id.etAnfang);
        etTime = view.findViewById(R.id. etSkeingabe);
        etAnzahlAufgabe = view.findViewById(R.id.etAufgAnzahl);

        int a=10,b=1,c=10,d=10,x,y,z,f=0, result;
        operand = view.findViewById(R.id. tvOp);
        String s, s1, s2, s3, s4, s5, s6;

        a= Integer.parseInt(etOG.getText().toString());
        b = Integer.parseInt(etUG.getText().toString());
        c = Integer.parseInt(etAnzahlAufgabe.getText().toString());
        d = Integer.parseInt(etTime.getText().toString());
        if(a<b){
            Toast.makeText(getActivity(), "Obere Grenze darf nicht kleiner als Untere Grenze sein", Toast.LENGTH_SHORT).show();

        }

        Random zu = new Random();

        int i = 0;
        do {
            x = zu.nextInt(b) + (a-b);
            y = zu.nextInt(b ) + (a-b);
           // if(operand == "+"){}

            i++;
        }while(i<c);
        s = String.valueOf(x);
        s1 = String.valueOf(y);
        s2 = String.valueOf(f);

        punkt.setText(s2);
        tvZahl1.setText(s);
        tvZahl2.setText(s1);


    }
}
