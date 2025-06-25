package kr.co.sist.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileUploadDTO2 {

	private String uploader;
	private String[] targetAge;
	private String[] fileName;
}
