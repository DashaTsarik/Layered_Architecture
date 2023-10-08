package com.itacademy.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itacademy.java_classes.controller.Command;
import com.itacademy.java_classes.entity.Note;
import com.itacademy.java_classes.logic.LogicException;
import com.itacademy.java_classes.logic.LogicProvider;
import com.itacademy.java_classes.logic.NoteBookLogic;

public class FindByDateNoteCommand implements Command{
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NoteBookLogic logic = logicProvider.getNoteBookLogic();
	
	//FIND_BY_DATE\n2023-09-19

	@Override
	public String execute(String request) {
		String response = null;
		List<Note> notes = new ArrayList<>();
		String[] params;
		
		params = request.split("\n");
		
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(params[1]);
			notes = logic.find(date);
			if(notes.size() == 0) {
				response = "Запись не найдена";
			}else {
				response = "Запись найдена";
				for(Note n: notes) {
					System.out.println(n);
				}
			}
		} catch (ParseException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
			
		}catch (LogicException e) {
			response = "Что-то пошло не так. Попробуйте еще раз.";
		}
		
		
		return response;
	}

}
