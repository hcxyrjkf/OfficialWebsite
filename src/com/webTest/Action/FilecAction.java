package com.webTest.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import net.sf.json.JSONArray;
import net.sf.json.JSONString;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import com.webTest.Bean.Category;
import com.webTest.Bean.Filec;
import com.webTest.Dao.FilecDao;
import com.webTest.Service.CategoryService;
import com.webTest.Service.FilecService;
import com.webTest.tools.DeCompressUtil;
import com.webTest.tools.FileType;
import com.webTest.tools.ReadFile;
import com.webTest.tools.UnZipper;

@Controller("filecAction")
public class FilecAction extends ActionSupport {
	private File file;
	// �ļ�����
	private String fileFileName;
	// �ļ�����
	private String fileContentType;
	// ע�⣺�ļ����ƺ��ļ����͵�����ǰ׺������ͬ�� 
	private String path;
	private int categoryId;
	@Autowired
	private FilecDao filecDao;
	@Autowired
	private FilecService filecService;
	private Filec filec;
	private int id;// Filec id
	private String fileTitle;
	private String fileContent;
	String many_id;
	
	public String getMany_id() {
		return many_id;
	}

	public void setMany_id(String many_id) {
		this.many_id = many_id;
	}

	public int getId() {
		return id;
	}

	String fileName;

	public void setId(int id) {
		this.id = id;
	}
	@Autowired
	private Category category;
	@Autowired
	private CategoryService categoryService;

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Filec getFilec() {
		return filec;
	}

