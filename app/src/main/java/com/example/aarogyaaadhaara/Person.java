package com.example.aarogyaaadhaara;

public class Person {
    private int imageResId;
    private String name;
    private int age;
    private String gender;

    public Person(int imageResId, String name, int age, String gender) {
        this.imageResId = imageResId;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
