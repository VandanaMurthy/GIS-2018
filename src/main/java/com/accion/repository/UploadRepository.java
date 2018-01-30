package com.accion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accion.entity.Event;
import com.accion.entity.Upload;


@Repository
public interface UploadRepository extends JpaRepository <Upload, Integer> {
	public List<Upload> findAll();
	public Upload save(Upload upload);
	 
}
