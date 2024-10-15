import java.util.Arrays;

public class Asg1 {

        // returns an array of failing grades
        public static int[] note_picate(int[] grades){
            int count = 0;
            for (int grade : grades)
                if (grade < 40)
                    count++;
            int[] failing_grades = new int[count];
            int index = 0;
            for (int grade : grades)
                if (grade < 40) {
                    failing_grades[index] = grade;
                    index++;
                }
            return failing_grades;
        }

        // returns the average value
        public static double media_aritm(int[] grades) {
            if (grades.length == 0)
                return 0.00;
            int sum = 0;
            for (int grade : grades)
                sum += grade;
            double average_value = (double) sum / grades.length;
            average_value = (int) (average_value * 100) / 100.0;
            return average_value;
        }

        // returns an array of rounded grades
        public static int[] note_rotunjite(int[] grades){
            int[] rounded_grades = new int[grades.length];
            for (int i=0; i<grades.length; i++)
                if (grades[i] >= 38 && (5 - (grades[i] % 5)) < 3)//se obtine cel mai apropiat multiplu de 5, si verif. daca dif este mai mica decat 3
                    rounded_grades[i] = grades[i] + (5 - (grades[i] % 5));
                else
                    rounded_grades[i] = grades[i];
            return rounded_grades;
        }

        // returns the max rounded grade
        public static int celMaiMareNr(int[] grades) {
            int[] rounded_grades = note_rotunjite(grades);
            int max = rounded_grades[0];
            for (int grade : rounded_grades)
                if (grade > max)
                    max = grade;
            return max;
        }

        public static void main(String[] args) {
            // display initial grades
            int[] grades = {29, 37, 38, 41, 84, 67};
            System.out.println("All grades: " + Arrays.toString(grades));
            // display failing grades
            int[] note_picate = Asg1.note_picate(grades);
            System.out.println("Note picate: " + Arrays.toString(note_picate));
            // display average grade
            System.out.println("Media aritmetica: " + Asg1.media_aritm(grades));
            // display rounded grades
            int[] rounded_grades = Asg1.note_rotunjite(grades);
            System.out.println("Note rotunjite: " + Arrays.toString(rounded_grades));
            // display max rounded grade
            int max_rounded_grade = Asg1.celMaiMareNr(grades);
            System.out.println("Cel mai mare nr: " + max_rounded_grade);
        }

    }
