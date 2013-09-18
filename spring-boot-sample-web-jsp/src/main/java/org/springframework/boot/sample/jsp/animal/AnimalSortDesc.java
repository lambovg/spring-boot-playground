package org.springframework.boot.sample.jsp.animal;

import java.util.Comparator;

/**
 * Sorting animal collections by age DESC.
 * 
 * @author georgilambov
 * 
 */
public class AnimalSortDesc implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return -(Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2
				.getAge())));
	}
}
