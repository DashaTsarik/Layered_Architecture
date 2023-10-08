package com.itacademy.java_classes.logic.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itacademy.java_classes.dao.DaoException;
import com.itacademy.java_classes.dao.DaoProvider;
import com.itacademy.java_classes.dao.NoteBookDao;
import com.itacademy.java_classes.entity.Note;
import com.itacademy.java_classes.logic.LogicException;
import com.itacademy.java_classes.logic.NoteBookLogic;

public class NoteBookLogicImpl implements NoteBookLogic{
	
	private final DaoProvider provider = DaoProvider.getInstance();
	private final NoteBookDao dao = provider.getNoteBookDao();
	
	public void update(Note n) throws LogicException {		
		List<Note> allNotes;
		try {
			allNotes = dao.allNotes();
			
			for(Note note: allNotes) {
				if (note.getId() == n.getId()) {
					note.setTitle(n.getTitle());
					note.setContent(n.getContent());
					note.setD(n.getD());
					System.out.println(n);
				}
			}
			dao.update(allNotes);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
	}
	
	public void add(String title, String content) throws LogicException{

		Note n = new Note(title, content);
		
		try {
			dao.save(n);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
	}
	
	public Note deleteById(int id) throws LogicException {
		Note deletedNote;
		try {
			deletedNote = dao.deleteById(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		return deletedNote;
	}
	
	public List<Note> find(String text) throws LogicException{
		List<Note> result = new ArrayList<Note>();
		
		List<Note> myNotes;
		try {
			myNotes = dao.allNotes();
			
			for(Note n : myNotes) {
				if(isTextInNote(n, text)) {
					result.add(n);
				}
			}
			return result;
			
		} catch (DaoException e) {
			throw new LogicException(e);
		}

	}
	
	private boolean isTextInNote(Note n, String text){
		return n.getTitle().contains(text) || n.getContent().contains(text);
	}
	
	
	public List<Note> find(Date date) throws LogicException{
		List<Note> result = new ArrayList<Note>();
		
		List<Note> myNotes;
		try {
			myNotes = dao.allNotes();
			
			for (int i = 0; i < myNotes.size(); i++) {
				
				if(myNotes.get(i).getD().getDate() == date.getDate() 
			      && myNotes.get(i).getD().getMonth() == date.getMonth()
				   && myNotes.get(i).getD().getYear() == date.getYear()) {
							
					result.add(myNotes.get(i));
				}
			}
			return result;
			
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
	}

	public List<Note> allNotes() throws LogicException{
		try {
			return dao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

}
