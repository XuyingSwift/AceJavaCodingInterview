package main.Java11Exam.Collections.HashMap;

import java.util.HashMap;

public class Introduction {

    public static void main(String[] args) {
        HashMap<String, Integer> stockPrices = new HashMap<>();
        stockPrices.put("oracle", 50);
        stockPrices.put("Mia", 55);
        stockPrices.put("Google", 55);
        stockPrices.put("Happy", 55);

        // getOrDefault if the key is present
        System.out.println(stockPrices);
        System.out.println(stockPrices.getOrDefault("Mia", 2000));
        System.out.println(stockPrices.getOrDefault("Naomi", 2000));
        System.out.println(stockPrices.get("Naomi"));
    }
}
