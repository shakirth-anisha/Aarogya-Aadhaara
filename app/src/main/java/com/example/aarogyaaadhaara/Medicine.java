package com.example.aarogyaaadhaara;

public class Medicine {
    private String name;
    private int dosesTaken;
    private int totalDoses;
    private String dateIssued;
    private String expirationDate;
    private String sideEffects;

    public Medicine(String name, int dosesTaken, int totalDoses, String dateIssued, String expirationDate, String sideEffects) {
        this.name = name;
        this.dosesTaken = dosesTaken;
        this.totalDoses = totalDoses;
        this.dateIssued = dateIssued;
        this.expirationDate = expirationDate;
        this.sideEffects = sideEffects;
    }

    public String getName() {
        return name;
    }

    public String getDosesTakenFormatted() {
        return dosesTaken + "/" + totalDoses;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getSideEffects() {
        return sideEffects;
    }
}
