package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p = new Point (4,6,1,8.8);
    Assert.assertEquals(p.distance(),4.1036569057366385);
  }
}
