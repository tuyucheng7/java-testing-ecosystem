package cn.tuyucheng.taketoday.easymock;

import org.junit.*;

import java.util.NoSuchElementException;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class TuyuchengReaderUnitTest {

   private TuyuchengReader tuyuchengReader;

   private ArticleReader mockArticleReader;

   private IArticleWriter mockArticleWriter;

   @Test
   public void givenTuyuchengReader_whenReadNext_thenNextArticleRead() {
      mockArticleReader = mock(ArticleReader.class);
      tuyuchengReader = new TuyuchengReader(mockArticleReader);

      expect(mockArticleReader.next()).andReturn(null);
      replay(mockArticleReader);

      TuyuchengArticle article = tuyuchengReader.readNext();
      verify(mockArticleReader);
      assertEquals(null, article);
   }

   @Test
   public void givenTuyuchengReader_whenReadNextAndSkimTopics_thenAllAllowed() {
      mockArticleReader = strictMock(ArticleReader.class);
      tuyuchengReader = new TuyuchengReader(mockArticleReader);

      expect(mockArticleReader.next()).andReturn(null);
      expect(mockArticleReader.ofTopic("easymock")).andReturn(null);
      replay(mockArticleReader);

      tuyuchengReader.readNext();
      tuyuchengReader.readTopic("easymock");
      verify(mockArticleReader);
   }

   @Test
   public void givenTuyuchengReader_whenReadNextAndOthers_thenAllowed() {
      mockArticleReader = niceMock(ArticleReader.class);
      tuyuchengReader = new TuyuchengReader(mockArticleReader);

      expect(mockArticleReader.next()).andReturn(null);
      replay(mockArticleReader);

      tuyuchengReader.readNext();
      tuyuchengReader.readTopic("easymock");
      verify(mockArticleReader);
   }

   @Test
   public void givenTuyuchengReader_whenWriteMaliciousContent_thenArgumentIllegal() {
      mockArticleWriter = mock(IArticleWriter.class);
      tuyuchengReader = new TuyuchengReader(mockArticleWriter);
      expect(mockArticleWriter.write("easymock", "<body onload=alert('tuyucheng')>")).andThrow(new IllegalArgumentException());
      replay(mockArticleWriter);

      Exception expectedException = null;
      try {
         tuyuchengReader.write("easymock", "<body onload=alert('tuyucheng')>");
      } catch (Exception exception) {
         expectedException = exception;
      }

      verify(mockArticleWriter);
      assertEquals(IllegalArgumentException.class, expectedException.getClass());
   }

   @Test
   public void givenTuyuchengReader_whenWrite_thenWriterCalled() {
      mockArticleWriter = mock(IArticleWriter.class);
      tuyuchengReader = new TuyuchengReader(mockArticleWriter);
      expect(mockArticleWriter.write("title", "content")).andReturn(null);
      replay(mockArticleWriter);
      String articleId = tuyuchengReader.write("title", "content");
      verify(mockArticleWriter);
      assertEquals(null, articleId);
   }

   @Test
   public void givenArticlesInReader_whenReadTillEnd_thenThrowException() {
      ArticleReader mockArticleReader = mock(ArticleReader.class);
      tuyuchengReader = new TuyuchengReader(mockArticleReader);
      expect(mockArticleReader.next())
            .andReturn(null)
            .times(2)
            .andThrow(new NoSuchElementException());
      replay(mockArticleReader);
      try {
         for (int i = 0; i < 3; i++) {
            tuyuchengReader.readNext();
         }
      } catch (Exception ignored) {
      }
      verify(mockArticleReader);
   }
}