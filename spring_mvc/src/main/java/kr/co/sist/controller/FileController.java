package kr.co.sist.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/day0624")
public class FileController {
	
	@Value("${upload.saveDir}")
	private String saveDir;

	@GetMapping("/upload_form")
	public String uploadForm() {
		return "day0624/upload_form";
	}
	
	@PostMapping("/upload_process")
	public String uploadProcess(@RequestParam("upfile") MultipartFile mf, FileUploadDTO fuDTO, Model model)
	throws Exception {
		
//		System.out.println("MINE-TYPES: "+mf.getContentType());
//		System.out.println("form control: "+mf.getName());
//		System.out.println("파일명 : "+mf.getOriginalFilename());
//		System.out.println("파일이 비었는지 :"+mf.isEmpty());
//		//파일명은 DTO에 설정되지 않으므로 setter를 호출하여 설정한다.
//		System.out.println("업로더 :"  + fuDTO.getUploader());
//		System.out.println("대상나이 :" + Arrays.toString(fuDTO.getTargetAge()));
//		System.out.println("파일명 :" + fuDTO.getFileName());

		fuDTO.setFileName(mf.getOriginalFilename());
		
		//이미지만 업로드(설정은 10MByte, 업로드 가능 5MByte
		if(mf.getContentType().startsWith("image")) {
			int maxSize = 1024 * 1024 * 5;
			
			if(mf.getSize() > maxSize) {
				throw new Exception("업로드 파일의 크기는 최대 5MByte까지만 가능합니다.");
			}
			
			//중복파일명 처리(동일 파일명이 존재한다면 파일명_숫자.확장자를 붙여 새로 생성)
			//1.업로드된 파일명 받기
			String originalFielname = mf.getOriginalFilename();
			//디렉토리가 존재하지 않으면 디렉토리를 생성
			File dir = new File(saveDir);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			//2.파일명으로 파일을 생성
			File uploadFile = new File(saveDir + File.separator + originalFielname);
			
			//3.확장자를 기준으로 파일명을 나눈다.
			String fileName = "";
			String fileExt = "";
			
			int fileSeperator = originalFielname.lastIndexOf(".");
			if(fileSeperator == -1) { //확장자가 없다면
				fileSeperator = originalFielname.length();
			}
			
			fileName = originalFielname.substring(0, fileSeperator);
			if(originalFielname.contains(".")) { //확장자가 있다면
				fileExt = originalFielname.substring(fileSeperator+1);
			}
			
			//4. 같은 이름의 파일이 존재하면 파일명과 .사이에 _1(카운트)를 추가한다.
			int cnt = 1;
			StringBuilder newFileName = new StringBuilder();
			while(uploadFile.exists()) { //같은 이름의 파일이 존재하면
				newFileName.append(fileName).append("_").append(cnt).append(".").append(fileExt);
				uploadFile = new File(saveDir + File.separator + newFileName.toString());
				cnt++;
				newFileName.delete(0, newFileName.length());
			}
			
			
			//5.업로드 수행
			mf.transferTo(uploadFile); //중복파일을 처리하지 않는다.(덮어쓴다)
			model.addAttribute("uploadFlag", true);
			model.addAttribute("fileSize", mf.getSize());
			model.addAttribute("fileData", fuDTO);
		}
		
		return "day0624/upload_result";
	}
	
	@ExceptionHandler(Exception.class)
	//spring.servlet.multipart.max-file-size=10MB 설정된 파일크기보다 업로드된 파일의
	//크기가 크다면 해당 예외는 처리할 수 없다.
	public ModelAndView uploadErr(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/err/upload_err.html");
		e.printStackTrace();
		return mav;
	}
}
