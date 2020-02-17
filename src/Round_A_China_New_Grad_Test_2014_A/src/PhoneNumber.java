package Round_A_China_New_Grad_Test_2014_A.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumber {
    private static List<String> wordList = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    private static List<String> multipleList = Arrays.asList("double", "triple", "quadruple", "quintuple", "sextuple", "septuple", "octuple", "nonuple", "decuple");
    List<String> result = new ArrayList<>();

    public String readPhoneNumber(String input) {
        String number = input.split(" ")[0];
        String[] numPlaces = input.split(" ")[1].split("-");

        for (String numPlace : numPlaces) {
            String numToRead = number.substring(0, Integer.parseInt(numPlace));
            StringBuilder repeated = new StringBuilder();
            if (numToRead.length() == 1) {
                result.add(wordFromNumber(numToRead));
            } else {
                for (int i = 0; i < numToRead.length(); i++) {
                    if (i != numToRead.length() - 1 && numToRead.substring(i, i + 1).equals(numToRead.substring(i + 1, i + 2))) {
                        if (repeated.toString().equals("")) {
                            repeated.append(numToRead, i, i + 1).append(numToRead, i, i + 1);
                        } else {
                            repeated.append(numToRead, i, i + 1);
                        }
                    } else {
                        if (repeated.toString().equals("")) {
                            result.add(wordFromNumber(numToRead.substring(i, i + 1)));
                        } else {
                            addRepeatedNumber(repeated);
                            repeated = new StringBuilder();
                        }
                    }
                }
            }
            if (!repeated.toString().equals("")) {
                addRepeatedNumber(repeated);
            }
            if (number.length() > 1) {
                number = number.substring(Integer.parseInt(numPlace));
            }
        }

        return String.join(" ", result);
    }

    private String wordFromNumber(String number) {
        return wordList.get(Integer.parseInt(number));
    }

    private String multipleFromNumber(int number) {
        return multipleList.get(number - 2);
    }

    private void addRepeatedNumber(StringBuilder repeated) {
        if (repeated.length() <= 10) {
            result.add(multipleFromNumber(repeated.length()));
            result.add(wordFromNumber(repeated.substring(0, 1)));
        } else {
            for (int z = 0; z < repeated.length(); z++) {
                result.add(wordFromNumber(repeated.substring(0, 1)));
            }
        }
    }
}
