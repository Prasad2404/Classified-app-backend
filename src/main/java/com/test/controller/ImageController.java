package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.model.Advertisement;
import com.test.service.AdvertisementService;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file)
	{
		Map<String, String> response=new HashMap<>();
		try
		{
			advertisementService.store(file);
			response.put("status", "success");
			response.put("message", "file uploaded successfully!!");
			return new ResponseEntity<Map>(response,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			response.put("status", "failed");
			response.put("message", e.getMessage());
			return new ResponseEntity<Map>(response,HttpStatus.BAD_REQUEST);
		}
		
			
	}
	
	
	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable long id)
	{
		Advertisement fileDB=advertisementService.getFile(id);
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(fileDB.getData(),headers, HttpStatus.OK);
	}
	

}
