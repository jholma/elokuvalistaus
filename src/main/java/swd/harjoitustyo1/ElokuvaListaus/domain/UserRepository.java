package swd.harjoitustyo1.ElokuvaListaus.domain;

import org.springframework.data.repository.CrudRepository;

import swd.harjoitustyo1.ElokuvaListaus.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
