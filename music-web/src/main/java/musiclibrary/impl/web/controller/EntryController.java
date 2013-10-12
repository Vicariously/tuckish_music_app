package musiclibrary.impl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntryController {

	@RequestMapping("/hello")
	public ModelAndView redirectToHome(){
		ModelAndView m = new ModelAndView("hello");
		
		//add string into a model named "model", which can be grabbed in jsp via ${model}
		m.addObject("model", "hey this is meghan and i miss tucker."); 
		
		return m;
	}
}
