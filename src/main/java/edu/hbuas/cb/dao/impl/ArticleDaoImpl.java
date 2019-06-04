package edu.hbuas.cb.dao.impl;

import edu.hbuas.cb.dao.ArticleDao;
import edu.hbuas.cb.pojo.Article;
import edu.hbuas.cb.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 19:03
 **/
@Repository
public class ArticleDaoImpl implements ArticleDao {

    private final MongoTemplate mongoTemplate;

    public ArticleDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Article getIdArticle(String articleId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(articleId));
        return mongoTemplate.findOne(query, Article.class);
    }

    @Override
    public List<Article> getIndexArticle() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.sample(10));
        AggregationResults results =  mongoTemplate.aggregate(aggregation, Article.class,Article.class);
        return results.getMappedResults();
    }

    @Override
    public List<Article> getArticleListByType(String typeUrl, int start, int end) {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(typeUrl));
        query.skip(start).limit(end-start);
        List<Type> list = mongoTemplate.find(query, Type.class);
        List<String> idList = new ArrayList<>();
        for(Type type: list) {
            idList.add(type.getId());
        }
        query = new Query();
        query.addCriteria(Criteria.where("id").in(idList));
        return mongoTemplate.find(query, Article.class);
    }

    @Override
    public List<Article> getArticleListBySearch(String condition, int start, int end) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(condition));
        query.skip(start).limit(end-start);
        return mongoTemplate.find(query, Article.class);
    }

    @Override
    public int getTypeArticleLength(String typeUrl) {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(typeUrl));
        return mongoTemplate.find(query,Type.class).size();
    }

    @Override
    public int getSearchArticleLength(String condition) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(condition));
        return mongoTemplate.find(query,Article.class).size();
    }

}
