package cn.tuyucheng.taketoday.junit5.order;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.Random.class)
class RandomOrderUnitTest {

   private static final StringBuilder output = new StringBuilder();

   @AfterAll
   static void assertOutput() {
      assertEquals("ACB", output.toString());
   }

   @Test
   void myATest() {
      output.append("A");
   }

   @Test
   void myBTest() {
      output.append("B");
   }

   @Test
   void myCTest() {
      output.append("C");
   }
}