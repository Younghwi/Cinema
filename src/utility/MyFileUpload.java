package utility;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MyFileUpload {
	public static MultipartRequest getMultiPartRequest( HttpServletRequest request, String uploadedPath  ){
		//���� ���ε带 ���� MultipartRequest ��ü�� �����ִ� static �޼ҵ��̴�.
		
		String encType = "UTF-8"; //���ڿ� ���ڵ�
		int sizeLimit = 20 * 1024 * 1024; //���ε� ��� �ִ� ������ 20MB
		MultipartRequest multi = null ; //���� ���ε� ��ü
		
		try {
			multi = new MultipartRequest(request, uploadedPath, sizeLimit,
					encType, new DefaultFileRenamePolicy());
			
			/*String imagesPath = request.getContextPath() + "/images/" ; 
			
			File file = new File(uploadedPath);

			String pathname = imagesPath + file.getName();
			file.renameTo(new File(pathname));*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return multi ;
	}
}
