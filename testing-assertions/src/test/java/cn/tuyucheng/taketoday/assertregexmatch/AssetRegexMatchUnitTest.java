package cn.tuyucheng.taketoday.assertregexmatch;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssetRegexMatchUnitTest {

   @Test
   void whenUsingJunit5assertTrue_thenGetExpectedResult() {
      assertTrue("Java at Tuyucheng".matches(".* at Tuyucheng$"));
      assertFalse("something else".matches(".* at Tuyucheng$"));
   }

   @Test
   void whenUsingJunit5assertLinesMatch_thenGetExpectedResult() {
      assertLinesMatch(List.of(".* at Tuyucheng$"), List.of("Kotlin at Tuyucheng"));
   }

   @Test
   void whenUsingJunit5assertLinesMatch_thenEqualsIsCheckedFirst() {
      assertFalse(".* at Tuyucheng$".matches(".* at Tuyucheng$"));
      assertLinesMatch(List.of(".* at Tuyucheng$"), List.of(".* at Tuyucheng$"));
   }

   @Test
   void whenUsingAssertJMatches_thenGetExpectedResult() {
      org.assertj.core.api.Assertions.assertThat("Linux at Tuyucheng").matches(".* at Tuyucheng$");
      org.assertj.core.api.Assertions.assertThat("something unrelated").doesNotMatch(".* at Tuyucheng$");
   }

   @Test
   void whenUsingHamcrestMatches_thenGetExpectedResult() {
      org.hamcrest.MatcherAssert.assertThat("Computer science at Tuyucheng", matchesPattern(".* at Tuyucheng$"));
      org.hamcrest.MatcherAssert.assertThat("something unrelated", not(matchesPattern(".* at Tuyucheng$")));
   }
}