import static java.lang.System.out;

import java.util.Arrays;
import java.util.StringTokenizer;

public class WaveProblem {
    static String delimiter = "|";

    public static void main(String[] args) {
        int[] wave = { 0, 1, 0, -10, -20, -2, 0, -1, 0, 2, 5, 0 };
        showExtremeWaves(wave);
    }

    // Entry method
    private static void showExtremeWaves(int[] arr) {
        printMaxWave(arr);
        printMinWave(arr);
    }

    // Method to find top of a wave
    private static void printMaxWave(int[] arr) {
        // temp array to store wave digits
        String[] topStrings = getWaveString(arr, 0, arr.length - 1);

        int maxTop = 0;
        for (String s : topStrings)
            if (!"".equals(s)) {
                int i = getTopOfAWave(s);
                if (maxTop < i)
                    maxTop = i;
            }

        out.println("TOP MAX IS -> " + maxTop);
    }

    // Method to find bottom of a wave
    private static void printMinWave(int[] arr) {
        // temp array to store wave digits
        String[] bottomStrings = getWaveString(arr, 0, arr.length - 1);

        int minBottom = 0;
        for (String s : bottomStrings)
            if (!"".equals(s)) {
                int i = getBottomOfAWave(s);
                if (minBottom > i)
                    minBottom = i;
            }

        out.println("BOTTOM MIN IS -> " + minBottom);
    }

    private static String[] getWaveString(int[] arr, int l, int r) {
        String[] strArr = new String[r - l];
        initializeArray(strArr);
        int indx = 0;

        for (int i = l; i < r; i++) {
            if (i + 1 < r && arr[i + 1] != 0) {
                strArr[indx] = strArr[indx] + delimiter + arr[i];
            } else {
                strArr[indx] += delimiter + arr[i];
                indx++;
            }
        }
        return strArr;
    }

    private static int getTopOfAWave(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, delimiter);
        int max = 0;
        while (tokenizer.hasMoreTokens()) {
            String t = tokenizer.nextToken();
            if (null != t) {
                int p = Integer.parseInt(t);
                if (max < p)
                    max = p;
            }
        }
        return max;
    }

    private static int getBottomOfAWave(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s, delimiter);
        int min = 0;
        while (tokenizer.hasMoreTokens()) {
            String t = tokenizer.nextToken();
            if (null != t) {
                int p = Integer.parseInt(t);
                if (min > p || min == 0)
                    min = p;
            }
        }
        return min;
    }

    private static void initializeArray(String[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = "";
    }

}
