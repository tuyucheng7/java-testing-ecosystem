package cn.tuyucheng.taketoday.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

@Test(testName = "Date Serializer")
public class DateSerializerServiceUnitTest {
   private DateSerializerService toTest;

   @BeforeClass
   public void beforeClass() {
      toTest = new DateSerializerService();
   }

   @Test(expectedExceptions = {NullPointerException.class})
   void givenNullDate_whenSerializeDate_thenThrowsException() {
      Date dateToTest = null;

      toTest.serializeDate(dateToTest, "yyyy/MM/dd HH:mm:ss.SSS");
   }
}