package com.myclass.admin.controller;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("file")
public class FileController {
	private final String UPLOAD_FOLDER = "resources/upload/";
	private final String UPLOAD_FOLDER_RESULT = "statics/upload/";
	
	@PostMapping("upload")
	@ResponseBody
	public Object upload(@RequestParam MultipartFile file, HttpServletRequest request) {
		
		//Lấy đường dẫn tuyệt đối đến thư mục chứa file upload
		String path = request.getServletContext().getRealPath("/"+ UPLOAD_FOLDER);
		try {
			File dir = new File(path);
			if(!dir.exists()) {
				dir.mkdir();  //Nếu thư mục chưa tồn tại thì tạo mới
			}
			//Lưu file
			File pathFile = new File(path + file.getOriginalFilename());
			file.transferTo(pathFile);
			return UPLOAD_FOLDER_RESULT + file.getOriginalFilename();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
