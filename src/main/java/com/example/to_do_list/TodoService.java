package com.example.to_do_list;


import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(Long id) {return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found with the id " + id)); }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
