package cn.tuyucheng.taketoday.mockito.callbacks;

public class Response {

   private Data data;
   private boolean isValid = true;

   public boolean isValid() {
      return isValid;
   }

   public void setIsValid(boolean isValid) {
      this.isValid = isValid;
   }

   public Data getData() {
      return data;
   }

   public void setData(Data data) {
      this.data = data;
   }

}
