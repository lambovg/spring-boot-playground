package org.springframework.boot.sample.jsp.animal;

import java.util.Comparator;

/**
 * Sorting Animal collections by age ASC.
 * 
 * @author georgilambov
 * 
 */
public class AnimalSortAsc implements Comparator<Animal> {

	@Override
	public int compare(Animal o1, Animal o2) {
		return (Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2
				.getAge())));
	}
}