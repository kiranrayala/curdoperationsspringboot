package com.kiran.firstproject.CurdOperations;

import org.springframework.stereotype.Service;

import com.kiran.firstproject.CurdOperations.model.Todo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

	@Override
	public List<Todo> getTodos() {
		// TODO Auto-generated method stub
		 List<Todo> todos = new ArrayList<>();
	        todoRepository.findAll().forEach(todos::add);
	        return todos;
	}

	@Override
	public Todo getTodoById(Long id) {
		// TODO Auto-generated method stub
        return todoRepository.findById(id).get();
	}

	@Override
	public Todo insert(Todo todo) {
		// TODO Auto-generated method stub
        return todoRepository.save(todo);
	}

	@Override
	public void updateTodo(Long id, Todo todo) {
		// TODO Auto-generated method stub
//		Todo todoFromDb = todoRepository.findById(id).get();
//        System.out.println(todoFromDb.toString());
//        todoFromDb.setTodoStatus(todo.getTodoStatus());
//        todoFromDb.setDescription(todo.getDescription());
//        todoFromDb.setTitle(todo.getTitle());
        //todoRepository.save(todoFromDb);
		
	}

	@Override
	public void deleteTodo(Long todoId) {
		// TODO Auto-generated method stub
		todoRepository.deleteById(todoId);
		
	}

  
}
