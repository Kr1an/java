package com.company;

public class Worker {
    public String name;
    public int age;
    public boolean hadPenalty;
    public Worker(String name, int age, boolean hadPenalty) {
        this.name = name;
        this.age = age;
        this.hadPenalty = hadPenalty;
    }
    public Worker(String name, int age) {
        this(name, age, false);
    }
    public String toString() {
        return this.name + " (" + this.age + ") " + (this.hadPenalty ? "had penalties" : "");
    }
}
