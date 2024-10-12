
    import java.util.Scanner;

    public class vstudent {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            final int NUM_STUDENTS = 5;
            final int NUM_SUBJECTS = 4;

            String[] students = new String[NUM_STUDENTS];
            int[][] marks = new int[NUM_STUDENTS][NUM_SUBJECTS];
            for (int i = 0; i < NUM_STUDENTS; i++) {
                System.out.println("Enter the name of student " + (i + 1) + ": ");
                students[i] = scanner.nextLine();

                System.out.println("Enter the marks for 4 subjects for " + students[i] + ": ");
                int totalMarks = 0;
                for (int j = 0; j < NUM_SUBJECTS; j++) {
                    System.out.print("Subject " + (j + 1) + ": ");
                    marks[i][j] = scanner.nextInt();
                    totalMarks += marks[i][j];
                }
                scanner.nextLine();        }

            System.out.println("\nStudent Marks Details:");
            for (int i = 0; i < NUM_STUDENTS; i++) {
                int totalMarks = 0;
                int highestMark = Integer.MIN_VALUE;
                int lowestMark = Integer.MAX_VALUE;

                System.out.println("\nMarks for " + students[i] + ":");
                for (int j = 0; j < NUM_SUBJECTS; j++) {
                    System.out.print("Subject " + (j + 1) + ": " + marks[i][j] + " ");
                    totalMarks += marks[i][j];
                    if (marks[i][j] > highestMark) {
                        highestMark = marks[i][j];
                    }
                    if (marks[i][j] < lowestMark) {
                        lowestMark = marks[i][j];
                    }
                }
                double averageMarks = (double) totalMarks / NUM_SUBJECTS;

                System.out.println("\nTotal Marks: " + totalMarks);
                System.out.println("Average Marks: " + averageMarks);
                System.out.println("Highest Mark: " + highestMark);
                System.out.println("Lowest Mark: " + lowestMark);
            }

            scanner.close();
        }
    }

