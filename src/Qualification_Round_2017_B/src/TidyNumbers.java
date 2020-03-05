package Qualification_Round_2017_B.src;

public class TidyNumbers {
    public String findTidyNumber(String input) {
        long num = Long.parseLong(input);
        while (num > 0) {
            String numString = Long.toString(num);
            if (isNumberDescending(numString)) {
                return numString;
            }
            num--;
        }
        return "0";
    }

    private boolean isNumberDescending(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (Long.parseLong(number.substring(i, i + 1)) > Long.parseLong(number.substring(i + 1, i + 2))) {
                return false;
            }
        }
        return true;
    }
}
