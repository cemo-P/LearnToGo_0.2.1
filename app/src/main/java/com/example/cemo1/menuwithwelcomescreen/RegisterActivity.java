package com.example.cemo1.menuwithwelcomescreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // sagt dem java file mit welchen xml file es arbeiten soll

        // anbinden Elemente innerhalb von activtiy_register
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        // schau in activtiy_register und mache daraus ein Edit Text
        // mit der Referenz auf ID etAge
        // final = einzige Wertzuweisung an etAge

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                // etName.getText().toString();
                // nehmen Namen von Namensfeld und konvertieren es zu einem String
                // warum? siehe RegisterRequest
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                // wegen alter int final int
                // nimmt age konvertiert es zu int Integer.parseInt
                final int age = Integer.parseInt(etAge.getText().toString());

                // alles hier passiert wenn die Antwort kommt
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            // brauchen JSONObject wegen JSONString siehe Register.php
                            // nimmt den String von volley und konvertiert es zu einem JSON Object
                            boolean success = jsonResponse.getBoolean("success");
                            // wenn Antwort von volley kommt wird überprüft ob Eingaben korrekt sind

                            if (success){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                                // wenn Registrierung erfolgreich Übergang auf Login Page
                            }else{
                                // falls Fehlgeschlagen
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registrierung Fehlgeschlagen")
                                .setNegativeButton("Nochmal", null)
                                        // wenn User auf Nochmal klickt darf er wieder Registrierung versuchen
                                .create()
                                .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };

                // Kreieren Registrierungsanfrage was wollen wir bei Registrierung ? name username ...
                // RegisterRequest
                RegisterRequest registerRequest = new RegisterRequest(name, username, age, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                // müssen Registrierungsanfrage der Warteschlange hinzufügen
                queue.add(registerRequest);
            }
        });

    }
}
