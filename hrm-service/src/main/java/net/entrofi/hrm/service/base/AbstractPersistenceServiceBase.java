package net.entrofi.hrm.service.base;

import net.entrofi.hrm.util.data.SpringPagingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
public abstract class AbstractPersistenceServiceBase<T, K extends JpaRepository<T, ID>, ID extends Serializable> implements PersistenceServiceBase<T, K, ID> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractPersistenceServiceBase.class);

    @Autowired
    private K repository;


    /**
     *
     * This method is overriding the findAll method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#findAll(org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<T> findAll(Pageable pageable){
        return this.getRepository().findAll(pageable);
    }


    /**
     *
     * This method is overriding the findAll method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#findAll(org.springframework.data.domain.Sort)
     */
    @Override
    public List<T> findAll(Sort sort){
        return this.getRepository().findAll(sort);
    }

    /**
     * DOC documentation:overriding_method
     * @param limit
     * @param offset
     * @param sortString
     * @return
     */
    @Override
    public Page<T> findAll(int limit, int offset, String sortString){
        Pageable pageable = SpringPagingHelper.generatePageable(limit, offset, sortString);
        Sort sort = SpringPagingHelper.parseSort(sortString, SpringPagingHelper.DEFAULT_DIRECTION_DELIMITER);
        if(pageable != null){
            return findAll(pageable);
        }else{
            return findAllBySort(sort);
        }
    }

    /**
     * DOC documentation:overriding_method
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public Page<T> findAll(int limit, int offset, Sort sort){
        Pageable pageable = SpringPagingHelper.generatePageable(limit, offset, sort);
        if(pageable != null){
            return findAll(pageable);
        }else{
            return findAllBySort(sort);
        }
    }
    /**
     * This method is overriding the findAll method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#findAll()
     */
    @Override
    public List<T> findAll() {
        List<T> entityList = (List<T>)this.getRepository().findAll();
        LOG.debug("Getting entity list. The size is:" + entityList.size());
        return entityList;
    }


    /**
     * This method is overriding the find method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#find(java.lang.Long)
     */
    @Override
    public T find(ID id) {
        return getRepository().findOne(id);
    }


    /**
     * DOC documentation:method
     * @param sort
     * @return
     */
    private Page<T> findAllBySort(Sort sort){
        if(sort != null){
            return new PageImpl<T>(findAll(sort));
        }else{
            return new PageImpl<T>(findAll());
        }
    }

    /**
     * This method is overriding the persist method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#persist(java.lang.Object)
     */
    @Override
    public T persist(T t) {
        return this.getRepository().save(t);
    }

    /**
     * This method is overriding the persist method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#persist(java.lang.Object)
     */
    @Override
    public List<T> persist(Iterable<T> iterable) {
        return this.getRepository().save(iterable);
    }
    /**
     * This method is overriding the delete method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#delete(java.lang.Object)
     */
    @Override
    public void delete(T t) {
        this.getRepository().delete(t);

    }

    /**
     * This method is overriding the delete method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#delete(java.io.Serializable)
     */
    @Override
    public void delete(ID id) {
        LOG.debug("Service will delete item" + id);
        getRepository().delete(id);

    }

    /**
     * This method is overriding the deleteAll method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#deleteAll(java.lang.Iterable)
     */
    @Override
    public void delete(Iterable<? extends T> entities) {
        getRepository().delete(entities);
    }

    /**
     * This method is overriding the count method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#count()
     */
    @Override
    public long count() {
        return getRepository().count();
    }

    /**
     * This method is overriding the setRepository method.
     * DOC documentation:overriding_method
     *
     * @see PersistenceServiceBase#setRepository(org.springframework.data.repository.CrudRepository)
     */
    @Override
    public final void setRepository(K repository) {
        this.repository = repository;
    }

    public K getRepository(){
        return this.repository;
    }

}
