package Labor1;

public class Asg2 {

        public static int gasesteMax(int[] numere) {
            int max = numere[0];
            for (int numar : numere) {
                if (numar > max) {
                    max = numar;
                }
            }
            return max;
        }

        public static int gasesteMin(int[] numere) {
            int min = numere[0];
            for (int numar : numere) {
                if (numar < min) {
                    min = numar;
                }
            }
            return min;
        }

        public static int sumaMaxExcludMin(int[] numere) {
            int sumaTotala = 0;
            int min = gasesteMin(numere);

            for (int numar : numere) {
                sumaTotala += numar;
            }

            return sumaTotala - min;
        }

        public static int sumaMinExcludMax(int[] numere) {
            int sumaTotala = 0;
            int max = gasesteMax(numere);

            for (int numar : numere) {
                sumaTotala += numar;
            }

            return sumaTotala - max;
        }
    public static void main(String[] args) {
        int[] numere = {4, 8, 3, 10, 17};

        int max = gasesteMax(numere);
        int min = gasesteMin(numere);
        int sumaMaxExcludMin = sumaMaxExcludMin(numere);
        int sumaMinExcludMax = sumaMinExcludMax(numere);

        System.out.println("Numărul maxim: " + max);
        System.out.println("Numărul minim: " + min);
        System.out.println("Suma maximă a n-1 numere: " + sumaMaxExcludMin);
        System.out.println("Suma minimă a n-1 numere: " + sumaMinExcludMax);
    }
}




