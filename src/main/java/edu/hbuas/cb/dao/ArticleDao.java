package edu.hbuas.cb.dao;

import edu.hbuas.cb.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 19:03
 **/
@Repository
public interface ArticleDao{
    Article getIdArticle(String articleId);
    List<Article> getIndexArticle();
    List<Article> getArticleListByType(String typeName, int start, int end);
    List<Article> getArticleListBySearch(String condition, int start, int end);
    int getTypeArticleLength(String typeName);
    int getSearchArticleLength(String condition);
}
