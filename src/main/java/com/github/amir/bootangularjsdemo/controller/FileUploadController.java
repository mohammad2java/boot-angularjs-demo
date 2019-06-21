package com.github.amir.bootangularjsdemo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/uploadfile")
	public String doUploadFile(@RequestParam("file") MultipartFile file,@RequestParam("name") String name,ModelMap map) throws IOException {
		String ret ="uploaded";
		byte[] bytes = file.getBytes();
		//saving into disk
		String filepath = System.getProperty("user.home")+"/"+file.getOriginalFilename();
		Files.write(Paths.get(filepath), bytes);
		log.info("form-name:"+name);
		return ret+name;
	}
	
}
