package cn.tuyucheng.taketoday.junit5.order;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlphanumericOrderUnitTest {
   private static final StringBuilder output = new StringBuilder("");

   @AfterAll
   static void assertOutput() {
      assertEquals("ABa", output.toString());
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
   void myaTest() {
      output.append("a");
   }
}