package Labor1;

public class Asg3 {

        public static void main(String[] args) {
            int[] numar1 = {1, 3, 0, 0, 0, 0, 0, 0, 0}; // 130000000
            int[] numar2 = {8, 7, 0, 0, 0, 0, 0, 0, 0}; // 870000000

            int[] suma = aduna(numar1, numar2);
            int[] diferenta = scade(numar1, numar2);
            int[] inmultire = inmulteste(numar1, 2);
            int[] diviziune = imparte(numar1, 2);

            System.out.println("Sumă: " + arrayToString(suma));
            System.out.println("Diferență: " + arrayToString(diferenta));
            System.out.println("Înmulțire: " + arrayToString(inmultire));
            System.out.println("Diviziune: " + arrayToString(diviziune));
        }

        public static int[] aduna(int[] a, int[] b) {
            int n = Math.max(a.length, b.length);
            int[] suma = new int[n + 1];
            int carry = 0;

            for (int i = 0; i < n; i++) {
                int cifraA = (i < a.length) ? a[a.length - 1 - i] : 0;
                int cifraB = (i < b.length) ? b[b.length - 1 - i] : 0;
                int tempSuma = cifraA + cifraB + carry;
                suma[n - i] = tempSuma % 10;
                carry = tempSuma / 10;
            }
            suma[0] = carry;

            return suma[0] == 0 ? java.util.Arrays.copyOfRange(suma, 1, suma.length) : suma;
        }

        public static int[] scade(int[] a, int[] b) {
            int n = Math.max(a.length, b.length);
            int[] diferenta = new int[n];
            int borrow = 0;
            boolean esteNegativ = false;

            if (a.length < b.length || (a.length == b.length && compare(a, b) < 0)) {
                int[] temp = a;
                a = b;
                b = temp;
                esteNegativ = true;
            }

            for (int i = 0; i < n; i++) {
                int cifraA = (i < a.length) ? a[a.length - 1 - i] : 0;
                int cifraB = (i < b.length) ? b[b.length - 1 - i] : 0;
                int tempDiff = cifraA - cifraB - borrow;

                if (tempDiff < 0) {
                    tempDiff += 10;
                    borrow = 1;
                } else {
                    borrow = 0;
                }
                diferenta[n - 1 - i] = tempDiff;
            }

            while (diferenta.length > 1 && diferenta[0] == 0) {
                diferenta = java.util.Arrays.copyOfRange(diferenta, 1, diferenta.length);
            }

            if (esteNegativ) {
                int[] rezultat = new int[diferenta.length + 1];
                rezultat[0] = 1; // Semn negativ
                System.arraycopy(diferenta, 0, rezultat, 1, diferenta.length);
                return rezultat;
            }

            return diferenta;
        }

        public static int[] inmulteste(int[] a, int b) {
            int n = a.length;
            int[] produs = new int[n + 1];
            int carry = 0;

            for (int i = n - 1; i >= 0; i--) {
                int tempProd = a[i] * b + carry;
                produs[i + 1] = tempProd % 10;
                carry = tempProd / 10;
            }
            produs[0] = carry;

            return produs[0] == 0 ? java.util.Arrays.copyOfRange(produs, 1, produs.length) : produs;
        }

    public static int[] imparte(int[] a, int b) {
        int n = a.length;
        int[] cat = new int[n];
        int temp = 0;
        int index = 0;

        for (int i = 0; i < n; i++) {
            temp = temp * 10 + a[i];
            cat[i] = temp / b;
            temp = temp % b;
        }

        // Eliminăm zero-urile din fața rezultatului
        while (index < n && cat[index] == 0) {
            index++;
        }

        // Dacă am găsit zero-uri, ajustăm dimensiunea rezultatului
        if (index == n) {
            return new int[]{0}; // Dacă rezultatul este zero
        }

        return java.util.Arrays.copyOfRange(cat, index, n);
    }


    public static String arrayToString(int[] array) {
            StringBuilder sb = new StringBuilder();
            for (int num : array) {
                sb.append(num);
            }
            return sb.toString();
        }

        public static int compare(int[] a, int[] b) {
            if (a.length != b.length) {
                return Integer.compare(a.length, b.length);
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return Integer.compare(a[i], b[i]);
                }
            }
            return 0; // a și b sunt egale
        }
}



