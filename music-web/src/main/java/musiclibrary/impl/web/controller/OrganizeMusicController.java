package musiclibrary.impl.web.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musiclibrary.impl.common.service.OrganizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/app/list/*")
public class OrganizeMusicController {
	
	private String homepath = "/home/meghan/Desktop/Documents/TestMusicDirectory/"; //this needs to be injected, via a system variable maybe?
	
	@Autowired
	private OrganizeService service;

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public @ResponseBody Map selectItem(@RequestParam(value = "artist", required = false) String artist, @RequestParam(value = "album", required = false) String album, HttpServletResponse response) {
		
		Map dirList = new HashMap<String, Object>();
		String path = homepath;
		
		dirList.put("parentPath", path);
		
		if (artist != null) {
			path = path + artist;
			dirList.put("artist", artist);
		}
		if (album != null) {
			path = path + "/" + album;
			dirList.put("album", album);
		}

		dirList.put("path", path);
		File file = new File(path);

		if (file.exists()) {
			if (file.isDirectory()) {
				String[] directory = file.list();
				dirList.put("directory", directory);
			} else {
				dirList.put("fileName", file.getName());
			}
		}
		return dirList;
	}
	
	@RequestMapping(value = "/organize", method = RequestMethod.GET)
	public @ResponseBody Map organizeItems(@RequestParam(value="item", required=true) String item, @RequestParam(value = "type", required=true) String type){
		Map items = new HashMap<String, Object>();
		
		
		
		return items;
	}
}