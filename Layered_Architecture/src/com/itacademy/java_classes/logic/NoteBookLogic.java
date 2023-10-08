package com.itacademy.java_classes.logic;

import java.util.Date;
import java.util.List;

import com.itacademy.java_classes.entity.Note;

public interface NoteBookLogic {
	
	void update(Note n) throws LogicException;
	
	void add(String title, String content) throws LogicException;
	
	Note deleteById(int id) throws LogicException;
	
	List<Note> find(Date date) throws LogicException;
	
	List<Note> allNotes() throws LogicException;
	
	List<Note> find(String text) throws LogicException;
	
	
	
	
	
	

}
