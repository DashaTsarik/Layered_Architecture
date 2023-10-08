package com.itacademy.java_classes.controller.impl;

import com.itacademy.java_classes.controller.Command;
import com.itacademy.java_classes.logic.LogicException;
import com.itacademy.java_classes.logic.LogicProvider;
import com.itacademy.java_classes.logic.NoteBookLogic;

public class AddNoteCommand implements Command{
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NoteBookLogic logic = logicProvider.getNoteBookLogic();
	//ADD\ntitle=Книга\nсоntent=Туманность Андромеды
	
	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		String title;
		String content;

		// validate request
		params = request.split("\n");
		title = params[1].split("=")[1];
		content = params[2].split("=")[1];

		try {
			logic.add(title,content);
			response = "Запись сохранена успешно.";
		} catch (LogicException e) {
			response = "Сообщение сохранить не удалось. Попробуйте еще раз.";
		}
		
		return response;
	}

}
