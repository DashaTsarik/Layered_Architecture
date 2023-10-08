package com.itacademy.java_classes.dao;

import java.util.List;
import com.itacademy.java_classes.entity.Note;

public interface NoteBookDao {
	
	void save(Note n) throws DaoException;

	List<Note> allNotes() throws DaoException;
	
	void update(List<Note> notes) throws DaoException;
	
	Note deleteById(int id) throws DaoException;

}
