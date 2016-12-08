package net.entrofi.hrm.domain.repository;


import net.entrofi.hrm.domain.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {

    User findById(String id);

    User findByUsername(String username);
}
