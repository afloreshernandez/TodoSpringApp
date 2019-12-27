package com.collabera.todoapp.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.collabera.todoapp.DAO.TodoDAO;

import com.collabera.todoapp.model.Todo;

@Service
@Primary
public class TodoServiceRDBMS implements TodoServiceI{

	@Autowired
	TodoDAO todoDAO;
	
	public List<Todo>listAllTodos(){
		return null;
	}
	// return user specific todos
	public List<Todo> listTodos(String user){	
	
		List<Todo> userTodos = new ArrayList<Todo>();
	
		return userTodos;
	}
	//return todo by id
	public Todo getTodo(int todoId) {
		return null;
		}	
		
	//add a todo to list
	public Todo addTodo(String user, String description, Date targetDate, boolean status){	
		try {
		Todo todo = todoDAO.insertTodo(1,description, user, targetDate, status);
		return todo;
		}
		catch(SQLException e) {
			
		}
		return null;
	}
	 //update a todo in the list
	public Todo editTodo(Todo todo) {
	
		return null;
		
	}
	
	//delete a todo
	public Todo deleteTodo(int todoId) {
	
		
				return null;
		
	}
}
