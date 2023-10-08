package com.itacademy.java_classes.start;

import com.itacademy.java_classes.controller.Controller;

public class Main {

	public static void main(String[] args) {
	
        Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ADD\ntitle=Даша\nсоntent=+375(29)678-32-93";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "ADD\ntitle=Маша\nсоntent=+375(44)579-85-00";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "ADD\ntitle=Павел\nсоntent=+375(33)890-51-34";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "ADD\ntitle=Ксюша\nсоntent=+375(29)900-79-70";
		response = controller.doAction(request);
		System.out.println(response);
		
		
		request = "UPDATE\nid=2\ntitle=Дмитрий\ncontent=+375(29)790-51-34\ndate=2023-07-10";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println();
		
		request = "FIND_BY_DATE\n2023-10-03";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println();
		
		request = "ADD\ntitlejhvjhgb";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "FIND_BY_TEXT\n+375";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println();
		
		request = "ALL_NOTES\n";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println();
		
		request = "DELETE\nid=3";
		response = controller.doAction(request);
		System.out.println(response);
		System.out.println();
		
		
		

   }

}
