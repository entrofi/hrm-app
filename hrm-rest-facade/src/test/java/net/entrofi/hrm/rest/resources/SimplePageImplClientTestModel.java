package net.entrofi.hrm.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.entrofi.hrm.util.data.SpringPagingHelper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by hasan on 12/17/2016.
 */
public class SimplePageImplClientTestModel<T> extends PageImpl<T> {

    @JsonCreator
    public SimplePageImplClientTestModel(@JsonProperty("content") List<T> content,
                                         @JsonProperty("last") boolean last,
                                         @JsonProperty("totalPages") long totalPages,
                                         @JsonProperty("size") int size,
                                         @JsonProperty("number") int number,
                                         @JsonProperty("sort") String sort,
                                         @JsonProperty("numberOfElements") long numberOfElements,
                                         @JsonProperty("first") boolean first,
                                         @JsonProperty("totalElements") long total) {

        super(content, SpringPagingHelper.generatePageable(size, number, sort), total);
    }
}
