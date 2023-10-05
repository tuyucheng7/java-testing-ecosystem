package cn.tuyucheng.taketoday.cucumber.tags.acceptance.commonutil;


import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ScenarioReport {

   private final List<String> messages = new ArrayList<>();
   private final ByteArrayOutputStream restLogOutputStream = new ByteArrayOutputStream();

   public PrintStream getRestLogPrintStream() {
      return new PrintStream(restLogOutputStream);
   }

   public void write(Scenario scenario) throws IOException {
      for (String msg : messages) {
         scenario.log(msg);
      }
      scenario.log(restLogOutputStream.toString());
      restLogOutputStream.close();
   }

   public void captureScreenShot(Scenario scenario, WebDriver driver) {
      try {
         final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshot, "image/png", "test");
      } catch (Exception exception) {
         scenario.log(exception.toString());
      }
   }
}