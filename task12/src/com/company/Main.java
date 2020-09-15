package com.company;

public class Main {
    public static void main(String[] args) {
        Zoo<Bird> zoo = new Zoo<>();
        Bird bird1 = new Bird();
        bird1.nickname = "frack";
        zoo.add(bird1);
        Bird bird2 = zoo.get();
        System.out.println(bird2.toString());
    }
}
