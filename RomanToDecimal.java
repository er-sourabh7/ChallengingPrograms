import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanToDecimal {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of inputs - ");
        int n = Integer.parseInt(reader.readLine().trim());
        int o = n;
        System.out.println();
        System.out.println("Taking " + n + " numerals as input...");
        String romanNumeral;
        while (n-- > 0) {
            romanNumeral = reader.readLine();
            RomanToDecimal romanToDecimal = new RomanToDecimal();
            System.out.println(romanToDecimal.getRomanToDecimal(romanNumeral));
        }
    }

    public int getRomanToDecimal(String romanNumeral) {
        int finalNumber = 0;
        int a = 0;
        int b = 0;
        int index = 0;
        while (index < romanNumeral.length()) {
            a = getIndividualValue(romanNumeral.charAt(index++));
            b = (index < romanNumeral.length()) ? getIndividualValue(romanNumeral.charAt(index)) : -1;
            index++;

            if (b == -1) {
                finalNumber += a;
                return finalNumber;
            }
            // if a == b or a > b then consume a
            else if (a > b || a == b) {
                finalNumber += a;
                index--;
            }
            // if a < b then consume both
            else if (b > a)
                finalNumber += b - a;
        }
        return finalNumber;

    }

    private int getIndividualValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
