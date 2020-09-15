package com.company;

public class Primates extends Animal {
    @Override
    public void feed(Food product) {
        if (product != Food.Apple || product != Food.Carrot) {
            System.out.println("I am primate. I do not eat " + product.name());
        }
    }
}
