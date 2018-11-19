package com.example.cemo1.menuwithwelcomescreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MatheFragment extends Fragment implements View.OnClickListener {

    View view;
    public Button LOS,ubernehmen;
    public CheckBox addit,multip,subtra,divis;
    public EditText etOG, etUG, etTime,etAnzahlAufgabe;
    public int a=10,b=1, c=10, d = 10,f,g,h;
    public String u1,u2,u3,u4;
    public String[] operand;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,@NonNull Bundle savedInstanceState) {
               view = inflater.inflate(R.layout. fragment_mathe, container, false);
               LOS = view.findViewById(R.id. btnMatlos);
               ubernehmen = view.findViewById(R.id.btnUbernehmen);
               addit = view.findViewById(R.id.cbAddition);
               multip = view.findViewById(R.id.cbMultiplikation);
               subtra = view.findViewById(R.id.cbSubtraktion);
               divis = view.findViewById(R.id.cbDivision);
               etOG = view.findViewById(R.id.etEnde);
               etUG = view.findViewById(R.id.etAnfang);
               etTime = view.findViewById(R.id. etSkeingabe);
               etAnzahlAufgabe = view.findViewById(R.id.etAufgAnzahl);

                u2 = String.valueOf(a);
                etOG.setText(u2);

                u1 = String.valueOf(b);
                etUG.setText(u1);

                u3 = String.valueOf(c);
                etAnzahlAufgabe.setText(u3);

                u4 = String.valueOf(d);
                etTime.setText(u4);





               LOS.setOnClickListener(this);
               ubernehmen.setOnClickListener(this);


               return view;

    }

    @Override
    public void onClick(View v) {

        if(multip.isChecked() || divis.isChecked()||addit.isChecked()||subtra.isChecked()) {
            switch (v.getId()) {

                case R.id.btnMatlos:
                    if(a > b) {
                        FragmentTransaction fr = getFragmentManager().beginTransaction();
                        fr.replace(R.id.fragment_container, new MatheAufgabeFragment());
                        fr.commit();
                    }
                    else{
                        Toast.makeText(getActivity(),"Obere Grenz darf nicht kleiner oder gleich als Untere Grenze sein",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R. id. btnUbernehmen:
                    a = Integer.parseInt(etOG.getText().toString());
                    break;

            }
        }
        else {
            Toast.makeText(getActivity(),"Wählen Sie mindestens eine der vier Rechenarten aus", Toast.LENGTH_LONG).show();
        }

    }
}
