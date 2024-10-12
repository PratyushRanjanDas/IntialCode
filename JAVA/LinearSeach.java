import java.util.Scanner;
public class LinearSeach {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("the no of elements");
        int N = scan.nextInt();

        int[] Arr = new int[N];

        System.out.println("elements:");
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = scan.nextInt();
        }

        System.out.println("the input elements are");
        for (int i = 0; i <Arr.length; i++) {
            System.out.println(Arr[i]);
        }
        System.out.println("enter the element to search");
        int ser = scan.nextInt();

        for (int i = 0; i < Arr.length ; i++){
            if (Arr[i] == ser) {
                System.out.println("the enter " + ser + " element is present");
            }
            else
            {
                System.out.println("element not present ");
            }
        }


    }

}
