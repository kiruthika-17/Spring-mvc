package com.userpackage.main;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<usermodelclass, Integer> {

	public usermodelclass findByUsernameAndPassword(String username,String password);

}
