package com.example.Tudo.service;

import com.example.Tudo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {

    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Todo> findAll() {
        return todos;
    }

    public Optional<Todo> findById(Long id) {
        return todos.stream().filter(todo -> todo.getId().equals(id)).findFirst();
    }

    // Create a new todo
    public Todo save(Todo todo) {
        todo.setId(counter.incrementAndGet());
        todos.add(todo);
        return todo;
    }


    public Optional<Todo> update(Long id, Todo todoDetails) {
        return findById(id).map(todo -> {
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());
            return todo;
        });
    }

    public boolean deleteById(Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }
}