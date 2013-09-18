package org.springframework.boot.sample.jsp.animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 
 * @author georgilambov
 * 
 */
public class AnimalSortTest {

	@Test(dataProvider = "dogAnimals")
	public void animalsSortByAgeDesc(List<Dog> dogs) {

		List<Animal> animals = new ArrayList<Animal>();
		animals.addAll(dogs);

		// retrieve extreme positions.
		Dog dog2 = dogs.get(1);
		Dog dog3 = dogs.get(2);

		Collections.sort(animals, new AnimalSortDesc());

		Assert.assertEquals(animals.get(0).getAge(), dog2.getAge());
		Assert.assertEquals(animals.get(animals.size() - 1).getAge(),
				dog3.getAge());
	}

	@Test(dataProvider = "dogAnimals")
	public void animalsSortByAgeAsc(List<Dog> dogs) {
		List<Animal> animals = new ArrayList<Animal>();
		animals.addAll(dogs);
		Collections.sort(animals, new AnimalSortAsc());

		// retrieve extreme positions.
		Dog dog2 = dogs.get(1);
		Dog dog3 = dogs.get(2);

		Assert.assertEquals(animals.get(0).getAge(), dog3.getAge());
		Assert.assertEquals(animals.get(animals.size() - 1).getAge(),
				dog2.getAge());

	}
}
