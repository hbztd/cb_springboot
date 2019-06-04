package edu.hbuas.cb.service;

import edu.hbuas.cb.common.ResponseJson;
import edu.hbuas.cb.pojo.Menu;

import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 19:00
 **/
public interface IndexService {
    ResponseJson getIndexMenu();
    ResponseJson getIndexArticle();
    ResponseJson getTypeArticle(String typeUrl, int start, int end);
    ResponseJson getSearchArticle(String condition, int start, int end);
    ResponseJson getIdArticle(String articleId);
    ResponseJson getSearchArticleAmount(String condition);
    ResponseJson getTypeArticleAmount(String typeUrl);
}
