package com.company;

public class Bird extends Animal {

    @Override
    public void feed(Food product) {
        if (product != Food.Seed) {
            System.out.println("I am a bird. I do not consume " + product.name() + ". Only seeds.");
        }
    }
}
