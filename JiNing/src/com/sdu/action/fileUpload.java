package com.sdu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;





import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

public class fileUpload extends ActionSupport{
	private static final long serialVersionUID = 1L;    
	private File uploadFile;
	private String uploadFileFileName;
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> datamap= new HashMap<String,Object>();
		System.out.println("uploadFileName="+uploadFileFileName);
		InputStream is = new FileInputStream(uploadFile);
		OutputStream os = new FileOutputStream(new File("D:/temp"+uploadFileFileName));
		byte flush[]  = new byte[1024];  
        int len = 0;  
        while(0<=(len=is.read(flush))){  
            os.write(flush, 0, len);  
        }
        is.close();
        os.close();
        System.out.println("上传成功！");
        //datamap.put("result","success");
        //JSONObject json = JSONObject.fromObject(datamap);
     //   result = json.toString();
   /*     result = null;
        System.out.println("result"+result);
        JSONArray jsonMembers = new JSONArray();
        JSONObject member2 = new JSONObject();  
        member2.put("loginname", "zf");  
        member2.put("password", "userpass");  
        member2.put("email","8223939@qq.com");  
        member2.put("sign_date", "2008-07-16");  
        jsonMembers.put(member2);  
        json.put("users", jsonMembers);  */
        JSONObject obj = new JSONObject();

        obj.put("name", "foo");
        System.out.print(obj.toString());
        result  = obj.toString();
		return SUCCESS;
	}
}

