package musiclibrary.impl.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import java.io.File;

@Controller
@RequestMapping("/list")
public class OrganizeMusicController{
	
	@RequestMapping("/hello")
	public ModelAndView redirectToHome(){
		ModelAndView m = new ModelAndView("hello");
		
		//add string into a model named "model", which can be grabbed in jsp via ${model}
		m.addObject("model", "hey this is meghan and i miss tucker."); 
		
		return m;
	}
	
	@RequestMapping("/testbrowse")
	public ModelAndView browseFileSystem(){
		ModelAndView m = new ModelAndView("list");
		String path = "/home/meghan/Desktop/Documents/TestMusicDirectory"; //to be set in properties file so can be tweaked without recompile
		File file = new File(path);
		String name = "";
		
		if(file.exists()){
			name = file.getName();
			
			if(file.isDirectory()){
				String[] directory = file.list();
				m.addObject("directory", directory);
			}
		}
		return m;
	}
}