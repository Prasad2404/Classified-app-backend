package com.test.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.test.model.Advertisement;
import com.test.repository.ImageRepository;



public class ImageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	
	public Advertisement store(MultipartFile file) throws IOException
	{
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		Advertisement advertisement=new Advertisement(0L,fileName, file.getContentType(),null, false, fileName, 0, file.getBytes(), null, null);
		
		return imageRepository.save(advertisement);
	}
	
	
	public ImageRepository getFile(long id)
	{
		return (ImageRepository) imageRepository.findById(id).get();
	}
}


