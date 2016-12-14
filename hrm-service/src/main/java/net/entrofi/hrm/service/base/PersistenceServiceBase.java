package net.entrofi.hrm.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.io.Serializable;
import java.util.List;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 09 Mar 2015
 */
public interface PersistenceServiceBase<T, ID extends Serializable> {

    List<T> findAll();

    List<T> findByIdIn(final List<ID> idList);

    Page<T> findAll(final Pageable pageable);

    List<T> findAll(final Sort sort);

    Page<T> findAll(final int limit, final int offset, final String sort);

    Page<T> findAll(final int limit, final int offset, final Sort sort);

    T find(final ID id);

    T save(final T entity);

    List<T> save(final Iterable<T> iterable);

    void delete(final T entity);

    void delete(final ID id);

    void delete(final Iterable<? extends T> entities);

    long count();

}
