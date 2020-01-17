package mainpack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mainpack.model.modelclass;
import mainpack.model.todomodelclass;
import mainpack.service.serviceclass;

@RestController
public class controllerclass{

	@Autowired
	private serviceclass ts;
	
	@RequestMapping("/listUsers/{userid}/listTodos/{todoid}/listTasks")
	public List<modelclass> getAllTasks(@PathVariable int todoid){
		return  ts.showAllTasks(todoid);
	}
	
@GetMapping("/listUsers/{userid}/listTodos/{todoid}/listTasks/{id}")
	public Optional<modelclass> showtask(@PathVariable int id) {
		return ts.getTask(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/listUsers/{userid}/listTodos/{todoid}/listTasks")
	public void addTask(@RequestBody modelclass td,@PathVariable int todoid) {
		td.setTodomodel(new todomodelclass(todoid,"",0));
		ts.addTask(td);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/listUsers/{userid}/listTodos/{todoid}/listTasks/{id}")
	public void update(@RequestBody modelclass td,@PathVariable int todoid,@PathVariable int id) {
		td.setTodomodel(new todomodelclass(todoid,"",0));
		ts.Updatetask(td);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/listUsers/{userid}/listTodos/{todoid}/listTasks/{id}")
	public void delete(@PathVariable int id) {
		ts.DeleteTask(id);
		
	}

}
