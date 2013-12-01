package musiclibrary.impl.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/stream")
public class EntryController {

	@RequestMapping("/play")
	public void playSong(@RequestParam(value = "artist", required = false) String artist, @RequestParam(value = "album", required = false) String album,
			@RequestParam(value = "song", required = false) String song, HttpServletResponse response) throws IOException {

		response.setContentType("audio/mpeg");
		String path = "/home/meghan/Desktop/Documents/TestMusicDirectory/" + artist + "/" + album + "/" + song;
		FileSystemResource resource = new FileSystemResource(path);
		File mp3 = resource.getFile();

		try {
			ServletOutputStream os = response.getOutputStream();
			InputStream is = resource.getInputStream();
			IOUtils.copy(is, os);
			response.flushBuffer(); // forces stream to be written to client
		} catch (IOException e) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
}
