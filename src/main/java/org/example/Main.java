package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] purchasedItemsPrices = {10,20,30,40,50,60};
        callGetMaximumDiscountFunc(purchasedItemsPrices);
    }

    private static void callGetMaximumDiscountFunc(int[] purchasedItemsPrices) {
        Integer[] reversedSortedPriceList = Arrays.stream(purchasedItemsPrices)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(reversedSortedPriceList));

        Integer[] payableItems = IntStream.range(0, reversedSortedPriceList.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> reversedSortedPriceList[i])
                .toArray(Integer[]::new);

        Integer[] discountedItems = IntStream.range(0, reversedSortedPriceList.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> reversedSortedPriceList[i])
                .toArray(Integer[]::new);

        System.out.println("Discounted Items (Free): " + Arrays.toString(discountedItems));
        System.out.println("Payable Items: " + Arrays.toString(payableItems));
    }
}