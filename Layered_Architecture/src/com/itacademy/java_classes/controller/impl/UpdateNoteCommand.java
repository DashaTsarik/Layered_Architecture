package com.itacademy.java_classes.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itacademy.java_classes.controller.Command;
import com.itacademy.java_classes.entity.Note;
import com.itacademy.java_classes.logic.LogicException;
import com.itacademy.java_classes.logic.LogicProvider;
import com.itacademy.java_classes.logic.NoteBookLogic;

public class UpdateNoteCommand implements Command{
	
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NoteBookLogic logic = logicProvider.getNoteBookLogic();
	//UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=2023-08-08
	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Note newNote;

		// validate request
		params = request.split("\n");
		newNote = new Note();

		newNote.setId(Integer.parseInt(params[1].split("=")[1]));
		newNote.setTitle(params[2].split("=")[1]);
		newNote.setContent(params[3].split("=")[1]);

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		Date date;
		try {
			date = format.parse(params[4].split("=")[1]);
			newNote.setD(date);

			logic.update(newNote);
			response = "Запись обновлена успешно.";
		} catch (ParseException e) {
			response = "Запись не обновлена.";
		} catch (LogicException e) {
			response = "Запись не обновлена. Что-то пошло не так. Попробуйте еще раз.";
		}
		
		return response;
	}

}
