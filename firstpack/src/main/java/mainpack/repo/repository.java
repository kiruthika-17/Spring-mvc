package mainpack.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mainpack.model.modelclass;

public interface repository extends CrudRepository<modelclass,Integer> {

	@Query("from modelclass a where a.taskid=:todomodelclasstodoid")
	public List<modelclass> aaa(@Param("todomodelclasstodoid") int todoid);
}
