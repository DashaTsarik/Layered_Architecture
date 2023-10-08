package com.itacademy.java_classes.dao.impl;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itacademy.java_classes.dao.DaoException;
import com.itacademy.java_classes.dao.NoteBookDao;
import com.itacademy.java_classes.entity.Note;
import com.itacademy.java_classes.util.GenerateId;

public class FileNoteBookDao implements NoteBookDao{
		
	@Override
	public List<Note> allNotes() throws DaoException {
		SimpleDateFormat format = new SimpleDateFormat();
		BufferedReader reader = null;
		List <Note> allNotes = new ArrayList<>();
		
		//format.applyPattern("EEE MMM dd HH:mm:ss zzz yyyy");
		format.applyPattern("yyyy-MM-dd");
		try {
			reader = new BufferedReader(new FileReader("resources/notes.txt"));
			String line = null;
			Date date;
			int id;
			
			while ((line = reader.readLine()) != null) {
				//System.out.println(line);
				String[] parts = line.split("\t");
				//System.out.println(parts[1]);
				id = Integer.parseInt(parts[0]);
				date = format.parse(parts[1]);
				
				allNotes.add(new Note(id, parts[2], parts[3], date));
			}
		} catch (FileNotFoundException|ParseException e) {
			throw new DaoException(e);
		} catch (IOException e) {
			throw new DaoException(e);
		}finally {
			try {
				if(reader != null) {
					reader.close();
				}
			}catch (IOException e) {
				throw new DaoException(e);
			}
		}
		return allNotes;
	}

	@Override
	public void save(Note n) throws DaoException{
		
		List<Note> notes = allNotes();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		BufferedWriter bufWriter = null;
		
		try {
			bufWriter = new BufferedWriter(new FileWriter("resources/notes.txt",true));

			if(notes.size() > 0) {
				GenerateId.checkLastId(notes);
				n.setId(GenerateId.nextId());
			}
			bufWriter.write(n.getId() + "\t" + format.format(n.getD()) + "\t" + n.getTitle() + "\t" + n.getContent() + "\r\n");
			//bufWriter.write(n.getId() + "\t" + n.gedD() + "\t" + n.getTitle() + "\t" + n.getContent() + "\r\n");
		}catch (IOException e) {
			throw new DaoException(e);
		}finally {
			try {
				if(bufWriter != null) {
					bufWriter.close();
				}
			}catch(IOException e) {
				throw new DaoException(e);
			}
		}
		
	}
	
	public void update(List<Note> updatedNotes) throws DaoException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		BufferedWriter bufWriter = null;
		
		try {
			bufWriter = new BufferedWriter(new FileWriter("resources/notes.txt"));
			
			for(Note n: updatedNotes) {
			bufWriter.write(n.getId() + "\t" + format.format(n.getD()) + "\t" + n.getTitle() + "\t" + n.getContent() + "\r\n");
			}
		}catch (IOException e) {
			throw new DaoException(e);
		}finally {
			try {
				if(bufWriter != null) {
					bufWriter.close();
				}
			}catch(IOException e) {
				throw new DaoException(e);
			}
		}
		
	}
	
	public Note deleteById(int id) throws DaoException{
		List<Note> allNotes = allNotes();
		Note deletedNote = null;
		
		for (int i = 0; i < allNotes.size(); i++) {
			if (id == allNotes.get(i).getId()) {
				deletedNote = allNotes.get(i);
				allNotes.remove(i);
			}
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		BufferedWriter bufWriter = null;
		
		try {
			
			bufWriter = new BufferedWriter(new FileWriter("resources/notes.txt"));
			
			for(Note n: allNotes) {
			bufWriter.write(n.getId() + "\t" + format.format(n.getD()) + "\t" + n.getTitle() + "\t" + n.getContent() + "\r\n");
			}

		}catch (IOException e) {
			throw new DaoException(e);
		}finally {
			try {
				if(bufWriter != null) {
					bufWriter.close();
				}
			}catch(IOException e) {
				throw new DaoException(e);
			}
		}
		return deletedNote;
	}
	
}	

