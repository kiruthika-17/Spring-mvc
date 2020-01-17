package mainpack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@Table(name="TodoTable")
public class todomodelclass {
	
	@Id
 private int todoid;
 private String name;
 @ManyToOne
 private user u;
 
 public todomodelclass() {
		super();
		// TODO Auto-generated constructor stub
	}

public todomodelclass(int todoid, String name, int userid) {
	super();
	this.todoid = todoid;
	this.name = name;
	this.u=new user(userid);
}
 
}
