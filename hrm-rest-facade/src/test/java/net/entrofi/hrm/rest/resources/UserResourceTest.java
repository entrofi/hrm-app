/*
 * Copyright 2003-2016 Monitise Group Limited. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Monitise Group Limited.
 * Any reproduction of this material must contain this notice.
 */
package net.entrofi.hrm.rest.resources;

import net.entrofi.hrm.domain.model.User;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.data.domain.Page;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * TODO add javadoc
 * Created on 15/12/2016.
 */
public class UserResourceTest extends AbstractResourceTest {


    @Test
    public void testList() {
        Page<User> users = target("/users/list").request().get(Page.class);
        assertNotNull(users);
    }

    @Test
    public void testListPage() {
        fail("test not impelemented yet");
    }

    @Test
    public void testFind() {
        User user = target("/users" + "/item-5851262b7ab1631926aaa24b")
                .request().get(User.class);
        assertNotNull(user);
    }

    @Test
    public void testSave() {
        fail("test not impelemented yet");
    }

    @Test
    public void testAddXML() {
        fail("test not impelemented yet");
    }

    @Test
    public void testDeleteById() {
        fail("test not impelemented yet");
    }

    @Test
    public void testDeleteDocument() {
        fail("test not impelemented yet");
    }

    @Test
    public void testDeleteDocumentList() {
        fail("test not impelemented yet");
    }

}
