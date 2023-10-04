package cn.tuyucheng.taketoday.interfaces.unittest;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleExtendsBaseUnitTest extends ShapeUnitTest {

   @Override
   public Map<String, Object> instantiateShapeWithExpectedArea() {
      Map<String, Object> shapeAreaMap = new HashMap<>();
      shapeAreaMap.put("shape", new Circle(5));
      shapeAreaMap.put("area", 78.5);
      return shapeAreaMap;
   }

   @Test
   void whenCircumferenceIsCalculated_thenSuccessful() {
      Circle circle = new Circle(2);
      double circumference = circle.circumference();
      assertEquals(12.56, circumference);
   }
}