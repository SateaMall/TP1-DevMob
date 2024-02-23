package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agenda extends AppCompatActivity {
    private List<Event> eventList = new ArrayList<>();
    private FloatingActionButton addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        addButton = findViewById(R.id.addEventButton);

        //Get the infos of the new event (use it if it exists)
        List<Event> recievedList = (ArrayList<Event>) getIntent().getSerializableExtra("List");
        if (recievedList != null){
            eventList=recievedList;
        }
        else {
            //if not just load the basic events
            addEvents();
        }

        // Sort the list
        eventList.sort(Comparator.comparing(Event::getLocalDate));

        // Loading the events into an array
        String[] displayArray = new String[eventList.size()];
        int i=0;
        for (Event t: eventList) {
            displayArray[i] = t.toString();
            i++;
        }

        // Initializing ListView and Adapter
        ListView agendaListView = findViewById(R.id.AgendaListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayArray);
        agendaListView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // User clicked "Add"
                Intent intent = new Intent(Agenda.this, Add.class);
                intent.putExtra("Events",(Serializable)eventList ); // send the whole list
                startActivity(intent);
            }
        });

    }


    private void addEvents(){
        eventList.add(new Event("08/08/2024", "Assam's BirthDay"));
        eventList.add(new Event("01/01/2024", "New Year's Day Celebration"));
        eventList.add(new Event("14/02/2024", "Valentine's Day"));
        eventList.add(new Event("14/07/2024", "Mona's BirthDay"));
    }

}