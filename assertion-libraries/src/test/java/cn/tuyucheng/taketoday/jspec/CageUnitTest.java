package cn.tuyucheng.taketoday.jspec;

import org.javalite.test.jspec.DifferenceExpectation;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.javalite.test.jspec.JSpec.*;

class CageUnitTest {

   Cat tomCat = new Cat("Tom");
   Cat felixCat = new Cat("Felix");
   Dog boltDog = new Dog("Bolt");
   Cage cage = new Cage();


   @Test
   void puttingAnimals_shouldIncreaseCageSize() {
      // When
      cage.put(tomCat, boltDog);

      // Then
      the(cage.size()).shouldEqual(2);
   }

   @Test
   void releasingAnimals_shouldDecreaseCageSize() {
      // When
      cage.put(tomCat, boltDog);
      cage.release(tomCat);

      // Then
      the(cage.size()).shouldEqual(1);
   }

   @Test
   void puttingAnimals_shouldLeaveThemInsideTheCage() {
      // When
      cage.put(tomCat, boltDog);

      // Then
      the(cage).shouldHave("animals");
   }

   @Test
   void openingTheCage_shouldReleaseAllAnimals() {
      // When
      cage.put(tomCat, boltDog);

      // Then
      the(cage).shouldNotBe("empty");

      // When
      cage.open();

      // Then
      the(cage).shouldBe("empty");
      the(cage.isEmpty()).shouldBeTrue();
   }

   @Test
   void comparingTwoDogs() {
      // When
      Dog firstDog = new Dog("Rex");
      Dog secondDog = new Dog("Rex");

      // Then
      $(firstDog).shouldEqual(secondDog);
      $(firstDog).shouldNotBeTheSameAs(secondDog);
   }

   @Test
   void puttingCatsOnly_shouldLetCageAnimalsToContainCats() {
      // When
      cage.put(tomCat, felixCat);

      // Then
      Set<Animal> animals = cage.getAnimals();
      the(animals).shouldContain(tomCat);
      the(animals).shouldContain(felixCat);
      the(animals).shouldNotContain(boltDog);
   }

   @Test
   void puttingCatsOnly_shouldLetCageToContainCats() {
      // When
      cage.put(tomCat, felixCat);

      // Then
      // Check with toString of the tested objects
      the(cage).shouldContain(tomCat);
      the(cage).shouldContain(felixCat);
      the(cage).shouldNotContain(boltDog);
   }

   @Test
   void puttingMoreAnimals_shouldChangeSize() {
      // When
      cage.put(tomCat, boltDog);

      // Then
      expect(new DifferenceExpectation<Integer>(cage.size()) {

         @Override
         public Integer exec() {
            cage.release(tomCat);
            return cage.size();
         }
      });
   }


   @Test
   void releasingTheDog_shouldReleaseAnAnimalOfDogType() {
      // When
      cage.put(boltDog);
      Animal releasedAnimal = cage.release(boltDog);

      // Then
      the(releasedAnimal).shouldNotBeNull();
      the(releasedAnimal).shouldBeA(Dog.class);
   }
}