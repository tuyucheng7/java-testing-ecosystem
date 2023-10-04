package cn.tuyucheng.taketoday.easymock;

import org.easymock.*;
import org.junit.*;

import static org.easymock.EasyMock.*;

public class TuyuchengReaderMockDelegationUnitTest {

   EasyMockSupport easyMockSupport = new EasyMockSupport();

   @Test
   public void givenTuyuchengReader_whenReadAndWriteSequencially_thenWorks() {
      ArticleReader mockArticleReader = easyMockSupport.createMock(ArticleReader.class);
      IArticleWriter mockArticleWriter = easyMockSupport.createMock(IArticleWriter.class);
      TuyuchengReader tuyuchengReader = new TuyuchengReader(mockArticleReader, mockArticleWriter);

      expect(mockArticleReader.next()).andReturn(null);
      expect(mockArticleWriter.write("title", "content")).andReturn("");
      easyMockSupport.replayAll();

      tuyuchengReader.readNext();
      tuyuchengReader.write("title", "content");
      easyMockSupport.verifyAll();
   }
}