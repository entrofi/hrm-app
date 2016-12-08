package net.entrofi.hrm.service.domain;



import net.entrofi.hrm.domain.model.User;

import java.util.List;

public interface UserService {


    User save(User user);

    User update(User user);

    void delete(User user);

    void delete(String id);

    User find(String id);

    List<User> findAll();

}
