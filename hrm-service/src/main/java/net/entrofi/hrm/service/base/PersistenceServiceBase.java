package net.entrofi.hrm.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 09 Mar 2015
 */
public interface PersistenceServiceBase<T, K extends JpaRepository<T, ID>, ID extends Serializable> {
    /**
     *
     * This method should be used for spring repository autowiring which is also
     * the main purpose of the {{@link PersistenceServiceBase} interface
     *
     * @see {@link AbstractPersistenceServiceBase#setRepository(CrudRepository)}
     * @param repository
     *            the repository instance to be injected which should be child
     *            class of
     *            <code> org.springframework.data.repository.CrudRepository</code>
     */
    public void setRepository(K repository);

    public List<T> findAll();

    public List<T> findByIdIn(List<ID> idList);

    public Page<T> findAll(Pageable pageable);

    public List<T> findAll(Sort sort);

    public Page<T> findAll(int limit, int offset, String sort);

    public Page<T> findAll(int limit, int offset, Sort sort);

    public T find(ID id);

    public T persist(T entity);

    public List<T> persist(Iterable<T> iterable);

    public void delete(T entity);

    public void delete(ID id);

    public void delete(Iterable<? extends T> entities);

    public long count();

}
