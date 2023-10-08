package com.itacademy.java_classes.controller;

import java.util.HashMap;
import java.util.Map;

import com.itacademy.java_classes.controller.impl.AddNoteCommand;
import com.itacademy.java_classes.controller.impl.AllNotesCommand;
import com.itacademy.java_classes.controller.impl.DeleteNoteCommand;
import com.itacademy.java_classes.controller.impl.FindByDateNoteCommand;
import com.itacademy.java_classes.controller.impl.FindByTextNoteCommand;
import com.itacademy.java_classes.controller.impl.NoSuchCommand;
import com.itacademy.java_classes.controller.impl.UpdateNoteCommand;

public class CommandProvider {
	
private final Map<CommandName, Command> repository = new HashMap<>();
	
	CommandProvider(){
		repository.put(CommandName.ADD, new AddNoteCommand());
		repository.put(CommandName.UPDATE, new UpdateNoteCommand());
		repository.put(CommandName.DELETE, new DeleteNoteCommand());
		repository.put(CommandName.FIND_BY_DATE, new FindByDateNoteCommand());
		repository.put(CommandName.FIND_BY_TEXT, new FindByTextNoteCommand());
		repository.put(CommandName.ALL_NOTES, new AllNotesCommand());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}
	
	Command getCommand(String name){
		CommandName commandName =null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		}catch(IllegalArgumentException | NullPointerException e){
			//write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}				
		return command;
	}

}
	    
