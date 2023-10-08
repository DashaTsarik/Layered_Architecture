package com.itacademy.java_classes.logic;

import com.itacademy.java_classes.logic.impl.NoteBookLogicImpl;

public final class LogicProvider {
	
	private static final LogicProvider INSTANCE = new LogicProvider();
	
	private LogicProvider() {}

	private NoteBookLogic noteBookLogic = new NoteBookLogicImpl();
	
	public NoteBookLogic getNoteBookLogic() {
		return noteBookLogic;
	}
	
	public static LogicProvider getInstance() {
		return INSTANCE;
	}
	
}
