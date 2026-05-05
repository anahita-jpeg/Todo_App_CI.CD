package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repo;

    public TodoServiceImpl(TodoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Todo createTodo(Todo todo) {
        return repo.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    @Override
    public Todo getTodoById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Todo existing = getTodoById(id);
        existing.setTitle(todo.getTitle());
        existing.setCompleted(todo.isCompleted());
        return repo.save(existing);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo existing = getTodoById(id);
        repo.delete(existing);
    }
}