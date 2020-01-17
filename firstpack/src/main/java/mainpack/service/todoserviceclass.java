package mainpack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import mainpack.model.todomodelclass;

import mainpack.repo.todorepository;

@Service
@Transactional
public class todoserviceclass {

	private final todorepository todorepo;

	public todoserviceclass(todorepository todorepo) {
		this.todorepo=todorepo;
	}
	public void addTodo(todomodelclass todom) {
		todorepo.save(todom);
	}
	
	public List<todomodelclass> showAllTodos() {
		List<todomodelclass> todoss=new ArrayList<>();
		todorepo.findAll().forEach(todoss::add);
		return todoss;
	}
	public void DeleteTodo(int id) {
		todorepo.deleteById(id);
		
	}
	public void Updatetodo(todomodelclass td,int id) {
		todorepo.save(td);
		
	}
	public Optional<todomodelclass> getTodo(int id) {
		
		return todorepo.findById(id);
	}
	
	

	

}
