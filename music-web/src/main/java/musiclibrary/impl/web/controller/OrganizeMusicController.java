package musiclibrary.impl.web.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import musiclibrary.impl.common.organizor.Stash;
import musiclibrary.impl.common.service.OrganizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/app/list/*")
public class OrganizeMusicController {
	
	@Value(value = "${tuckish.music.root.location}")
	private String homepath;
	
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
	public @ResponseBody Stash organizeItems(@RequestParam(value="item", required=true) String item, @RequestParam(value = "type", required=true) String type){
		Stash stash = this.service.organize(item,type);
		return stash;
	}
}