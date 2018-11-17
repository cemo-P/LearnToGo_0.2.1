package com.example.cemo1.menuwithwelcomescreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MatheFragment extends Fragment implements View.OnClickListener {

    View view;
    public Button LOS;
    public CheckBox addit,multip,subtra,divis;
    private Boolean isChecked;

    //@Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
               view = inflater.inflate(R.layout. fragment_mathe, container, false);
               LOS = view.findViewById(R.id. btnMatlos);
               addit = view.findViewById(R.id.cbAddition);
               multip = view.findViewById(R.id.cbMultiplikation);
               subtra = view.findViewById(R.id.cbSubtraktion);
               divis = view.findViewById(R.id.cbDivision);
               LOS.setOnClickListener(this);

               return view;

    }

    @Override
    public void onClick(View v) {
        if(multip.isChecked() || divis.isChecked()||addit.isChecked()||subtra.isChecked()) {
            switch (v.getId()) {
                case R.id.btnMatlos:
                    FragmentTransaction fr = getFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new MatheAufgabeFragment());
                    fr.commit();
                    break;
            }
        }
        else {
            Toast.makeText(getActivity(),"Wählen Sie eine Rechenart", Toast.LENGTH_LONG).show();
        }

    }
}
