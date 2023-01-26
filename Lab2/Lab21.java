
class Point {
    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return new String(this.x + " " + this.y);
    }
}



class Circle {
    private int radius;
    private Point center;

    public Circle() {
        this.radius = 1;
        this.center = new Point();

    }

    public Circle(int radius) {
        this.radius = radius;
        this.center = new Point();
    }

    public Circle(Point center) {
        this.radius = 1;
        this.center = center;
    }

    public Circle(int radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double area() {
        double a = Math.PI * this.radius * this.radius;
        return a;
    }

    public double circumference() {
        double a = Math.PI * 2 * this.radius;
        return a;
    }

    public String toStringC() {

        return new String("radius-" + this.radius + "  Center-" + this.center);
    }

}


public class Lab21 {
   public static void main(String[] args) {
      Point p1 = new Point();
      Circle c1 = new Circle();
      Point p2 = new Point(10, 12);
      Point p3 = new Point(24, 16);
      Circle c2 = new Circle(p2);
      System.out.println("Circle one__________");
      System.out.println("Area = " + c2.area() + " Circumference = " + c2.circumference());
      System.out.println(c2.toStringC());
      System.out.println("");
      Circle c3 = new Circle(11, p3);
      System.out.println("Circle 2____________");
      System.out.println("Area = " + c3.area() + " Circumference = " + c3.circumference());
      System.out.println(c3.toStringC());

   }
}

