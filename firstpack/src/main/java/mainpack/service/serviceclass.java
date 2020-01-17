package mainpack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mainpack.model.modelclass;
import mainpack.model.todomodelclass;
import mainpack.repo.repository;

@Service
@Transactional
public class serviceclass {

	private final repository tr;

	public serviceclass(repository tr) {
		this.tr=tr;
	}
	public void addTask(modelclass td) {
	tr.save(td);
	}
	
	public List<modelclass> showAllTasks(int todoid) {
		List<modelclass> todos=new ArrayList<>();
		tr.findAll().forEach(todos::add);
		return todos;
	}
	public void DeleteTask(int id) {
		tr.deleteById(id);
		
	}

	public Optional<modelclass> getTask(int id) {
		
		return tr.findById(id);
	}
	public void Updatetask(modelclass td) {
	tr.save(td);
		
	}
	
	

	

}