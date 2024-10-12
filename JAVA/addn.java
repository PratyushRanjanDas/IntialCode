import java.util.Scanner;

public class addn 
{
  public static void main(String[] args) 
  {
    int x, y, z, sum;
    try (Scanner myObj = new Scanner(System.in)) 
    {
      System.out.println("Type a number:");
      x = myObj.nextInt(); // Read user input
      System.out.println("Type another number:");
      y = myObj.nextInt(); // Read user input
      System.out.println("type another number");
      z = myObj.nextInt();
    }
    sum=x+y+z;
    System.out.println("sum is:" + sum);
    int t=9;
    System.out.println();
    
  }
}
