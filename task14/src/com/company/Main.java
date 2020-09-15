package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void download(String url, String fileName) throws Exception {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }

    public static void main(String[] args) throws Exception {

        File f = new File("Voyna-i-mir.txt");

//        download("http://fb2bookdownload.ru/go/?http://fb2bookdownload.ru/engine/download.php?id=1994", "Voyna-i-mir1.txt");
//        File f = new File("Voyna-i-mir1.txt");

        try {
            FileInputStream inputStream = new FileInputStream(f);
            Scanner sc = new Scanner(inputStream, "windows-1251");
            Map<String, Integer> words = new HashMap<>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Arrays.stream(line.toLowerCase().replaceAll("[^0-9a-zа-я]", " ").split(" "))
                    .filter(x -> x.length() > 1)
                    .forEach(x -> {
                        if (!words.containsKey(x)) words.put(x, 0);
                        words.put(x, words.get(x) + 1);
                    });
            }
            System.out.printf("### 20 most frequent words:");
            List<Map.Entry<String, Integer>> mostFrequent20 = words.entrySet().stream().sorted((a, b) -> {
                return b.getValue() - a.getValue();
            }).limit(20).collect(Collectors.toList());
            for (Map.Entry<String, Integer> entry : mostFrequent20) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

            System.out.println("### 20 least frequent words:");
            List<Map.Entry<String, Integer>> leastFrequent20 = words.entrySet().stream().sorted((a, b) -> {
                return a.getValue() - b.getValue();
            }).limit(20).collect(Collectors.toList());
            for (Map.Entry<String, Integer> entry : leastFrequent20) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

            System.out.println("### 5 longest words:");
            List<Map.Entry<String, Integer>> longest5 = words.entrySet().stream().sorted((a, b) -> {
                return b.getKey().length() - a.getKey().length();
            }).limit(5).collect(Collectors.toList());
            for (Map.Entry<String, Integer> entry : longest5) {
                System.out.println(entry.getKey());
            }

            System.out.println("### years words:");
            List<Map.Entry<String, Integer>> years = words.entrySet().stream().filter((a) -> {
                try {
                    int year = Integer.parseInt(a.getKey());
                    if (year > 2000 || year < 1500) return false;
                    return true;
                } catch (Exception e) {
                    return false;
                }
            })
                    .sorted((a, b) -> {
                        return b.getValue() - a.getValue();
                    })
                .limit(20).collect(Collectors.toList());
            for (Map.Entry<String, Integer> entry : years) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
