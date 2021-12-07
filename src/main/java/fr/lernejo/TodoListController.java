package fr.lernejo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoListController {

    private List<Todo> todoList = new ArrayList<>();


    @PostMapping("/api/todo")
    public void AddTodo(@RequestBody Todo todo){

        this.todoList.add(todo);
    }

    @GetMapping("/api/todo")
    public List<Todo> GetTodo(){

        return this.todoList;
    }
}
