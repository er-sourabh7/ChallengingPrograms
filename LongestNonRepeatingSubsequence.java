import java.util.ArrayList;
import java.util.List;

public class LongestNonRepeatingSubsequence {
    public static void main(String[] args) {
        getLongestNonRepeatingSubsequence("aabcdebcd");
    }

    public static String getLongestNonRepeatingSubsequence(String originalString) {
        // 0. create a tempString
        // create list of strings
        StringBuilder tempString = new StringBuilder("");
        List<String> listOfStrings = new ArrayList<>();

        // 1. loop through character in the string
        char ch = '\0';
        int matchIndex = -1;
        StringBuilder inpString = new StringBuilder(originalString);
        for (int i = 0; i < inpString.length(); i++) {
            matchIndex = -1;
            while (i < inpString.length()
                    && (matchIndex = tempString.indexOf((ch = inpString.charAt(i)) + "")) == -1) {
                tempString.append(ch);
                i++;
            }
            listOfStrings.add(tempString.toString());
            i = tempString.length() - matchIndex;
            inpString.delete(0, i);
            i = -1;
            // clear the tempString
            tempString.delete(0, tempString.length());
        }
        return inpString.toString();
    }
}
