package net.entrofi.hrm.domain.repository;

import net.entrofi.hrm.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 08 Mar 2015
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
