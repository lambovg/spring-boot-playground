package org.springframework.boot.sample.jsp.animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author georgilambov
 * 
 */
public class AnimalSortTest {

	@Test
	public void animalsSortByAgeDesc() {

		List<Animal> animals = new ArrayList<Animal>();

		Dog cat1 = new Dog("type1", 12);
		Dog cat2 = new Dog("type2", 13);
		Dog cat3 = new Dog("type1", 9);
		Dog cat4 = new Dog("type1", 10);

		animals.addAll(Arrays.asList(cat1, cat2, cat3, cat4));
		Collections.sort(animals, new AnimalSortDesc());

		Assert.assertEquals(animals.get(0).getAge(), cat2.getAge());
		Assert.assertEquals(animals.get(animals.size() - 1).getAge(),
				cat3.getAge());
	}

	@Test
	public void animalsSortByAgeAsc() {
		List<Animal> animals = new ArrayList<Animal>();

		Dog cat1 = new Dog("type1", 12);
		Dog cat2 = new Dog("type2", 13);
		Dog cat3 = new Dog("type1", 9);
		Dog cat4 = new Dog("type1", 10);

		animals.addAll(Arrays.asList(cat1, cat2, cat3, cat4));
		Collections.sort(animals, new AnimalSortAsc());

		Assert.assertEquals(animals.get(0).getAge(), cat3.getAge());
		Assert.assertEquals(animals.get(animals.size() - 1).getAge(),
				cat2.getAge());

	}
}
