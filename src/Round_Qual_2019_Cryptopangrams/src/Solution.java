package Round_Qual_2019_Cryptopangrams.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
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
            BigInteger[] nums = new BigInteger[numProducts];
            for (int j = 0; j < numProducts; j++) {
                nums[j] = in.nextBigInteger();
            }
            System.out.println("Case #" + i + ": " + findCryptopangram(nums));
        }
    }

    public static String findCryptopangram(BigInteger[] nums) {
        BigInteger[] primeList = new BigInteger[nums.length + 1];
        int diffIndex = -1;

        // Find first gcd
        for (int i = 1; i < nums.length; i++) {
            // Ignore duplicates
            if (!nums[i].equals(nums[i - 1])) {
                diffIndex = i;
                primeList[i] = nums[i].gcd(nums[i - 1]);
                break;
            }
        }

        // Loop through the list
        for (int i = diffIndex; i < nums.length; i++) {
            primeList[i + 1] = nums[i].divide(primeList[i]);
        }

        // Add back missed primes
        for (int i = diffIndex - 1; i >= 0; i--) {
            primeList[i] = nums[i].divide(primeList[i + 1]);
        }

        // Acts as a dictionary
        List<BigInteger> sortedList = Arrays.stream(primeList).distinct().sorted().collect(Collectors.toList());

        // Convert crypto #'s into letters
        return Arrays.stream(primeList).map(num -> String.valueOf((char) (65 + sortedList.indexOf(num)))).collect(Collectors.joining(""));
    }
}
