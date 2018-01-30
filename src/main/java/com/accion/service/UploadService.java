package com.accion.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accion.entity.Upload;
import com.accion.repository.UploadRepository;

@Service
public class UploadService {
	@Autowired
	private UploadRepository uploadResp;
	
	public List<Upload> findAll(){
		return uploadResp.findAll();
	}
	
	 public Upload save(Upload upload){
		 return uploadResp.save(upload);
	 }

}
