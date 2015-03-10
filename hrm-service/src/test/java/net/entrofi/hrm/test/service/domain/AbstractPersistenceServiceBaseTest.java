package net.entrofi.hrm.test.service.domain;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 10 Mar 2015
 */
public abstract class AbstractPersistenceServiceBaseTest extends TestCase {

    protected final static String INVALID_LIST_SIZE_MSG = "The size of the initially persisted list is invalid";
    protected static final String UNABLE_TO_SAVE_LIST_MSG = "Unable to save the initial list";

    protected final int INIT_PERSISTED_LIST_SIZE = 50;

    @Test
    public abstract void testFindAllPageable();

    @Test
    public abstract void testFindAll();

    @Test
    public abstract void testFindByIdIn();


    @Test
    public abstract void testFind();



    @Test
    public abstract void testPersist();

    @Test
    public abstract void testPersistAll();


    @Test
    public abstract void testDeleteByIdList() ;


    @Test
    public abstract void testDeleteById();


    @Test
    public abstract void testDelete();


    @Test
    public abstract void testCount();



}
