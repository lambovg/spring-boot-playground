package org.springframework.boot.sample.jsp.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.sample.jsp.animal.Dog;
import org.springframework.boot.sample.jsp.bean.DogBean;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author georgilambov
 * 
 */
public class DogAnimalManagerTest {

	private DogAnimalManager dogAnimalManager;

	@Mock
	private DogBean dogBean;

	@BeforeClass
	public void init() {
		dogAnimalManager = new DogAnimalManager();
	}

	@BeforeMethod
	public void initMethod() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void storeDogBeanToDogList() {

		when(dogBean.getAge()).thenReturn(2);
		when(dogBean.getBreed()).thenReturn("my breed");

		List<Dog> store = dogAnimalManager.store(dogBean);

		Assert.assertNotNull(store.get(0));
		Dog dog = store.get(0);
		Assert.assertTrue(dog instanceof Dog);

		verify(dogBean).getAge();
		verify(dogBean).getBreed();

		Assert.assertEquals(dogBean.getAge().intValue(), dog.getAge());
		Assert.assertEquals(dogBean.getBreed(), dog.getBreed());

	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void storeNullDogBeanToDogList() {
		dogAnimalManager.store(null);
	}
}
