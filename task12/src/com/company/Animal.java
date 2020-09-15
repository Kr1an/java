package com.company;

public abstract class Animal {
    public String nickname;
    public int ageYears;
    public int weight;
    public String toString() {
        return nickname + ageYears + weight;
    }
    public abstract void feed(Food product);
}
