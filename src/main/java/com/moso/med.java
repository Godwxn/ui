package com.moso;

public class med {
    private String medName;

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
