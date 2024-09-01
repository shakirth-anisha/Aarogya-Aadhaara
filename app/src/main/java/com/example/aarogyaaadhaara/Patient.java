package com.example.aarogyaaadhaara;

import java.util.List;

public class Patient {
    private int imageResource;
    private String name;
    private int age;
    private String phoneNumber;
    private List<Medicine> medicines;

    public Patient(int imageResource, String name, int age, String phoneNumber, List<Medicine> medicines) {
        this.imageResource = imageResource;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.medicines = medicines;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public String getDosesTakenFormatted() {
        StringBuilder doses = new StringBuilder();
        for (Medicine medicine : medicines) {
            doses.append(medicine.getDosesTakenFormatted()).append("\n");
        }
        return doses.toString().trim();
    }
}
