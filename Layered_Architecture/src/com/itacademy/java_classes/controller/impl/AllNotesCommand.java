package com.itacademy.java_classes.controller.impl;

import java.util.ArrayList;
import java.util.List;

import com.itacademy.java_classes.controller.Command;
import com.itacademy.java_classes.entity.Note;
import com.itacademy.java_classes.logic.LogicException;
import com.itacademy.java_classes.logic.LogicProvider;
import com.itacademy.java_classes.logic.NoteBookLogic;

public class AllNotesCommand implements Command{
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NoteBookLogic logic = logicProvider.getNoteBookLogic();
	
	@Override
	public String execute(String request) {
		String response = null;
		List<Note> allNotes = new ArrayList<>();
		
		try {
			allNotes = logic.allNotes();
			
			if(allNotes.size() == 0) {
				response = "Записи не найдены.";
			} else {
				response = "Все записи из записной книжки.";
				for (Note n: allNotes) {
					System.out.println(n);
				}
			}
		} catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		
		
		return response;
	}
	
	

}
