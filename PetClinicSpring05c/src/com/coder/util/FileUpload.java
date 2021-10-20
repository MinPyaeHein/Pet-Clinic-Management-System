package com.coder.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	public static void uploadFile(MultipartFile multipartFile, String url) {
		 File file = new File(url);
         try
         {
             multipartFile.transferTo(file);
         } catch (IOException e) 
         {
             e.printStackTrace();
         }
		
	}
	
	

}
