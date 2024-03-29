package cn.tuyucheng.taketoday.jspec;

public abstract class Animal {

   protected String name;

   public Animal(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Animal other = (Animal) obj;
      if (name == null) {
         return other.name == null;
      } else return name.equals(other.name);
   }
}