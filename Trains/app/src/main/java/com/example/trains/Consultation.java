package com.example.trains;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class Consultation extends AppCompatActivity {
    private ArrayList<Trajet> Trajets= new ArrayList<Trajet>();
    private ArrayList<Trajet> results= new ArrayList<Trajet>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);
        // Get the ville de dep and ville d'arrive passed from cherche
        String depart = getIntent().getStringExtra("depart");
        String arrive = getIntent().getStringExtra("arrive");
        addTrajets();// load the trajets
        compatible(depart,arrive); // chose the ones that are compatible
        /*maintenant il faut les afficher */

        String[] displayArray = new String[results.size()];
        int i=0;
        for (Trajet t: results) {
            displayArray[i] = t.toString();
            i++;
        }

        ListView listView = findViewById(R.id.trajetListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayArray);
        listView.setAdapter(adapter);
    }
    private void addTrajets(){
        Trajets.add(new Trajet("Paris","Londre", new Date(2022,2,2) , new Date(2022,2,2)));
        Trajets.add(new Trajet("Paris","Monptellier", new Date(2022,2,2) , new Date(2022,20,2)));
        Trajets.add(new Trajet("Paris","Homs", new Date(2022,20,2) , new Date(2022,2,2)));
        Trajets.add(new Trajet("Paris","Beirut", new Date(2022,2,2) , new Date(2022,2,2)));
        Trajets.add(new Trajet("Paris","Caire", new Date(2022,2,2) , new Date(2022,2,2)));
        Trajets.add(new Trajet("Paris","Londre", new Date(2022,2,21) , new Date(2022,2,22)));
        Trajets.add(new Trajet("Paris","Monptellier", new Date(2022,2,21) , new Date(2022,2,22)));
        Trajets.add(new Trajet("Paris","Homs", new Date(2022,2,21) , new Date(2022,2,22)));
        Trajets.add(new Trajet("Paris","Beirut", new Date(2022,2,21) , new Date(2022,2,22)));
        Trajets.add(new Trajet("Paris","Caire", new Date(2022,2,21) , new Date(2022,2,22)));
        Trajets.add(new Trajet("Paris","Londre", new Date(2022,2,9) , new Date(2022,2,9)));
        Trajets.add(new Trajet("Paris","Monptellier", new Date(2022,9,9) , new Date(2022,9, 9)));
        Trajets.add(new Trajet("Paris","Homs", new Date(2022,2,9) , new Date(2022,2,9)));
        Trajets.add(new Trajet("Paris","Beirut", new Date(2022,2,9) , new Date(2022,2,9)));
        Trajets.add(new Trajet("Paris","Caire", new Date(2022,2,9) , new Date(2022,2,9)));
    }
    private void compatible (String depart, String arrive){
        for (Trajet t: Trajets) {
            if (depart.equals(t.getDepart()) && arrive.equals(t.getArrive())){
                results.add(t);
            }
        }
    }

}