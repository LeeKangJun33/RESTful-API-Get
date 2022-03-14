package com.example.MySpringApp.ToDoItem;

import java.util.List;


public class ToDoItemAdapter {

	public static ToDoItemResponse toToDoItemResponse(final ToDoItem toDoItem, final List<String> errors) {
        return ToDoItemResponse.builder().toDoItem(toDoItem).errors(errors).build();
    }
}
