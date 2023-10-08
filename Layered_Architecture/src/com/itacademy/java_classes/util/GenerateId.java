package com.itacademy.java_classes.util;

import java.util.List;

import com.itacademy.java_classes.entity.Note;

public final class GenerateId {
	
    private GenerateId() {}
	
	private static int nextId = 1;
	
	public static int nextId() {
		return nextId++;
	}
	
	public static void checkLastId(List<Note> notes) {
		if(notes.size() > 0) {
			int size = notes.size();
			int id = notes.get(size - 1).getId();
			nextId = id+1;
		}
		
	}

}
