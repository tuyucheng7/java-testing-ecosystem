package cn.tuyucheng.taketoday;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComparisonFunctionUnitTest {

   @Test
   public void test_findMax() {
      assertEquals(20, Math.max(10, 20));
   }

   @Test
   public void test_findMin() {
      assertEquals(10, Math.min(10, 20));
   }

}
