package com.example.cemo1.menuwithwelcomescreen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MatheActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout schublade;
    private Button Los;
    public CheckBox cbAddition, cbMultip,cbSubtra,cbDivis;
    public EditText etOG,etUG,etSek,etAufAn;
    public static int og=10,ug=1,ts=10,aufa=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe);
        Toolbar toolbar = findViewById(R.id. toolbar); //üc cizgili Menuyu gosterir
        schublade = findViewById(R.id.mathe);
        NavigationView navigationView = findViewById(R.id. nav_view );
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, schublade,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        schublade.addDrawerListener(toggle);
        toggle.syncState();

        cbAddition = findViewById(R.id.cbAddition);
        cbMultip = findViewById(R.id. cbMultiplikation);
        cbSubtra = findViewById(R.id.cbSubtraktion);
        cbDivis = findViewById(R.id. cbDivision);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R. id. nav_mathe:
                Intent mathe = new Intent(this,MatheActivity.class);
                startActivity(mathe);
                //getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new MatheFragment()).commit();
                break;
            case R. id. nav_kartei:
                Intent karte = new Intent(this,KarteActivity.class);
                startActivity(karte);
                //getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new KarteiFragment()).commit();
                break;
            case R. id. nav_setting:
                Intent m2 = new Intent(this,SettingActivity.class);
                startActivity(m2);
                //getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new SettingFragment()).commit();
                break;
            case R. id. nav_statistik:
                Intent stati = new Intent(this, StatistikActivity.class);
                startActivity(stati);
                // getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new StatistikFragment()).commit();
                break;
        }
        schublade.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onClick(View v) {


        etOG = findViewById(R.id. etOGW);
        etUG = findViewById(R. id. etUGW);
        etAufAn = findViewById(R. id. etAufgAnzahl);
        etSek = findViewById(R. id. etSkeingabe);
        /*og = Integer.parseInt(etOG.getText().toString());
        ug = Integer.parseInt(etUG.getText().toString());
        ts = Integer.parseInt(etSek.getText().toString());
        aufa = Integer.parseInt(etAufAn.getText().toString());*/


        if(cbDivis.isChecked()||cbAddition.isChecked()||cbMultip.isChecked()||cbSubtra.isChecked()){
                switch (v.getId()) {
                    case R.id.Losbtn:
                        Intent los = new Intent(this, MatheAufgActivity.class);

                        startActivity(los);
                        break;
                }


        }else{
            Toast.makeText(getApplicationContext(),"Wählen Sie mindestens eine der vier Rechenarten aus", Toast.LENGTH_SHORT).show();
        }




    }
}
