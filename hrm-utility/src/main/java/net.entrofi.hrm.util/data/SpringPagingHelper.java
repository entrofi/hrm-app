package net.entrofi.hrm.util.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hasan COMAK
 * @created 1/23/2015
 */
public final class SpringPagingHelper {

    private static final Logger LOG = LoggerFactory.getLogger(SpringPagingHelper.class);

    public static final String DEFAULT_DIRECTION_DELIMITER = ",";

    private SpringPagingHelper(){

    }

    /**
     * DOC documentation:method
     *
     * @param limit
     * @param offset
     * @param sortQuery
     * @return
     */
    public static Pageable generatePageable(int limit, int offset, String sortQuery) {
        return generatePageable(limit, offset, sortQuery, DEFAULT_DIRECTION_DELIMITER);
    }


    /**
     * DOC documentation:method
     * @param limit
     * @param offset
     * @param sortQuery
     * @param sortDirectionDelimiter
     * @return
     */
    public static Pageable generatePageable(int limit, int offset, String sortQuery, String sortDirectionDelimiter){
        if(!isInLimitOffsetBoundary(limit, offset) ){
            return null;
        }
        boolean sortEmpty = StringUtils.isEmpty(sortQuery);
        boolean delimiterEmpty = StringUtils.isEmpty(sortDirectionDelimiter);
        Sort sort;
        if(!sortEmpty && !delimiterEmpty) {
            sort = parseSort(sortQuery, sortDirectionDelimiter);
            return new PageRequest(offset, limit, sort);
        }else if(!sortEmpty && delimiterEmpty){
            sort = parseSort(sortQuery, DEFAULT_DIRECTION_DELIMITER);
            return new PageRequest(offset, limit, sort);
        }
        return new PageRequest(offset, limit);
    }


    /**
     * DOC documentation:method
     * @param limit
     * @param offset
     * @param sort
     * @return
     */
    public static Pageable generatePageable(int limit, int offset, Sort sort){
        if(!isInLimitOffsetBoundary(limit, offset) ){
            return null;
        }
        return new PageRequest(offset, limit, sort);
    }

    /**
     * DOC documentation:method
     *
     * @param source assumed to be not null (no null check)
     * @return
     */
    public static Sort parseSort(String source, String directionDelimiter){
        LOG.debug("Parsing page sort matrix..." + source);
        if(StringUtils.isEmpty(source)){
            return null;
        }
        List<Sort.Order> orderList = new ArrayList<Sort.Order>();
        String[] ordersStrings = source.split("\\&");

        for(String orderParam: ordersStrings){
            String[] parts = orderParam.split(directionDelimiter);

            Sort.Direction direction = parts.length <= 1 ? null : Sort.Direction.fromString(parts[parts.length - 1]);

            for(int i = 0;  i < parts.length; i++){
                if(i == parts.length -1 && direction != null){
                    continue;
                }
                String property = parts[i];
                if(StringUtils.hasText(property)){
                    orderList.add(new Sort.Order(direction, property));
                }
            }
        }
        return orderList.isEmpty() ? null : new Sort(orderList);
    }


    /**
     * DOC documenation:method
     * @param limit
     * @param offset
     * @return
     */
    private static boolean isInLimitOffsetBoundary(int limit, int offset){
        if(limit > 0 && offset >= 0){
            return true;
        }
        return false;
    }
}
