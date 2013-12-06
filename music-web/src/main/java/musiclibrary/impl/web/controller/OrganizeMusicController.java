package musiclibrary.impl.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/app/list/*")
public class OrganizeMusicController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView redirectToHome() {
		ModelAndView m = new ModelAndView("hello");

		// add string into a model named "model", which can be grabbed in jsp
		// via ${model}
		m.addObject("model", "hey this is meghan and i miss tucker.");

		return m;
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public ModelAndView selectItem(@RequestParam(value = "artist", required = false) String artist,
			@RequestParam(value = "album", required = false) String album, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView m = new ModelAndView("list");
		String path = "/home/meghan/Desktop/Documents/TestMusicDirectory/";

		if (artist != null) {
			m.addObject("artist", artist);
			path = path + artist;
		}
		if (album != null) {
			m.addObject("album", album);
			path = path + "/" + album;
		}

		m.addObject("path", path);
		File file = new File(path);
		String name = "";

		if (file.exists()) {
			name = file.getName();

			if (file.isDirectory()) {
				String[] directory = file.list();
				m.addObject("directory", directory);
			} else {
				m.addObject("filename", name);
			}
		}
		return m;
	}
}