package com.example.trains;

import java.util.Date;

public class Trajet {
    private String depart;
    private String arrive;
    private Date date_dep;
    private Date date_arv;
    public Trajet(String depart, String arrive, Date date_dep, Date date_arv){
        this.depart=depart;
        this.arrive=arrive;
        this.date_dep=date_dep;
        this.date_arv=date_arv;
    }
    public String getDepart(){
        return depart;
    }

    public String getArrive() {
        return arrive;
    }

    public String toString() {
        return "From: " + depart + ", To: " + arrive + ", \n Depart: " + date_dep.toString() + ", \n Arrive: " + date_arv.toString();
    }
}
