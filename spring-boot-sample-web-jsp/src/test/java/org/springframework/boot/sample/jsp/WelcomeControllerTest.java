package org.springframework.boot.sample.jsp;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.sample.jsp.bean.DogBean;
import org.springframework.boot.sample.jsp.service.DogAnimalManager;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 
 * @author georgilambov
 * 
 */
public class WelcomeControllerTest {

	private WelcomeController welcomeController;

	private DogAnimalManager dogAnimalManager;
	@Mock
	private DogBean dogBean;
	@Mock
	private DogBean validDogBean;

	@Mock
	private Model model;
	@Mock
	private BindingResult result;
	@Mock
	private HttpServletRequest request;

	@BeforeClass
	public void init() {
		welcomeController = new WelcomeController();
		dogAnimalManager = new DogAnimalManager();
	}

	@BeforeMethod
	public void initMethod() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(welcomeController, "dogAnimalManager",
				dogAnimalManager);
		ReflectionTestUtils.setField(welcomeController, "dogBean", dogBean);
	}

	@Test
	public void welcomeModel() {
		welcomeController.welcome(model);
		verify(model).addAttribute("dog", dogBean);
	}

	@Test
	public void welcomePostWithValidResult() {
		when(result.hasErrors()).thenReturn(false);

		int expectedDogs = dogAnimalManager.getDogs().size();
		welcomeController.welcome(validDogBean, result, model, request);
		int actualDogs = dogAnimalManager.getDogs().size();

		verify(result).hasErrors();
		Assert.assertEquals(actualDogs, expectedDogs + 1);
	}

	@Test
	public void welcomePostWithValidInvalidResult() {
		when(result.hasErrors()).thenReturn(true);
		welcomeController.welcome(dogBean, result, model, request);
		verify(result).hasErrors();
		verify(model).addAttribute("dog", dogBean);
		Assert.assertEquals(dogAnimalManager.getDogs().size(), 0);
	}
}
