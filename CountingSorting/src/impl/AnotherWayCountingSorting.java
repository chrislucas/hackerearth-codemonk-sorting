package impl;

public class AnotherWayCountingSorting {

    public static void asc(int [] array) {
        int maxValue = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i]  > maxValue)
                maxValue = array[i];
        }
        int [] frequencies = new int[maxValue + 1];
        // contar a frequencia que o elemento array[i] aparece
        for(int i=0; i<array.length; i++)
            frequencies[array[i]]++;
        /**
         * o somatorio das frequencias nos indica qual a posicao correta de cada
         * elemento no vettor 'array'
         * exemplo {0, 2, 2}
         * o somatorio sera {0,2,4} nos auxilia a posicionar em ordem crescente os elementos do array original
         * Nao temos elementos com valor '0'
         * temos 2 elementos com valor '1', que prenchem os indices {1, 0}  e temos
         * 2 elementos com valor '2' que preenchem os indices {3, 2}
         * */
        for(int i=1; i<frequencies.length; i++)
            frequencies[i] += frequencies[i-1];
        int aux [] = new int[array.length];
        for(int i=0; i<array.length; i++) {
            /**
             * array[i] tem os elementos que queremos ordenar
             * frequencies[array[i]] guarda a frequencia acumulada dos elementos em array
             * frequencies[array[i]] - 1 eh um ajuste na contagem do array e guarda a posicao que o valor em array[i] deve estar
             * aux[frequencies[array[i]-1] armazena o i-esimo elemento de array ordenado
             * */
            aux[frequencies[array[i]]-1] = array[i];
            // diminui a quantidade de array[i] do vetor de frequencia
            frequencies[array[i]]--;
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
        // contar a frequencia
        for(int i=0; i<array.length; i++)
            frequencies[array[i]]++;
        // somatorio da frequencia
        for(int i=frequencies.length-2; i>-1; i--)
            frequencies[i] += frequencies[i+1];
        int aux [] = new int[array.length];
        for(int i=0; i<array.length; i++) {
            aux[frequencies[array[i]]-1] = array[i];
            frequencies[array[i]]--;
        }
        System.arraycopy(aux, 0, array, 0, array.length);
    }

    public static void test() {
        int [][] matrix = {
             {10,5,5,4,2,1,3,10}
            ,{5,2,1,2,2,5,3}
            ,{5,2,9,5,2,3,5}
            ,{1,4,1,2,7,5,2}
            ,{0,2,2,3,3,3,1,1}
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
