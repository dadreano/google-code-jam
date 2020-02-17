package Round_1A_C_2008.src;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Numbers {
    public String findDigits(String input) {
        int power = Integer.parseInt(input);
        String resultString = new BigDecimal(3 + Math.sqrt(5)).pow(power).toPlainString();
        if (power >= 10) {
            String decimalPlace = Double.toString(Math.pow(3 + Math.sqrt(5), power));
            decimalPlace = decimalPlace.substring(decimalPlace.indexOf("E") + 1);
            int decimalPlaceInt = Integer.parseInt(decimalPlace) + 1;
            resultString = new BigInteger("523606797749978969640917366873127623544061835961152572427").pow(power).toString().substring(decimalPlaceInt - 3, decimalPlaceInt);
        }
        if (resultString.contains(".")) {
            resultString = resultString.substring(0, resultString.indexOf("."));
        }
        while (resultString.length() < 3) {
            StringBuilder sb = new StringBuilder(resultString);
            sb.insert(0, "0");
            resultString = sb.toString();
        }
        return resultString.substring(resultString.length() - 3);
    }
}
