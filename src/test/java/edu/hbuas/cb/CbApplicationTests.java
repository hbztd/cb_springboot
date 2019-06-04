package edu.hbuas.cb;

import edu.hbuas.cb.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CbApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.sample(10));
        AggregationResults results = mongoTemplate.aggregate(aggregation, Article.class, Article.class);
        System.out.println(results.getMappedResults().size());
    }

}
