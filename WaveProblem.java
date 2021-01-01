import static java.lang.System.out;

import java.util.Arrays;
import java.util.StringTokenizer;

public class WaveProblem {
    static String delimiter = "|";

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] wave = { 0, 1, 0, -10, -20, -2, 0, -1, 0, 5, 2, 0 };
        String[] crestAndTroughOfWave = getCrestAndTroughOfWave(wave);
        out.println(Arrays.toString(crestAndTroughOfWave));

        StringTokenizer minTokenizer = new StringTokenizer(crestAndTroughOfWave[0], ",[]");
        

    }

    private static void printBottomAndTopOfAWave(int[] arr) {
        int[] minMaxOfAWaveString = getMinMaxOfAWaveString(arr);
        out.println("Bottom Is " + minMaxOfAWaveString[0]);
        out.println("Bottom Is " + minMaxOfAWaveString[1]);
    }

    private static int[] getMinMaxOfAWaveString(int[] arr) {
        int[] minMaxArr = new int[2];
        // temp array to store wave digits
        String[] waveStrings = getWaveStrings(arr, 0, arr.length - 1);

        int maxTop = 0;
        int minBottom = 0;
        int top = 0;
        int bottom = 0;
        for (String waveString : waveStrings)
            if (!waveString.isEmpty()) {
                top = getTopOfAWave(waveString);
                bottom = getBottomOfAWave(waveString);
                if (maxTop < top)
                    maxTop = top;
                if (minBottom > bottom)
                    minBottom = bottom;

            }

        minMaxArr[0] = minBottom;
        minMaxArr[1] = maxTop;

        return minMaxArr;
    }

    private static String[] getCrestAndTroughOfWave(int[] arr) {
        String[] crestAndTrough = new String[2];

        int l = 0;
        int r = 0;
        int max = 0;
        int min = 0;

        boolean isCrest = false;

        for (int i = 0; i < arr.length - 1; i++) {
            isCrest = false;
            l = i;
            while (arr[i + 1] != 0)
                i++;
            r = i + 1;

            if (arr[l] < arr[l + 1])
                isCrest = true;

            if (isCrest) {
                int topOfAWave = getTopOfAWave(getWaveStrings(arr, l, r)[0]);
                if (max < topOfAWave)
                    max = topOfAWave;
                crestAndTrough[0] = max + "[" + l + "," + r + "]";
            } else {
                int bottomOfAWave = getBottomOfAWave(getWaveStrings(arr, l, r)[0]);
                if (min > bottomOfAWave)
                    min = bottomOfAWave;
                crestAndTrough[1] = min + "[" + l + "," + r + "]";
            }

        }

        return crestAndTrough;

    }

    private static String[] getWaveStrings(int[] arr, int l, int r) {
        String[] waveStrings = new String[r - l];
        initializeArray(waveStrings);
        int waveStrIndex = 0;

        for (int i = l; i < r; i++) {
            if (i + 1 < r && arr[i + 1] != 0) {
                waveStrings[waveStrIndex] = waveStrings[waveStrIndex] + delimiter + arr[i];
            } else {
                waveStrings[waveStrIndex] += delimiter + arr[i];
                waveStrIndex++;
            }
        }
        return waveStrings;
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
