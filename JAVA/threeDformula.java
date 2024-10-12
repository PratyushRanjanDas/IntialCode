public class threeDformula
{
    public static class cylinder
    {

        double radius;
        double height;


         public cylinder( double radius, double height)
        {
            this.radius = radius;
            this.height = height;
        }

        public double getRadius()
        {
            return radius;
        }

        public double getHeight ()
        {
            return height;
        }

        public double getsurfaceArea ()
        {

            return (2 * Math.PI * radius) * (radius + height);

        }

        public double getVolume ()
        {

            return (3.14 * height * radius * radius );

        }
    }
    public static class cube
    {
        double side;

        public cube( double side)
        {
            this.side = side;
        }

        public double getside ()
        {
            return side;
        }


        public double getsurfacearea ()
        {

            return ( 6 * side * side );

        }

        public double getVolume ()
        {

            return ( side * side * side );

        }
    }
    
}

