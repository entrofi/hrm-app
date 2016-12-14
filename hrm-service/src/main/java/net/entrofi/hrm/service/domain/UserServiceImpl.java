package net.entrofi.hrm.service.domain;

import net.entrofi.hrm.domain.model.User;
import net.entrofi.hrm.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named("userService")
public class UserServiceImpl implements UserService {


//    @Autowired
//    private MongoOperations mongoOperations;


    @Inject
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User find(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return (List) userRepository.findAll();
    }
}
