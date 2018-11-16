package com.example.cemo1.menuwithwelcomescreen;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout schublade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id. toolbar); //üc cizgili Menuyu gosterir
        schublade = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id. nav_view );
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, schublade,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        schublade.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new MatheFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_mathe);
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R. id. nav_mathe:
                getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new MatheFragment()).commit();
                break;
            case R. id. nav_kartei:
                getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new KarteiFragment()).commit();
                break;
            case R. id. nav_setting:
                getSupportFragmentManager().beginTransaction().replace(R. id. fragment_container, new SettingFragment()).commit();
                break;
        }
        schublade.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(schublade.isDrawerOpen(GravityCompat.START)){
            schublade.closeDrawer(GravityCompat.START);

        }
        else {
            super.onBackPressed();
        }
    }


}
