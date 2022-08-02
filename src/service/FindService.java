package service;

public class FindService {
    private static String[] allCombination = null;
    private static int index = 0;

    private static String[] getAllCombination(String[] arr, int k) {
        int n = arr.length;
        allCombination = new String[factorial(n)];

        return getCombination(arr, "", n, k);
    }

    public static String[] getAllCombinationByText(String sentence){
        String[] arr = sentence.split(" ");
        String result[] = getAllCombination(arr, arr.length);

        return result;
    }


    private static String[] getCombination(String[] arr, String prefix, int n, int k){
        boolean isUnique = false;
        String newPrefix = "";
        if (k==0){
            allCombination[index] = prefix;
            index++;
        }
        for (int i=0; i<n; i++) {
            if (!prefix.contains(arr[i])){
                newPrefix = prefix + arr[i] + " ";
                getCombination(arr, newPrefix, n, k-1);
            }else {
                continue;
            }
        }
        /*
            Same elements dont allow. I go to solve this one problem :/
         */
        return allCombination;
    }

    public static int getAsciiSum(String sentence){
        int asciiSum = 0;
        if (sentence!=null){
            char[] chars = sentence.toCharArray();
            for (int i=0; i<chars.length; i++){
                asciiSum+=chars[i];
            }
        }
        return asciiSum;
    }

    private static int factorial(int n){
        if (n==0){
            return 1;
        }else
            return factorial(n-1)*n;
    }
}
