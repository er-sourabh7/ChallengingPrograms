
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingLetter("SSoooossuurabh"));
    }

    /**
     * 
     * @param str - String to find the first non repeating character in
     * @return - first non repeating character
     */
    public static String firstNonRepeatingLetter(String str) {

        int[] repetitions = new int[255];
        char[] charArr = new char[255];

        String tempStr = str.toLowerCase();

        // Store all characters at the ASCII positions in the arrays
        int i = 0;
        int index = 0;
        char c = '\0';
        while (i < tempStr.length()) {
            c = tempStr.charAt(i);
            index = ((int) c);
            
            // improved performance specific to this particular question
            // skipped unnecessary assignment to characterarray and integerarray
            if(repetitions[index] == 2){
                i++;
                continue;
            }
            charArr[index] = c;
            repetitions[index]++;
            i++;
        }

        // find the first non empty char and check the relevant repetition as 0
        char nonRepeatedChar = getNonRepeatingChar(tempStr, charArr, repetitions);
        if (nonRepeatedChar == '\0') {
            return "";
        }
        return str.charAt(getFirstIndex(tempStr, nonRepeatedChar)) + "";
    }

    /**
     * This method returns first non repeating character
     * @param tempStr - String in focus
     * @param charArr - character array that stores all the character occurences in {@code tempStr}
     * @param repetitions - integer array that stores the respective repetitions of the corresponding characters 
     * @return - return the first non repeating character
     */
    private static char getNonRepeatingChar(String tempStr, char[] charArr, int[] repetitions) {
        char nonRepeatedChar = '\0';

        int i = 0;
        char c = '\0';
        int index = 0;
        while (i < tempStr.length()) {
            c = tempStr.charAt(i);
            index = (int) c;
            
            if (repetitions[index] == 1) {
                nonRepeatedChar = charArr[index];
                break;
            }
            i++;
        }

        return nonRepeatedChar;
    }

    /**
     * 
     * @param str - String in focus
     * @param c - character of which first index to be found
     * @return - return the index of first occurence
     */
    public static int getFirstIndex(String str, char c) {
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == c)
                return i;
            i++;
        }
        return -1;
    }
}
