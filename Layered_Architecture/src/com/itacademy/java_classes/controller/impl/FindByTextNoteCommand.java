package com.itacademy.java_classes.controller.impl;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.java_classes.controller.Command;
import com.itacademy.java_classes.entity.Note;
import com.itacademy.java_classes.logic.LogicException;
import com.itacademy.java_classes.logic.LogicProvider;
import com.itacademy.java_classes.logic.NoteBookLogic;

public class FindByTextNoteCommand implements Command{
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NoteBookLogic logic = logicProvider.getNoteBookLogic();
	
	//FIND_BY_TEXT\nтуманность

	@Override
	public String execute(String request) {
		String response = null;
		List<Note> result = new ArrayList<>();
		String[] params;
		String text;
		
		params = request.split("\n");
		text = params[1];
		try {
			result = logic.find(text);
			
			if (result.size() == 0) {
				response = "Запись не найдена";
			}else {
				response = "Запись найдена";
				for (Note n: result) {
					System.out.println(n);
				}
			}
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		
		return response;
	}
	
	

}
