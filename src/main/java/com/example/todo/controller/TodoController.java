package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return service.getTodoById(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return service.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
        return "Todo deleted successfully";
    }
}