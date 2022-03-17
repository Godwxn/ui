package com.moso;

public class med {
    private String medName, morning, afternoon, evening, night;

    public med(String medName, String morning, String afternoon, String evening, String night) {
        this.medName = medName;
        this.morning = morning;
        this.afternoon = afternoon;
        this.evening = evening;
        this.night = night;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    public String getEvening() {
        return evening;
    }

    public void setEvening(String evening) {
        this.evening = evening;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    med(String medname) {
        this.medName = new String(medname);
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }
}
