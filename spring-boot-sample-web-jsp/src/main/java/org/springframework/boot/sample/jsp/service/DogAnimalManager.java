package org.springframework.boot.sample.jsp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.sample.jsp.animal.AnimalSortDesc;
import org.springframework.boot.sample.jsp.animal.Dog;
import org.springframework.boot.sample.jsp.bean.DogBean;
import org.springframework.stereotype.Service;

/**
 * Store immutable dogs objects into collection and sort.
 * 
 * @author g
 * 
 */
@Service
public class DogAnimalManager {

	private List<Dog> dogs = new ArrayList<Dog>();

	public List<Dog> store(DogBean dog) {
		dogs.add(new Dog(dog.getBreed(), dog.getAge()));
		Collections.sort(dogs, new AnimalSortDesc());

		return dogs;
	}

	public List<Dog> getDogs() {
		return this.dogs;
	}

}
