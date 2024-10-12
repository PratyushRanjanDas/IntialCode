import java.util.Scanner;

public class cylnvol
{
    public static void main(String[] args)
        {
            double R= 0, H = 0 ;

            Scanner scn = new Scanner(System.in);

            System.out.println("enter heigth");
            H = scn.nextInt();

            System.out.println("enter radius");
            R = scn.nextInt();

            threeDformula.cylinder volumefinder = new threeDformula.cylinder(R,H);

            System.out.println("radius: " + volumefinder.getRadius());

            System.out.println("height: " + volumefinder.getHeight());

            System.out.println("volume: " + volumefinder.getVolume());

            System.out.println("surface area : " + volumefinder.getsurfaceArea());
        }

}
