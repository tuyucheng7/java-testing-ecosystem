package cn.tuyucheng.taketoday.systemrules;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ProvideSystemProperty;

import static org.junit.Assert.assertEquals;

public class ProvidesSystemPropertyWithRuleUnitTest {

   @Rule
   public final ProvideSystemProperty providesSystemPropertyRule = new ProvideSystemProperty("log_dir", "test/resources").and("another_property", "another_value");

   @Rule
   public final ProvideSystemProperty providesSystemPropertyFromFileRule = ProvideSystemProperty.fromResource("/test.properties");

   @BeforeClass
   public static void setUpBeforeClass() {
      setLogs();
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception {
      System.out.println(System.getProperty("log_dir"));
   }

   private static void setLogs() {
      System.setProperty("log_dir", "/tmp/tuyucheng/logs");
   }

   @Test
   public void givenProvideSystemProperty_whenGetLogDir_thenLogDirIsProvidedSuccessfully() {
      assertEquals("log_dir should be provided", "test/resources", System.getProperty("log_dir"));
   }

   @Test
   public void givenProvideSystemPropertyFromFile_whenGetName_thenNameIsProvidedSuccessfully() {
      assertEquals("name should be provided", "tuyucheng", System.getProperty("name"));
      assertEquals("version should be provided", "1.0", System.getProperty("version"));
   }
}