package mainpack.repo;

import org.springframework.data.repository.CrudRepository;

import mainpack.model.user;

public interface userrepo extends CrudRepository<user,Integer> {

}
