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

public class MatheFragment extends Fragment implements View.OnClickListener {

    View view;
    public Button LOS;

    //@Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
               view = inflater.inflate(R.layout. fragment_mathe, container, false);
               LOS = view.findViewById(R.id. btnMatlos);
               LOS.setOnClickListener(this);

               return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id. btnMatlos:
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new MatheAufgabeFragment());
                fr.commit();
                break;
        }

    }
}
