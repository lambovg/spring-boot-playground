package org.springframework.boot.sample.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sample.jsp.bean.DogBean;
import org.springframework.boot.sample.jsp.service.DogAnimalManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Welcome page controller
 * 
 * @author georgilambov
 * 
 */
@Controller
public class WelcomeController {

	private static final String WELCOME = "welcome";

	@Autowired
	private DogAnimalManager dogAnimalManager;
	private DogBean dogBean = new DogBean();

	/**
	 * Shows welcome page.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
	public String welcome(Model model) {
		model.addAttribute("dog", dogBean);
		return WELCOME;
	}

	/**
	 * Processes request from welcome page.
	 * 
	 * @param dog
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String welcome(@Valid DogBean dog, BindingResult result,
			Model model, HttpServletRequest request) {

		// TODO validation errors are not visible in the view.
		if (result.hasErrors()) {
			model.addAttribute("dogs", dogAnimalManager.getDogs());
			model.addAttribute("dog", dog);
			return WELCOME;
		}

		dogAnimalManager.store(dog);

		model.addAttribute("dogs", dogAnimalManager.getDogs());
		model.addAttribute("dog", dogBean);

		return WELCOME;
	}

}
