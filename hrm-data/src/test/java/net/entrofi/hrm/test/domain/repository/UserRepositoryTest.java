package net.entrofi.hrm.test.domain.repository;

import net.entrofi.hrm.domain.entity.User;
import net.entrofi.hrm.domain.repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 08 Mar 2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/test-hrm-data-applicationContext.xml"})
@TransactionConfiguration(defaultRollback=true)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    public void testSave(){
        User user = new User();
        user.setName("Test");
        user.setLastname("lastname");
        user.setEmail("user@email.com");
        user.setUsername("username");
        User persistedUser = repository.save(user);
        assertNotNull(persistedUser);
        assertTrue(persistedUser.getId() > 0);
    }


}