	public void setFilec(Filec filec) {
		this.filec = filec;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public FilecDao getFilecDao() {
		return filecDao;
	}

	public void setFilecDao(FilecDao filecDao) {
		this.filecDao = filecDao;
	}

	public FilecService getFilecService() {
		return filecService;
	}

	public void setFilecService(FilecService filecService) {
		this.filecService = filecService;
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

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		// ����ֵ
		List categoryList = categoryService.getCategoryList();
		ServletActionContext.getRequest().setAttribute("categoryList",
				categoryList);
		// ��ȡֵ
		categoryId = Integer.parseInt(request.getParameter("categoryId"));
		filecService.get(categoryId);

//		String fileContent = fileContentType.split("[/]")[1];

//			File uploadFile = new File(ServletActionContext.getServletContext()
//					.getRealPath("/"));
			DeCompressUtil deCompressUtil = new DeCompressUtil();
			ReadFile readFile = new ReadFile();
			ServletContext sc = ServletActionContext.getServletContext();
			String filesource = sc.getRealPath("/");
//			// �ж��ļ��Ƿ��ϴ�������ϴ��Ļ����ᴴ����Ŀ¼
//			if (!uploadFile.exists()) {
//				uploadFile.mkdir(); // ������Ŀ¼
//			}
			//System.err.println(filesource);
			File file1 = new File(filesource, fileFileName);
			try {
				FileUtils.copyFile(file, file1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			
			}
			file.delete();//ɾ��cache
//			
//			// �����ļ���������Ϊ������ָ���ļ�·��
//			FileInputStream input = new FileInputStream(file);
//			// ��ȡ���������ȡ�ļ����ļ���ַ������
//			FileOutputStream out = new FileOutputStream(uploadFile + "\\"
//					+ fileFileName);
//			try {
//				byte[] b = new byte[1024];// ÿ��д��Ĵ�С  
//				int i = 0;
//				while ((i = input.read(b)) > 0) {
//					out.write(b, 0, i);
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//			    
//				input.close();
//				out.close();
//			}
			//��ѹ  �����н�ѹ��ַ 
			filesource = filesource + fileFileName;
			
			deCompressUtil.deCompress(filesource, ServletActionContext.getServletContext().getRealPath("/"));
			//��ȡ  �����滹�н�ȡ�ַ����Ĵ����Ҵ����Լ�����
			for (int i = 0; i < readFile.readFile(ServletActionContext.getServletContext().getRealPath("/")+fileFileName.split("[.]")[0]).size(); i++) {
			    	//1ͨ������ ȡ���ݲ������������ 
					
					//�ж�  ���� update   ���ڴ�����  
					path = readFile.readFile(ServletActionContext.getServletContext().getRealPath("/")+fileFileName.split("[.]")[0]).get(i).toString();
					System.err.println(path);
					//fileName = readFile.readfile(filesource).getName()
					//fileName = path.split("[/]")[path.split("[/]").length-1];
					fileName = path.substring(path.lastIndexOf(File.separator)+1);
					System.err.println(fileName);
					fileContentType = fileName.split("[.]")[1]; 
					int index = path.indexOf(fileFileName.split("[.]")[0]);
					String newpath = fileFileName.split("[.]")[0]+path.substring(index+fileFileName.split("[.]")[0].length());
					newpath.replaceAll("\\\\", "/");
//					System.out.println(p.getProperty(fileName));
					//System.err.println(newpath);
					if (fileContentType.equals("html")) {
						fileTitle = request.getParameter("fileTitle");
						fileContent = request.getParameter("fileContent");
					}
//					if (filec.getFileFileName().equals(fileName)) {
//						filecService.update(filec);
//					}
					filec = new Filec(id, fileName, fileContentType, newpath,fileTitle,fileContent,categoryId + "");
					filecService.add(filec);
					//��ѹ֮��Ҫ��̬����ѽ
			      }
		return "success";
	}

	// ��ȡ�����б������
	public void categoryList() {
		// ��ȡҳ���Ӧ
		HttpServletResponse response = ServletActionContext.getResponse();
		// ����
		response.setCharacterEncoding("utf-8");
		List<Category> list = categoryService.getCategoryList();
		// ת����json��ʽ
		JSONArray json = JSONArray.fromObject(list);
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void filecList() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		List<Filec> list = filecService.getFilecList();
		JSONArray json = JSONArray.fromObject(list);
		//System.out.println(json);
		try {
			response.getWriter().print(json.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void filecWebList(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");  
		List<Filec> list = filecService.getFilecList();
		System.err.println(list);
//		PrintWriter out = null;  
		List<Filec> newList = new ArrayList<>();
		int j=1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFileContentType().equals("html")) {
				list.get(i).setId(j);
				newList.add(list.get(i));
				j++;
			}
		}
		System.err.println(newList);
		JSONArray json = JSONArray.fromObject(newList);
		
		try {
//			out = response.getWriter();
//			out.append(json.toString(0));
//			for (int i = 0; i < json.size(); i++) {
//				Map<Integer, String> map = new HashMap<Integer,String>();
//				map.put(i, json.toString());
//				System.err.println(json.toString());
//				
//			}
//			for (int i = 0; i < json.size(); i++) {
//				String 
//			}
			System.err.println(json.toString());
			response.getWriter().write(json.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public String filecDelete() {
		Filec filec = filecService.get(id);
		filecService.delete(id);
		File file = new File(filec.getPath());
		if (file.exists()) {
			file.delete();
		}
		return "success";
	}
	public String filecDeleteSeveral(){
		
		String[] arry=many_id.split(",");
		
		for (int i = 0; i < arry.length; i++) {
			Filec filec=filecService.get(Integer.parseInt(arry[i]));
			filecService.delete(filec.getId());
			File file = new File(filec.getPath());
			if (file.exists()) {
				file.delete();
			}
		}
		//filecService.delete(id);
		return "success";
	}

	public String filecUpdate() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		// ����ֵ
		List categoryList = categoryService.getCategoryList();
		ServletActionContext.getRequest().setAttribute("categoryList",
				categoryList);
		// ��ȡֵ
		categoryId = Integer.parseInt(request.getParameter("categoryId"));
		filecService.get(categoryId);
//		DeCompressUtil deCompressUtil = new DeCompressUtil();
//		ReadFile readFile = new ReadFile();
//		ServletContext sc = ServletActionContext.getServletContext();
//		String filesource = sc.getRealPath("/");
//		File file1 = new File(filesource, fileFileName);
//		try {
//			FileUtils.copyFile(file, file1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();			
//		}
//		file.delete();
		// ��ȡ��Ҫ�ϴ��ļ����ļ�·��
		File uploadFile = new File(ServletActionContext.getServletContext()
				.getRealPath("/"));
		// �ж��ļ��Ƿ��ϴ�������ϴ��Ļ����ᴴ����Ŀ¼
		String fileContent = fileContentType.split("[/]")[1];
		if (FileType.isLegal(fileContent)) {
		if (!uploadFile.exists()) {
			uploadFile.mkdir(); // ������Ŀ¼
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddhhmmss");
		fileName = fileFileName.split("[.]")[0] + "-"
				+ simpleDateFormat.format(new Date()) + "."
				+ fileFileName.split("[.]")[1];
		// �����ļ���������Ϊ������ָ���ļ�·��
		FileInputStream input = new FileInputStream(file);
		// ��ȡ���������ȡ�ļ����ļ���ַ������
		FileOutputStream out = new FileOutputStream(uploadFile + "\\"
				+ fileName);
		path = ServletActionContext.getServletContext().getRealPath("/")
				+ fileName;
		
		Filec filec = new Filec(id, fileName, fileContentType, path,fileTitle,fileContent, categoryId
				+ "");
		Filec filec1 = filecService.get(filec.getId());
		File file = new File(filec1.getPath());
		if (file.exists()) {
			file.delete();
		}
		filecService.update(filec);
		try {
			byte[] b = new byte[1024];// ÿ��д��Ĵ�С
			int i = 0;
			while ((i = input.read(b)) > 0) {
				out.write(b, 0, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
			out.close();
		}
		}
		return "success";
	}
	public void findone() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		filec = filecService.get(id);
		System.err.println(filec);
		JSONArray json = JSONArray.fromObject(filec);
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  String  upload(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext sc = ServletActionContext.getServletContext();
		String path = sc.getRealPath("/");
		File file1 = new File(path, fileFileName);
		try {
			FileUtils.copyFile(file, file1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		file.delete();//ɾ��cache
		return "success";
	}
}
