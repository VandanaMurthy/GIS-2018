package com.accion.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accion.entity.Event;
import com.accion.entity.Upload;
import com.accion.service.UploadService;

@RestController
@RequestMapping(value = "/app2")
public class UploadController {
	final static Logger logger = Logger.getLogger(UploadController.class);
	
	@Autowired
	private UploadService us;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<Upload> add(@RequestBody Upload upload){
		byte[] encodedBytes = Base64.getEncoder().encode(((String)upload.getUpload()).getBytes());
		upload.setUpload(encodedBytes);
			us.save(upload);
			logger.debug("Uploaded: " + upload);
			return new ResponseEntity<Upload>(upload,HttpStatus.CREATED);		
		}
	
	@PostMapping("/allUploads") // FETCH ALL UPLOADS
	public ResponseEntity<List<Upload>> getAllUploads() {
		List<Upload> uploads = us.findAll();
		if (uploads.isEmpty()) {
			logger.debug("Uploads does not exists");
			return new ResponseEntity<List<Upload>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + uploads.size() + " uploads");
		logger.debug(uploads);
		logger.debug(Arrays.toString(uploads.toArray()));
		return new ResponseEntity<List<Upload>>(uploads, HttpStatus.OK);
	}
	
	public static byte[] loadFileAsBytesArray(String fileName) throws Exception {
		 
        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;
 
    }
	
}
