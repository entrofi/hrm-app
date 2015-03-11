/**
 * 
 */
package net.entrofi.hrm.rest.resources;


import net.entrofi.hrm.domain.entity.User;
import net.entrofi.hrm.domain.repository.UserRepository;
import net.entrofi.hrm.service.base.PersistenceServiceBase;
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
 * @author hcomak
 *
 */
@Named
@Path("/users")
public class UserResource implements EntityCrudResource<User> {
	

	
	private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

	@Inject
	@Named("userService")
	private PersistenceServiceBase<User, UserRepository, Long> service;
	
	
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
	public List<User> list(int limit, int offset) {
		return null;
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
		return null;
	}

	@Override
	public Response add(User user){
		User persistedUser = service.persist(user);
		
		URI entityURI = uriInfo.getAbsolutePathBuilder().path(Long.toString(persistedUser.getId())).build();
		
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
	public Response delete(long id) {
		return null;
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
