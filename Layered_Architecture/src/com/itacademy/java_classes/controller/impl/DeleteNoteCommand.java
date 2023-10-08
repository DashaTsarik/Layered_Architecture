package com.itacademy.java_classes.controller.impl;

import com.itacademy.java_classes.controller.Command;
import com.itacademy.java_classes.entity.Note;
import com.itacademy.java_classes.logic.LogicException;
import com.itacademy.java_classes.logic.LogicProvider;
import com.itacademy.java_classes.logic.NoteBookLogic;

public class DeleteNoteCommand implements Command{
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NoteBookLogic logic = logicProvider.getNoteBookLogic();
	
	//DELETE\nid=2
	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		int id;
		Note n;
		
		params = request.split("\n");
		id = Integer.parseInt(params[1].split("=")[1]);
		try {
			n = logic.deleteById(id);
			if (n == null) {
				response = "Запись с таким номером не найдена.";
			}else {
			response = "Запись успешно удалена.";
			}
		} catch (LogicException e) {
			response = "Запись не удалена. Что-то пошло не так. Попробуйте еще раз.";
		}
	
		return response;
	}

}
