package com.company;

import java.util.ArrayList;

public class Zoo<T extends Animal> {
    ArrayList<T> animals = new ArrayList<T>();
    public void add(T animal) {
        animals.add(animal);
    }
    public T get() {
        if (this.animals.size() < 1) return null;
        T removedAnimal = this.animals.get(0);
        this.animals.remove(0);
        return removedAnimal;
    }
}
