package musiclibrary.impl.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("/select")
	public ModelAndView selectItem( @RequestParam(value="item", required=false) String item, HttpServletRequest request, HttpServletResponse response ){
		ModelAndView m = new ModelAndView("list");
		m.addObject("item", item);
		
		String path = "/home/meghan/Desktop/Documents/TestMusicDirectory/"+item;
		m.addObject("path", path);
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