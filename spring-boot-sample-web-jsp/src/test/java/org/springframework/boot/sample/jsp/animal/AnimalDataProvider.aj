package org.springframework.boot.sample.jsp.animal;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

/**
 * 
 * @author georgilambov
 * 
 */
privileged aspect AnimalDataProvider {

	public AnimalDataProvider() {
		// must be empty
	}

	/**
	 * Retrieves dog collection for tests.
	 * 
	 * @return
	 */
	@DataProvider
	public Object[][] AnimalSortTest.dogAnimals() {

		Dog dog1 = new Dog("breed1", 12);
		Dog dog2 = new Dog("breed2", 13);
		Dog dog3 = new Dog("breed3", 9);
		Dog dog4 = new Dog("breed4", 10);

		return new Object[][] { { Arrays.asList(dog1, dog2, dog3, dog4) } };
	}

}
