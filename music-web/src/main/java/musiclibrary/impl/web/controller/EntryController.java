package musiclibrary.impl.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.log.Log;

@Controller
@RequestMapping("/stream")
public class EntryController {

	/*
	@RequestMapping("/play/*.mp3")
	public void playSong( HttpServletResponse response) throws IOException{
			response.setContentType("audio/mpeg");
			try{
			ServletOutputStream os = response.getOutputStream();
			
			ClassPathResource resource = new ClassPathResource("mp3/jolene.mp3");
			File mp3 = resource.getFile();
			//response.setContentLengthLong(mp3.length());
			//response.setContentLengthLong(len);
			//response.setHeader( "Content-Disposition", "attachment;filename=" + mp3 );
			
			InputStream is = resource.getInputStream();
			IOUtils.copy(is, os);
			response.flushBuffer(); //forces stream to be written to client
			
			}catch(IOException e){
				throw new RuntimeException("IOError writing file to output stream");
			}
			
	}*/
	@RequestMapping("/play")
	public void playSong(@RequestParam(value="artist", required=false) String artist, @RequestParam(value="album", required=false) String album, @RequestParam(value="song", required=false) String song, 
			HttpServletResponse response) throws IOException{
		
		response.setContentType("audio/mpeg");
		String path = "/home/meghan/Desktop/Documents/TestMusicDirectory/"+artist+"/"+album+"/"+song;
		FileSystemResource resource = new FileSystemResource(path);
		File mp3 = resource.getFile();
		
		try{
			ServletOutputStream os = response.getOutputStream();
			InputStream is = resource.getInputStream();
			IOUtils.copy(is, os);
			response.flushBuffer(); //forces stream to be written to client
		}catch(IOException e){
			throw new RuntimeException("IOError writing file to output stream");
		}
	}
}
