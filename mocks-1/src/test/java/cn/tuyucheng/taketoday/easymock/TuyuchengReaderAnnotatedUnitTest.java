package cn.tuyucheng.taketoday.easymock;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.*;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import static org.easymock.EasyMock.*;

@RunWith(EasyMockRunner.class)
public class TuyuchengReaderAnnotatedUnitTest {

   @Mock
   ArticleReader mockArticleReader;

   @Mock
   IArticleWriter mockArticleWriter;

   @TestSubject
   TuyuchengReader tuyuchengReader = new TuyuchengReader();

   @Test
   public void givenTuyuchengReader_whenReadNext_thenNextArticleRead() {
      expect(mockArticleReader.next()).andReturn(null);
      replay(mockArticleReader);
      tuyuchengReader.readNext();
      verify(mockArticleReader);
   }

   @Mock
   TuyuchengReader mockTuyuchengReader;

   @Test
   public void givenTuyuchengReader_whenWrite_thenWriterCalled() {
      expect(mockArticleWriter.write("title", "content")).andReturn(null);
      replay(mockArticleWriter);
      tuyuchengReader.write("title", "content");
      verify(mockArticleWriter);
   }

   @Test
   public void givenArticlesInReader_whenReadTillEnd_thenThrowException() {
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