package cn.tuyucheng.taketoday.serenity.screenplay;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWith implements Task {

   private GoogleSearchPage googleSearchPage;

   public static StartWith googleSearchPage() {
      return instrumented(StartWith.class);
   }

   @Step("{0} starts a google search")
   public <T extends Actor> void performAs(T t) {
      t.attemptsTo(Open.browserOn().the(googleSearchPage));
   }

}
