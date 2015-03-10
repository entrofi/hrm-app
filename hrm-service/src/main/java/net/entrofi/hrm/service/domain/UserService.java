package net.entrofi.hrm.service.domain;

import net.entrofi.hrm.domain.entity.User;
import net.entrofi.hrm.domain.repository.UserRepository;
import net.entrofi.hrm.service.base.AbstractPersistenceServiceBase;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 10 Mar 2015
 */
@Service("userService")
@Repository
@Transactional
public class UserService extends AbstractPersistenceServiceBase<User, UserRepository, Long> {
    @Override
    public List<User> findByIdIn(List<Long> longs) {
        return null;
    }
}
