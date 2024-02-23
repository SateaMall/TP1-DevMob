package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView phoneNumberText, emailText, ageText, nomText, prenomText, profText ;
    private Button returnButton, callButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Get the phone number passed from MainActivity
        String phoneNumber = getIntent().getStringExtra("phoneNumber"); // retrieve the phone number through the intent
        String nom = getIntent().getStringExtra("nom");
        String prenom = getIntent().getStringExtra("prenom");
        String age = getIntent().getStringExtra("age");
        String email = getIntent().getStringExtra("email");
        String prof = getIntent().getStringExtra("prof");

        phoneNumberText = findViewById(R.id.textViewPhone);
        emailText = findViewById(R.id.showEmail);
        ageText = findViewById(R.id.showAge);
        prenomText = findViewById(R.id.showPrenom);
        nomText = findViewById(R.id.showNom);
        profText = findViewById(R.id.showProf);

        phoneNumberText.setText(phoneNumber);
        emailText.setText(email);
        ageText.setText(age);
        prenomText.setText(prenom);
        nomText.setText(nom);
        profText.setText(prof);

        Button callButton = findViewById(R.id.callButton);
        Button returnButton = findViewById(R.id.returnButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check for call permission
                ActivityCompat.requestPermissions(MainActivity2.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

                // Intent to dial the phone number
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check for call permission
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}