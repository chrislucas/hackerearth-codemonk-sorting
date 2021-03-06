package problems;

import java.io.*;
import java.util.StringTokenizer;

/**
 * DONE
 * */
public class TestUnderstanding {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
    public static void run(int [] array) {
        int maxValue = array[0];
        // get max value
        for(int i=1; i<array.length; i++){
            if(array[i] > maxValue)
                maxValue = array[i];
        }
        int [] frequencies = new int[maxValue+1];
        // count frequencies
        for(int i=0; i<array.length; i++)
            frequencies[array[i]]++;
        int aux [] = new int[array.length];
        for(int i=0, k=0; i<frequencies.length; i++) {
            for(int frequency = frequencies[i]; frequency>0; frequency--) {
                aux[k++] = i;
            }
        }
        for(int i=0; i<aux.length; i++) {
            if(aux[i] == 0 || (i < aux.length-1 && aux[i] == aux[i+1]))
                continue;
            writer.printf("%d %d\n", aux[i], frequencies[aux[i]]);
        }
    }
    public static void main(String[] args) {
        try {
            int nums = Integer.parseInt(reader.readLine());
            int [] array = new int[nums];
            StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
            for(int i=0; i<nums; i++)
                array[i] = Integer.parseInt(tk.nextToken());
            run(array);
        } catch (IOException ioex) { }
    }
}
