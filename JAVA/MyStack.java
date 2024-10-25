import java.util.Scanner;

public class MyStack {
    int[] Stack;
    static final int Default_Size = 5;

    int Top = -1 ;

    public MyStack()
    {
        this(Default_Size);
    }

    public MyStack(int size)
    {
        this.Stack = new int[size];
    }

    void Push()
    {
        //if the stack is already full
        Scanner sn = new Scanner(System.in);
        if (Top == Default_Size -1 )
            System.out.println("Stack Overflow");
        //to push stack's element
        else
        {
            System.out.print("Enter your Element :");
            int ele = sn.nextInt();
            Top = Top + 1;
            Stack[Top] = ele;
        }
    }

    void  Pull(){
        //if stack has no element
        if (Top == -1)
            System.out.println("Stack Underflow");
        else
        //now those stacks have an element we have to pull the top
        {
            System.out.println("the deleted element is " +Stack[Top]);
            Top = Top - 1;
        }
    }

    void Peek()
    {
        //if stack has no element
        if (Top == -1)
            System.out.println("Stack Underflow");
        else
        //now to see the top element of stack
        {
            System.out.println("the current element is" + Stack[Top]);
        }
    }

    void Show()
    {
        //if stack has no element
        if (Top == -1)
            System.out.println("Stack Underflow");
        else
        //now those stacks have an element, to display all elements
        {
            System.out.print("The Stack's Element : [ ");
            for (int i = 0; i <= Top; i++)
                System.out.print("'" + Stack[i] + "'" + " ");
            System.out.println("]");
        }
    }

    public void main() {
        Scanner sn = new Scanner(System.in);
        System.out.println("1. Push");
        System.out.println("2. Pull");
        System.out.println("3. Peek");
        System.out.println("4. Show");
        System.out.println("5. Exit");
        while (true) {
            System.out.print("Choose  an operation: ");
            int choice = sn.nextInt();
            switch (choice) {
                case 1:
                    Push();
                    break;
                case 2:
                    Pull();
                    break;
                case 3:
                    Peek();
                    break;
                case 4:
                    Show();
                    break;
                case 5:
                    System.out.println("..........BYE BYE..................");
                    System.out.println(".............................^   ^ ");
                    System.out.println("........................... (>^_^<)");
                    System.out.println("............................. u u  ");
                    System.out.println("............................. u u  ");
                    System.out.println(".............................  s  ");
                    System.out.println("...................................");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


}

