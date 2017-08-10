package com.webTest.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="filetable")
@Component("filec")
public class Filec {
	private int id;
	private String fileFileName;
	private String fileContentType;
	private String path;
	private String fileTitle;
	private String fileContent;
	private String categoryId;
	@Id  
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	public Filec(int id, String fileFileName, String fileContentType,
			String path, String fileTitle, String fileContent, String categoryId) {
		super();
		this.id = id;
		this.fileFileName = fileFileName;
		this.fileContentType = fileContentType;
		this.path = path;
		this.fileTitle = fileTitle;
		this.fileContent = fileContent;
		this.categoryId = categoryId;
	}
	public Filec() {
		super();
	}
	
	public Filec(String fileFileName, String fileContentType, String path,
			String fileTitle, String fileContent, String categoryId) {
		super();
		this.fileFileName = fileFileName;
		this.fileContentType = fileContentType;
		this.path = path;
		this.fileTitle = fileTitle;
		this.fileContent = fileContent;
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Filec [id=" + id + ", fileFileName=" + fileFileName
				+ ", fileContentType=" + fileContentType + ", path=" + path
				+ ", fileTitle=" + fileTitle + ", fileContent=" + fileContent
				+ ", categoryId=" + categoryId + "]";
	}
	
	

}
