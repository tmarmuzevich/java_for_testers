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

    Point p1 = new Point (1,2);
    Point p2 = new Point (3,4);
    System.out.println("Расстояние между точками AB с координатами A(" + p1.x + "," + p1.y + ") и B(" + p2.x + "," + p2.y + ") = " + p1.distance(p2));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}