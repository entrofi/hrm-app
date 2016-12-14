/**
 *
 */
package net.entrofi.hrm.rest.resources;


import net.entrofi.hrm.domain.model.User;
import net.entrofi.hrm.service.domain.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * @author Hasan Comak
 */
@Named
@Path("/users")
public class UserResource implements DocumentCrudResource<User> {


    private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

    @Inject
    @Named("userService")
    private UserService service;


    @Context
    private UriInfo uriInfo;

    /**
     * list DOC documentation:method
     *
     * @param limit
     * @param offset
     * @return
     */
    @Override
    public Page<User> list(int limit, int offset) {
        return service.findAll(limit, offset, "");
    }

    /**
     * DOC documentation:method
     *
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @Override
    public Page<User> listPage(int limit, int offset, String sort) {
        return null;
    }

    /**
     * find DOC documentation:method
     *
     * @param id
     * @return
     */
    @Override
    public User find(String id) {
        return service.find(id);
    }

    @Override
    public Response add(User user) {
        User persistedUser = service.save(user);

        URI entityURI = uriInfo.getAbsolutePathBuilder().path(persistedUser.getId()).build();

        return Response.status(Status.CREATED).entity(persistedUser).location(entityURI).build();
    }

    /**
     * addXML DOC documentation:method
     *
     * @param entity
     * @return
     * @NOTE: This method might not be necessary at this level. Check out in the implementation time.
     */
    @Override
    public Response addXML(@Valid User entity) {
        return null;
    }

    /**
     * delete DOC documentation:method
     *
     * @param id
     * @return
     */
    @Override
    public Response delete(String id) {
        URI listURI = uriInfo.getAbsolutePathBuilder().path(UriParams.PATH_SEGMENT_LIST_ONLY_ONE).build();
        service.delete(id);
        return Response.status(Status.OK).entity(id).location(listURI).build();
    }

    /**
     * delete DOC documentation:method
     *
     * @param entity
     * @return
     */
    @Override
    public Response delete(User entity) {

        return null;
    }

    /**
     * DOC documentation:method
     *
     * @param ids
     * @return
     */
    @Override
    public Response delete(List<Long> ids) {
        return null;
    }

}
