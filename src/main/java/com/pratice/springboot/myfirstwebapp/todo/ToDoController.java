package com.pratice.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {
  public ToDoController(ToDoService toDoService) {
    this.toDoService = toDoService;
  }

  private final ToDoService toDoService;

  @RequestMapping("list-todos")
  public String listAllToDos(ModelMap model) {
    List<ToDo> listOfTodos = toDoService.getToDosByUserName("Likith");
    model.put("ToDos", listOfTodos);
    return "listToDos";
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.GET)
  public String showNewToDoPage(ModelMap model) {
    ToDo todo = new ToDo(0, model.get("name").toString(), "", LocalDate.now().plusYears(1), false);
    model.put("todo", todo);
    return "todo";
  }

  @RequestMapping(value = "add-todo", method = RequestMethod.POST)
  public String AddNewToDoPage(
      ModelMap model, @ModelAttribute("todo") @Valid ToDo todo, BindingResult result) {
    if (result.hasErrors()) {
      return "todo";
    }
    toDoService.addToDo(
        model.get("name").toString(), todo.getDescription(), LocalDate.now().plusYears(1), false);
    return "redirect:list-todos";
  }

  @RequestMapping("delete-todo")
  public String deleteToDo(ModelMap model, @RequestParam("id") int id) {
toDoService.deleteToDoById(id);
    return "redirect:list-todos";
  }
}
