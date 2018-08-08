package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Tanya");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + " = " + r.area());

    double x1=1.3;
    double y1=3.6;
    double x2=8;
    double y2=5.1;
    System.out.println("Расстояние между точками AB с координатами A(" + x1 + "," + y1 + ") и B(" + x2 + "," + y2 + ") = " + distance(x1,y1,x2,y2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double distance(double x1, double y1, double x2, double y2) {
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

  }

}