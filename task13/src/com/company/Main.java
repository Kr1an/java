package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void task13_1() {
        System.out.println("task 13.1");
        System.out.println("Enter text:");
        String str = new Scanner(System.in)
                .nextLine()
                .toLowerCase()
                .replaceAll("[^0-9a-zа-я]", " ");
        Map<String, Integer> wordCount = new HashMap<>();
        Arrays.stream(str.split(" "))
                .filter(word -> word.length() > 0)
                .forEach(word -> {
                    if (!wordCount.containsKey(word)) {
                        wordCount.put(word, 0);
                    }
                    wordCount.put(word, wordCount.get(word) + 1);
                });
        wordCount.entrySet().stream()
                .sorted((a, b) -> {
                    int diff = b.getValue() - a.getValue();
                    if (diff == 0) return a.getKey().compareTo(b.getKey());
                    return diff;
                })
                .limit(10)
                .forEach(a -> {
                    System.out.println(a.getKey() + " - " + a.getValue());
                });
    }

    public static void task13_2() {
        System.out.println("Task 13.2");
        Map<Integer, String> dict = new HashMap<>();
        dict.put(1, "first");
        dict.put(2, "second");
        dict.put(3, "third");
        dict.put(4, "forth");

        List<String> names = dict.entrySet().stream()
                .filter(x -> Arrays.asList(new Integer[]{1,2,5,8,9,13}).contains(x.getKey().intValue()))
                .filter(x -> x.getValue().length() % 2 == 1)
                .map(x -> x.getValue())
                .map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.toList());
        System.out.println(names);
    }
    public static void task13_3() {
        System.out.printf("Task 13.3");
        LinkedList<Worker> workers = new LinkedList<Worker>();
        workers.add(new Worker("first", 40));
        workers.add(new Worker("second", 30));
        workers.add(new Worker("first", 20, true));
        workers.add(new Worker("third", 10));
        workers.add(new Worker("forth", 15, true));
        Map<Integer, Worker> map = workers.stream()
                .filter(x -> x.age >= 15)
                .filter(x -> x.hadPenalty == false)
                .collect(Collectors.toMap(x -> {
                    return (int)(Math.random() * 104 + 4);
                }, x -> x));
        for(Map.Entry<Integer, Worker> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
    public static void main(String[] args) {
        task13_1();
        task13_2();
        task13_3();
    }
}
