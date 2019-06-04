package edu.hbuas.cb.service.impl;

import edu.hbuas.cb.common.Const;
import edu.hbuas.cb.common.ResponseJson;
import edu.hbuas.cb.dao.ArticleDao;
import edu.hbuas.cb.dao.MenuDao;
import edu.hbuas.cb.service.IndexService;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 19:02
 **/
@Service
public class IndexServiceImpl implements IndexService {
    private final MenuDao menuDao;
    private final ArticleDao articleDao;


    public IndexServiceImpl(MenuDao indexDao, ArticleDao articleDao) {
        this.menuDao = indexDao;
        this.articleDao = articleDao;
    }

    @Override
    public ResponseJson getIndexMenu() {
        return ResponseJson.createSuccessWithData("OK", menuDao.getMenu());
    }

    @Override
    public ResponseJson getIndexArticle() {
        return ResponseJson.createSuccessWithData("OK", articleDao.getIndexArticle());
    }

    @Override
    public ResponseJson getTypeArticle(String typeUrl, int start, int end) {
        return ResponseJson.createSuccessWithData("OK", articleDao.getArticleListByType(typeUrl, start*Const.PEER_PAGE_LENGTH, end*Const.PEER_PAGE_LENGTH));
    }

    @Override
    public ResponseJson getSearchArticle(String condition, int start, int end) {
        return ResponseJson.createSuccessWithData("OK", articleDao.getArticleListBySearch(condition, start*Const.PEER_PAGE_LENGTH, end*Const.PEER_PAGE_LENGTH));
    }

    @Override
    public ResponseJson getIdArticle(String articleId) {
        return ResponseJson.createSuccessWithData("OK",articleDao.getIdArticle(articleId));
    }

    @Override
    public ResponseJson getSearchArticleAmount(String condition) {
        return ResponseJson.createSuccessWithData("OK", articleDao.getSearchArticleLength(condition)/Const.PEER_PAGE_LENGTH+1);
    }

    @Override
    public ResponseJson getTypeArticleAmount(String typeUrl) {
        return ResponseJson.createSuccessWithData("OK", articleDao.getTypeArticleLength(typeUrl)/Const.PEER_PAGE_LENGTH+1);
    }
}
