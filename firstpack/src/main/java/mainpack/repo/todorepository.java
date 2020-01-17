package mainpack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mainpack.model.modelclass;
import mainpack.model.todomodelclass;

public interface todorepository extends CrudRepository<todomodelclass,Integer> {

}
