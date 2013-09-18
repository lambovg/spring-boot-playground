package org.springframework.boot.sample.jsp.animal;


/**
 * Immutable Dog object that extends mutable {@link Animal}.
 * 
 * @author georgilambov
 * 
 */
public final class Dog extends Animal {

	private final String breed;
	private final int age;

	public static final String DEFAULT_BREED = "half-breed";

	public Dog(String breed, int age) {
		this.breed = breed;
		this.age = age;
	}

	public Dog() {
		this.breed = DEFAULT_BREED;
		this.age = 0;
	}

	public String getBreed() {
		return breed;
	}

	public int getAge() {
		return this.age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Dog))
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		return true;
	}
}
