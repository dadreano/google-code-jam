package Qualification_Round_2019_C.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTests = in.nextInt();
        for (int i = 1; i <= numTests; ++i) {
            in.nextBigInteger();
            int numProducts = in.nextInt();
            List<BigInteger> nums = new ArrayList<>();
            for (int j = 0; j < numProducts; j++) {
                nums.add(in.nextBigInteger());
            }
            System.out.println("Case #" + i + ": " + findCryptopangram(nums));
        }
    }

    public static String findCryptopangram(List<BigInteger> nums) {
        // Add gcd of first two numbers
        List<BigInteger> cryptoList = new ArrayList<>();
        cryptoList.add(nums.get(0).gcd(nums.get(1)));

        // Compute crypto #'s based on divisibility
        for (int i = 0; i < nums.size(); i++) {
            if (BigInteger.ZERO.equals(nums.get(i).mod(cryptoList.get(cryptoList.size() - 1)))) {
                cryptoList.add(nums.get(i).divide(cryptoList.get(cryptoList.size() - 1)));
            } else {
                cryptoList.add(nums.get(i).divide(cryptoList.get(cryptoList.size() - 2)));
                if (i == 1) {
                    Collections.swap(cryptoList, 0, 1);
                }
            }
        }

        // Acts as a dictionary
        List<BigInteger> sortedList = new ArrayList<>(cryptoList).stream().distinct().sorted().collect(Collectors.toList());

        // Convert crypto #'s into letters
        return cryptoList.stream().map(num -> String.valueOf((char) (65 + sortedList.indexOf(num)))).collect(Collectors.joining(""));
    }
}
