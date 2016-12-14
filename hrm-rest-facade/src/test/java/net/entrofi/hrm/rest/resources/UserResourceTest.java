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
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO add javadoc
 * Created on 15/12/2016.
 */
public class UserResourceTest extends AbstractResourceTest {

    private static final String USER_RESOURCE_PATH = "/users";
    private static final String DELETE_ID = "5855600425696132846dce10";
    private static final String DELETE_DOC = "5855600425696132846dce11";
    private static final List<String> DELETE_DOC_ID_LIST = Arrays.asList(new String[]{"5855600425696132846dce12"
            , "5855600425696132846dce13"
            , "5855600425696132846dce14"
            , "5855600425696132846dce15"
            , "5855600425696132846dce16"});
    @Test
    public void testList() {
        SimplePageImplClientTestModel<User> userPage = target(USER_RESOURCE_PATH + "/list/").request().get(SimplePageImplClientTestModel.class);
        assertNotNull(userPage);
    }

    @Test
    public void testListWithLimitAndOffset() {
        SimplePageImplClientTestModel<User> userPage = target(USER_RESOURCE_PATH + "/list/")
                .queryParam(DocumentCrudResource.UriParams.QUERY_PARAM_LIMIT, 3)
                .queryParam(DocumentCrudResource.UriParams.PATH_PARAM_OFFSET_NAME, 2)
                .request().get(SimplePageImplClientTestModel.class);
        assertNotNull(userPage);
        assertEquals(3, userPage.getSize());
        assertEquals(2, userPage.getNumber());
    }

    @Test
    public void testListPage() {
        fail("test not impelemented yet");
    }

    @Test
    public void testFind() {
        final String userId = "58550ff12569613e10a2449d";
        User user = target(USER_RESOURCE_PATH
                + DocumentCrudResource.UriParams.PATH_SEGMENT_ITEM + userId)
                .request().get(User.class);
        assertNotNull("User with id: " + userId +" not found." ,user);
    }

    @Test
    public void testSave() {
        User user = new User();
        String randomPrefix = Math.random() + "_";
        user.setEmail(randomPrefix+"resourcesave@test.hrm.net");
        user.setLastName(randomPrefix+"resourcesave-test");
        user.setName(randomPrefix+"resourcesave");
        user.setUsername(randomPrefix+"resourcesave_username");
        user.setPassword(randomPrefix+"abc");

        Entity<User> userEntity = Entity.json(user);
        Response response = target(USER_RESOURCE_PATH ).request().post(userEntity);
        assertNotNull(response.getEntity());
        User savedUser = response.readEntity(User.class);
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertNotNull(savedUser.getId());
    }

    @Test
    public void testAddXML() {

    }

    @Test
    public void testDeleteById() {
       Response response =  target(USER_RESOURCE_PATH
                + DocumentCrudResource.UriParams.PATH_SEGMENT_DELETE
                + DocumentCrudResource.UriParams.PATH_SEGMENT_ITEM
                + DELETE_ID).request().get();
       assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

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
