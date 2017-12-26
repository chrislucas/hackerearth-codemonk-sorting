package problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.hackerearth.com/practice/algorithms/sorting/counting-sort/practice-problems/algorithm/shil-and-birthday-present/
 *
 * */

public class ShillAndBirthday {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    public static void desc(int [] array) {
        int max = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] > max)
                max = array[i];
        }
        int frequencies [] = new int[max+1];
        for(int i=0; i<array.length; i++)
            frequencies[array[i]]++;

        int aux [] = new int[array.length];
        for(int i=frequencies.length-1, k=0; i>-1; i--) {
            for(int q=frequencies[i]; q>0; q--)
                aux[k++] = i;
        }
    }


    public static void main(String[] args) {
        try {
            int nums = Integer.parseInt(reader.readLine());
            int [] array = new int[nums];
            StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
            for(int i=0; i<nums; i++)
                array[i] = Integer.parseInt(tk.nextToken());
            desc(array);
        } catch (IOException ioex) { }
    }
}
