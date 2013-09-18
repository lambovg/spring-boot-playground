package org.springframework.boot.sample.jsp.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * DTO between view and action.
 * 
 * @author georgilambov
 * 
 */
public class DogBean {

	@Min(value = 1)
	@Max(value = 99)
	@NotNull
	private Integer age;

	@NotBlank
	@NotNull
	private String breed;

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
