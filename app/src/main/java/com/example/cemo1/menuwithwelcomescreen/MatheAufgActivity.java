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

public class MatheAufgActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout schublade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe_aufg);
        Toolbar toolbar = findViewById(R.id. toolbar); //üc cizgili Menuyu gosterir
        schublade = findViewById(R.id.matheaufgabe);
        NavigationView navigationView = findViewById(R.id. nav_view );
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, schublade,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        schublade.addDrawerListener(toggle);
        toggle.syncState();

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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
