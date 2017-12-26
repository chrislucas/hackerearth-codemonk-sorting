package impl;

public class CountingSorting {

    public static void asc(int [] array) {
        int maxValue = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i]  > maxValue)
                maxValue = array[i];
        }
        int [] frequencies = new int[maxValue + 1];
        for(int i=0; i<frequencies.length; i++)
            frequencies[i] = 0;
        for(int i=0; i<array.length; i++)
            frequencies[array[i]] += 1;

        int [] aux = new int[array.length];
        for(int i=0,  k=0; i<frequencies.length; i++) {
            for(int q = frequencies[i]; q>0; q--) {
                aux[k++] = i;
            }
        }
        System.arraycopy(aux, 0, array, 0, array.length);
    }

    public static void desc(int [] array) {
        int maxValue = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i]  > maxValue)
                maxValue = array[i];
        }
        int [] frequencies = new int[maxValue + 1];
        for(int i=0; i<frequencies.length; i++)
            frequencies[i] = 0;
        for(int i=0; i<array.length; i++)
            frequencies[array[i]] += 1;
        int [] aux = new int[array.length];
        for(int i=frequencies.length-1,  k=0; i>=0; i--) {
            for(int q = frequencies[i]; q>0; q--) {
                aux[k++] = i;
            }
        }
        System.arraycopy(aux, 0, array, 0, array.length);
    }

    public static void test() {
        int [][] matrix = {
             {10,5,5,4,2,1,3,10}
            ,{5,2,9,5,2,3,5}
        };
        int idx = 0;
        desc(matrix[idx]);
        for(int i : matrix[idx])
            System.out.printf("%d ", i);
        System.out.println("");
    }

    public static void main(String[] args) {
        test();
    }

}
