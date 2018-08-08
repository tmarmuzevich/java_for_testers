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

    Point p = new Point (2.3,9,7.5,1.8);
    System.out.println("Расстояние между точками AB с координатами A(" + p.x1 + "," + p.y1 + ") и B(" + p.x2 + "," + p.y2 + ") = " + p.distance());

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}