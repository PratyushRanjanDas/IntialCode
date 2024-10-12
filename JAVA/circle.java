import java.util.Scanner;
public class circle  {
    public static int radius;


    public static void main(String[] args) {





        Scanner scn = new Scanner(System.in);

        System.out.println("enter Radius");
        radius = scn.nextInt();
        double AREA = ( radius * 3.14 * radius );
        double PERIMETER = ( 2 * 3.14 * radius);
        System.out.println("radius " + radius);
        System.out.println("area " + AREA);
        System.out.println("perimeter " + PERIMETER);


    }
}
