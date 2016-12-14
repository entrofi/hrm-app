/*
 * Copyright 2003-2016 Monitise Group Limited. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Monitise Group Limited.
 * Any reproduction of this material must contain this notice.
 */
package net.entrofi.hrm.service;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import static junit.framework.TestCase.fail;

/**
 * TODO add javadoc
 * Created on 30/11/2016.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {ServiceTestsApplicationConfig.class})
public abstract class AbstractServiceTest {


    @Autowired
    private MongoTemplate mongoTemplate;

    protected void importJSON(String collection, String filePath) {
        try {
            String json = StreamUtils.copyToString(getClass().getResourceAsStream(filePath), Charset.forName("UTF-8"));

            if (mongoTemplate.getDb().collectionExists(collection)) {
                mongoTemplate.dropCollection(collection);
            }
            BasicDBList basicDBList = (BasicDBList) JSON.parse(json);
            mongoTemplate.getCollection(collection).insert(basicDBList.toArray(new DBObject[basicDBList.size()]));
        } catch (IOException e) {
            e.printStackTrace();
            fail("Unable to read data file: " + filePath);
        }
    }


    @Test
    public void testFind(){
        fail("not implemented yet.");
    }

    @Test
    public void testFindAll(){
        fail("not implemented yet.");
    }

    @Test
    public void testSave(){
        fail("not implemented yet.");
    }

    @Test
    public void testUpdate(){
        fail("not implemented yet.");

    }


    @Test
    public void testDelete(){
        fail("not implemented yet.");
    }

}
