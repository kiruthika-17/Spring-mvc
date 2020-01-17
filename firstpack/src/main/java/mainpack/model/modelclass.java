package mainpack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="FirstTable")
public class modelclass {
	
	@Id
	private int taskid;
	private String name;
	private String description;
	@ManyToOne
	private todomodelclass todomodel;
	
	public modelclass(int taskid, String name, String description, int todoid) {
		super();
		this.taskid = taskid;
		this.name = name;
		this.description = description;
		this.todomodel=new todomodelclass(todoid,"",0);
		
	}

}