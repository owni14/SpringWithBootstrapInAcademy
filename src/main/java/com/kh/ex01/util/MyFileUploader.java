package com.kh.ex01.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class MyFileUploader {
	public static String uploadFile(String uploadPath, String originalFilename, byte[] fileData) {
		UUID uuid = UUID.randomUUID();
		String saveFilename = uploadPath + "/" + uuid + "_" + originalFilename;
		System.out.println("saveFilename:" + saveFilename); // 데이터베이스에 저장할 이름
		File fTarget = new File(saveFilename);
		try {
			FileCopyUtils.copy(fileData, fTarget);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveFilename;
	}
}