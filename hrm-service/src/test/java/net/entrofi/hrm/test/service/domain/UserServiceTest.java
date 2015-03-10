package net.entrofi.hrm.test.service.domain;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 10 Mar 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/test-hrm-service-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class UserServiceTest {
}
