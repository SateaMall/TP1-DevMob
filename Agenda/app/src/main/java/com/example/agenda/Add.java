package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Add extends AppCompatActivity {
    private EditText EditTextDate, EditTextDesc;

    private Button AddFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        AddFinal = findViewById(R.id.addEventButton);
        EditTextDate = findViewById(R.id.editTextDate);
        EditTextDesc = findViewById(R.id.editTextDesc);
        ArrayList<Event> receivedList = (ArrayList<Event>) getIntent().getSerializableExtra("Events");
        AddFinal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // User clicked "Add The Event"
                String Date = EditTextDate.getText().toString();
                String Desc = EditTextDesc.getText().toString();
                receivedList.add(new Event(Date,Desc));

                //CHANGE PAGE AND SEND THE LIST WITH THE NEW ELEMENT
                Intent intent = new Intent(Add.this, Agenda.class);
                intent.putExtra("List", receivedList);

                startActivity(intent);
            }
        });

    }
}