package net.entrofi.hrm.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 09 Mar 2015
 */
public interface PersistenceServiceBase<T, K extends CrudRepository<T, ID>, ID extends Serializable> {
    /**
     *
     * This method should be used for spring repository autowiring which is also
     * the main purpose of the {{@link PersistenceServiceBase} interface
     *
     * @see  TODO add abstraction link
     * @param repository
     *            the repository instance to be injected which should be child
     *            class of
     *            <code> org.springframework.data.repository.CrudRepository</code>
     */
     void setRepository(K repository);

     List<T> findAll();

     List<T> findByIdIn(List<ID> idList);

     Page<T> findAll(Pageable pageable);

     List<T> findAll(Sort sort);

     Page<T> findAll(int limit, int offset, String sort);

     Page<T> findAll(int limit, int offset, Sort sort);

     T find(ID id);

     T persist(T entity);

     List<T> persist(Iterable<T> iterable);

     void delete(T entity);

     void delete(ID id);

     void delete(Iterable<? extends T> entities);

     long count();

}
