package com.collabera.todoapp.services;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;
import com.collabera.todoapp.model.Todo;

@Service
public interface TodoServiceI {

	
	public List<Todo>listAllTodos();
		
	
	// return user specific todos
	public List<Todo> listTodos(String user);
	
		
	
	//return todo by id
	public Todo getTodo(int todoId); 
		
	//add a todo to list
	public Todo addTodo(String user, String description, Date targetDate, boolean status) throws SQLException;
		
	
	 //update a todo in the list
	public Todo editTodo(Todo todo); 
		
		
	
	
	//delete a todo
	public Todo deleteTodo(int todoId); 
		
		
	
}
