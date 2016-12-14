package net.entrofi.hrm.service;

import net.entrofi.hrm.domain.model.User;
import net.entrofi.hrm.service.domain.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;


public class UserServiceTest extends AbstractServiceTest {


    @Autowired
    private UserService userService;


    @Before
    public void setUp(){
        importJSON("user", "/data/users_sample.json");
    }



    @Test
    public void testFind(){
        List<User> allUsers = userService.findAll();
        User user = userService.find(allUsers.get(0).getId());
        assertEquals("Found user is not the correct one", allUsers.get(0).getId(), user.getId());
    }

    @Test
    public void testFindAll(){
        List<User> userList = userService.findAll();
        assertNotNull(userList);
        assertTrue(userList.size() > 0);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setEmail("mail@integrationtest.net");
        user.setName("integration");
        user.setLastName("test");
        user.setPassword("123456");
        user.setUsername("integrationtest");
        userService.save(user);
        assertNotNull(user.getId());
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("save");
        user.setLastName("integration");
        user.setEmail("test@update.net");
        user.setPassword("123456");
        user.setUsername("save_user");
        userService.save(user);
        assertNotNull(user.getId());


    }


    @Test
    public void testDelete(){
        String userId = userService.findAll().get(0).getId();
        userService.delete(userId);
        User user = userService.find(userId);
        assertNull(user);
    }


}
