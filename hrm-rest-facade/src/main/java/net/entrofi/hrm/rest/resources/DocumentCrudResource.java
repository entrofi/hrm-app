package net.entrofi.hrm.rest.resources;

import org.springframework.data.domain.Page;

import javax.validation.Valid;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static net.entrofi.hrm.rest.resources.DocumentCrudResource.UriParams.*;


/**
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 *
 * @author hcomak
 * @created 08 Mar 2015
 */
public interface DocumentCrudResource<T> {



    /**
     * list DOC documentation:method
     *
     * @param limit
     * @param offset
     * @return
     */
    @SuppressWarnings("PathAnnotation")
    @GET
    @Path(value = PATH_SEGMENT_LIST_ZERO_ONE)
    @Produces(MediaType.APPLICATION_JSON)
    Page<T> list(@DefaultValue(QUERY_PARAM_LIMIT_DEFAULT) @QueryParam(QUERY_PARAM_LIMIT) int limit,
                        @QueryParam("offset") int offset);

    /**
     * DOC documentation:method
     *
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    @SuppressWarnings("PathAnnotation")
    @GET
    @Path(PATH_SEGMENT_LIST_ONLY_ONE + "/" + PATH_PARAM_OFFSET)
    @Produces(MediaType.APPLICATION_JSON)
    Page<T> listPage(@DefaultValue(QUERY_PARAM_LIMIT_DEFAULT) @QueryParam(QUERY_PARAM_LIMIT) int limit,
                            @PathParam("offset") int offset, @MatrixParam("sort") String sort);

    /**
     * find DOC documentation:method
     *
     * @param id
     * @return
     */
    @GET
    @Path(PATH_SEGMENT_ITEM + PATH_PARAM_ID)
    T find(@PathParam(PATH_PARAM_ID_NAME) String id);

    /**
     * add DOC documentation:method
     *
     * @param entity
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response add(@Valid T entity);


    /**
     * addXML DOC documentation:method
     *
     * @param entity
     * @return
     * @NOTE: This method might not be necessary at this level. Check out in the implementation time.
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    Response addXML(@Valid T entity);

    /**
     * delete DOC documentation:method
     *
     * @param id
     * @return
     */
    @DELETE
    @Path(PATH_SEGMENT_DELETE + PATH_SEGMENT_ITEM + PATH_PARAM_ID)
    Response delete(@PathParam(PATH_PARAM_ID_NAME) String id);

    /**
     * delete DOC documentation:method
     *
     * @param entity
     * @return
     */
    @PUT
    @Path(PATH_SEGMENT_DELETE)
    Response delete(T entity);


    /**
     * DOC documentation:method
     *
     * @param ids
     * @return
     */
    @DELETE
    @Path(PATH_SEGMENT_DELETE)
    Response delete(@QueryParam(QUERY_PARAM_IDS) List<Long> ids);

    final class UriParams {

        public static final String PATH_VERSION_EXPRESSION = "/{version: v([0-9]){1}((.)([0-9]){1,2}){0,1}}";

        public static final String PATH_SEGMENT_DELETE = "/delete";

        public static final String PATH_SEGMENT_ITEM = "/item-";

        public static final String PATH_SEGMENT_LIST_ZERO_ONE = "/{list:list?}";

        public static final String PATH_SEGMENT_LIST_ONLY_ONE = "/{list:(list){1,1}}";

        public static final String QUERY_PARAM_LIMIT = "limit";

        public static final String QUERY_PARAM_LIMIT_DEFAULT = "-1";

        public static final String PATH_PARAM_OFFSET = "{offset}";
        public static final String PATH_PARAM_OFFSET_NAME = "offset";

        public static final String QUERY_PARAM_ID = "id";

        public static final String QUERY_PARAM_IDS = "ids";

        public static final String PATH_PARAM_ID = "{id}";

        public static final String PATH_PARAM_ID_NAME = "id";

        public static final String PATH_PARAM_VERSION = "version";

        private UriParams() {

        }
    }

}
