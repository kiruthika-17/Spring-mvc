package mainpack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mainpack.model.todomodelclass;
import mainpack.model.user;
import mainpack.service.todoserviceclass;

@RestController
public class todocontroller{

	@Autowired
	private todoserviceclass todoserv;
	
	@GetMapping("/listUsers/{userid}/listTodos")
	public List<todomodelclass> showAllTasks(){
		return todoserv.showAllTodos();
}
	@GetMapping("/listUsers/{userid}/listTodos/{todoid}")
	public Optional<todomodelclass> showtask(@PathVariable int todoid) {
		return todoserv.getTodo(todoid);
	}
	@RequestMapping(method=RequestMethod.POST,value="/listUsers/{userid}/listTodos")
	public void addTodo(@RequestBody todomodelclass todomodel,@PathVariable int userid) {
		todomodel.setU(new user(userid));
		todoserv.addTodo(todomodel);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/listUsers/{userid}/listTodos/{todoid}")
	public void update(@RequestBody todomodelclass todomodel,@PathVariable int todoid,@PathVariable int userid) {
		todomodel.setU(new user(userid));
		todoserv.Updatetodo(todomodel,todoid);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/listUsers/{userid}/listTodos/{id}")
	public void delete(@PathVariable int id) {
		todoserv.DeleteTodo(id);
		
	}

}
