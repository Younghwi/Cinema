package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SuperController {
	public static final String CommandName = "/CinemaCtrl" ; 
	
	//모든 비즈니스 로직을 수행하기 위한 추상 메소드를 정의한다.
	public void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
