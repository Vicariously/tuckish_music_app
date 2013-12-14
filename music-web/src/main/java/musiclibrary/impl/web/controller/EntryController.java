package musiclibrary.impl.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import musiclibrary.impl.common.model.Song;
import musiclibrary.impl.common.service.SongService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app/*")
public class EntryController {
	
	@Autowired
	SongService songService;

	@RequestMapping(value = "/play", method = RequestMethod.GET)
	public void playSong(@RequestParam(value = "artist", required = false) String artist, @RequestParam(value = "album", required = false) String album,
			@RequestParam(value = "song", required = false) String song, HttpServletResponse response) throws IOException {

		response.setContentType("audio/mpeg");
		ClassPathResource resource = new ClassPathResource("mp3/jolene.mp3");

		try {
			ServletOutputStream os = response.getOutputStream();
			InputStream is = resource.getInputStream();
			IOUtils.copy(is, os);
			response.flushBuffer(); // forces stream to be written to client
		} catch (IOException e) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public ModelAndView showSongs(){
		ModelAndView mv = new ModelAndView("modelTester");
		List<Song> songs = this.songService.getSongs();
		mv.addObject("songs",songs);
		return mv;
	}
}
