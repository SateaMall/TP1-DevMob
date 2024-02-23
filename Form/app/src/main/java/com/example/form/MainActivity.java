package com.example.form;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextSurName, editTextEmail, editTextAge, editTextProfession, editTextPhone;
    private Button editTextsubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextSurName = findViewById(R.id.editTextSurName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextAge = findViewById(R.id.editTextAge);
        editTextProfession = findViewById(R.id.editTextProfession);
        editTextPhone = findViewById(R.id.editTextPhoneNumber);
        editTextsubmitButton = findViewById(R.id.submitButton);
        editTextsubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String surName = editTextSurName.getText().toString();
                String email = editTextEmail.getText().toString();
                String age = editTextAge.getText().toString();
                String profession = editTextProfession.getText().toString();
                String phone = editTextPhone.getText().toString();
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(getString(R.string.confirmation)) // Title of the dialog
                        .setMessage(getString(R.string.messageSubmit)) // Message to display
                        .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Yes"
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                intent.putExtra("phoneNumber", phone); // send the phone number through the intent
                                intent.putExtra("nom", surName);
                                intent.putExtra("prenom", name);
                                intent.putExtra("age", age);
                                intent.putExtra("email", email);
                                intent.putExtra("prof", profession);

                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(getString(R.string.returning), null) // null means nothing happens on click
                        .show();
            }
        });
    }
}