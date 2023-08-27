package com.pratice.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
  private static List<ToDo> toDos = new ArrayList<>();
  private static int toDosCount = 0;

  static {
    toDos.add(
        new ToDo(
            toDosCount++, "Likith", "Learn Spring Boot", LocalDate.now().plusMonths(3), false));
    toDos.add(new ToDo(toDosCount++, "Likith", "Learn AWS", LocalDate.now().plusMonths(3), false));
    toDos.add(
        new ToDo(toDosCount++, "Likith", "Learn Scala", LocalDate.now().plusMonths(3), false));
  }

  public List<ToDo> getToDosByUserName(String userName) {
    return toDos;
  }

  public void addToDo(String username, String description, LocalDate targetDate, boolean isItDone) {
    toDos.add(new ToDo(toDosCount++, username, description, targetDate, isItDone));
  }

  public void deleteToDoById(int id) {
    Predicate<? super ToDo> predicate = todo -> id == todo.getId();
    toDos.removeIf(predicate);
  }

  public ToDo findById(int id) {
    Predicate<? super ToDo> predicate = todo -> id == todo.getId();
    return toDos.stream().filter(predicate).findFirst().orElse(null);
  }

  public  void updateToDo(@Valid ToDo todo){
deleteToDoById(todo.getId());
toDos.add(todo);
  }
}
