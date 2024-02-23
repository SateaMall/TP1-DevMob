package com.example.trains;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cherche extends AppCompatActivity {
    private EditText editTextDepart, editTextArrive;
    private Button chercheButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cherche);
        editTextDepart = findViewById(R.id.editTextDepart);
        editTextArrive = findViewById(R.id.editTextArrive);
        chercheButton = findViewById(R.id.chercheButton);
        chercheButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String depart = editTextDepart.getText().toString();
                String arrive = editTextArrive.getText().toString();
                // User clicked "Serach"
                Intent intent = new Intent(Cherche.this, Consultation.class);
                intent.putExtra("depart", depart); // send the ville de depart through the intent
                intent.putExtra("arrive", arrive); // send the ville de depart through the intent
                startActivity(intent);
            }
        });
    }
}