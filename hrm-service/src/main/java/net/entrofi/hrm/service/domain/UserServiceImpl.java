package net.entrofi.hrm.service.domain;

import net.entrofi.hrm.domain.model.User;
import net.entrofi.hrm.domain.repository.UserRepository;
import net.entrofi.hrm.util.data.SpringPagingHelper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named("userService")
public class UserServiceImpl implements UserService {


//    @Autowired
//    private MongoOperations mongoOperations;


    @Inject
    private UserRepository repository;

    @Override
    public User save(final User user) {
        return repository.save(user);
    }


    @Override
    public void delete(final String id) {
        repository.delete(id);
    }

    @Override
    public void delete(final Iterable<? extends User> entities) {

    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(final User user) {
        repository.delete(user);
    }

    @Override
    public User find(final String id) {
        return repository.findById(id);
    }


    @Override
    public List<User> save(final Iterable<User> iterable) {
        return (List<User>) repository.save((Iterable) iterable);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public List<User> findByIdIn(final List<String> strings) {
        return null;
    }

    @Override
    public Page<User> findAll(final Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAll(final Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(final int limit, final int offset, final String sort) {
        Pageable pageable = SpringPagingHelper.generatePageable(limit, offset, sort);
        return repository.findAll(pageable);
    }

    @Override
    public Page<User> findAll(final int limit, final int offset, final Sort sort) {
        return null;
    }
}
