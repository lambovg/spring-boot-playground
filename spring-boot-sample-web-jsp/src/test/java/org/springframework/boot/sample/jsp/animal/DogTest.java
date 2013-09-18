package org.springframework.boot.sample.jsp.animal;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author georgilambov
 * 
 */
public class DogTest {

	@Test
	public void immutableBehaviour() {
		Dog dog = new Dog("a", 1);
		Dog chaochao = new Dog("a", 1);
		chaochao.setAge(12);

		Assert.assertEquals(chaochao, dog);
		Assert.assertEquals(chaochao.hashCode(), dog.hashCode());

		String s = new String("a");
		String b = new String("a");
		Assert.assertEquals(s, b);
		Assert.assertEquals(s.hashCode(), b.hashCode());
	}

}
