package com.moso;

public class airline {
    String fight_number, Airline, depature_time, travel_time;

    @Override
    public String toString() {
        return "airline [Airline=" + Airline + ", depature_time=" + depature_time + ", fight_number=" + fight_number
                + ", travel_time=" + travel_time + "]";
    }

    public airline(String fight_number, String airline, String depature_time, String travel_time) {
        this.fight_number = fight_number;
        this.Airline = airline;
        this.depature_time = depature_time;
        this.travel_time = travel_time;
    }

    public String getFight_number() {
        return fight_number;
    }

    public void setFight_number(String fight_number) {
        this.fight_number = fight_number;
    }

    public String getAirline() {
        return Airline;
    }

    public void setAirline(String airline) {
        this.Airline = airline;
    }

    public String getDepature_time() {
        return depature_time;
    }

    public void setDepature_time(String depature_time) {
        this.depature_time = depature_time;
    }

    public String getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(String travel_time) {
        this.travel_time = travel_time;
    }
}
