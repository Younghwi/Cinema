package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SuperController {
	public static final String CommandName = "/CinemaCtrl" ; 
	
	//��� ����Ͻ� ������ �����ϱ� ���� �߻� �޼ҵ带 �����Ѵ�.
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
