package net.entrofi.hrm.domain.repository;


import net.entrofi.hrm.domain.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserRepository extends PagingAndSortingRepository<User, String> {

    User findById(String id);

    User findByUsername(String username);
}
