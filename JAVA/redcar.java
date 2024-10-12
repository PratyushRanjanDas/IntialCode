public class redcar
{
    static class  car
    {
        int year;
        int speed;

        void acc()
        {
            speed += 10;
            System.out.println("new speed is " + speed);
        }

        void brk()
        {
            speed -= 5;
            System.out.println("new speed is " + speed);
        }
        public car(int carSpeed , int carYear){
            year = carYear;
            speed = carSpeed;

        }
    }

    public static  void main(String[] args)
    {
        car redcar = new car(890 , 2022);

        redcar.acc();
        redcar.acc();
        redcar.brk();
    }




}


