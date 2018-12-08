package com.example.cemo1.menuwithwelcomescreen;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

// Klasse macht Registrierungsanfrage an Register.php Datei an Server
// und bekommt als Antwort String zurück deswegen extends StringRequest
// static = bleibt unverändert
// deswegen auch final = kein anderer Wert
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://underbred-duration.000webhostapp.com/Register.php";
    // URL zu Register.php Datei
    private Map<String, String> params;

    // brauchen Konstruktor
    // Parameter für einen Namen, Nutzernamen, Passwort
    // Wenn ein Element dieser Klasse kreiert wird werden alle diese Daten an Konstruktor gegeben
    public RegisterRequest(String name, String username, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        // sende Daten an Register.php
        // und bekommen anschließend dann Antwort von Register.php
        // nutzen dabei volley Paket als Anfrage
        params = new HashMap<>();
        // kreiert HashMap
        // geben Parameterdaten in Hashmap
        // schauen auf Register.php
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
    }
    // wenn der Request ausgeführt wird
    // wird volley getParams aufrufen
    // und return params
    // params parameter die wir in Hashmap gefüllt haben

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}