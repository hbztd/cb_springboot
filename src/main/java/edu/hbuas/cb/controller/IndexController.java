package edu.hbuas.cb.controller;

import edu.hbuas.cb.common.Const;
import edu.hbuas.cb.common.ResponseJson;
import edu.hbuas.cb.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 18:59
 **/
@RestController
@RequestMapping("/api")
public class IndexController {
    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/menu")
    public ResponseJson getIndexMenu() {
        return indexService.getIndexMenu();
    }

    @GetMapping("/indexArticle")
    public ResponseJson getIndexArticle() {
        return indexService.getIndexArticle();
    }

    @GetMapping("/typeArticle/{typeUrl}")
    public ResponseJson getTypeArticle(@PathVariable("typeUrl")String typeUrl, int start, int end) {
        return indexService.getTypeArticle(typeUrl, start, end);
    }

    @GetMapping("/search")
    public ResponseJson getSearchArticle(String condition, int start, int end) {
        return indexService.getSearchArticle(condition, start, end);
    }

    @GetMapping("/article/{articleId}")
    public ResponseJson getIdArticle(@PathVariable("articleId") String articleId) {
        return indexService.getIdArticle(articleId);
    }

    @GetMapping("/amount")
    public ResponseJson getArticleAmount(String way, String value) {
        if(Const.WAY_TYPE.equals(way)) {
            return indexService.getTypeArticleAmount(value);
        } else if(Const.WAY_SEARCH.equals(way)) {
            return indexService.getSearchArticleAmount(value);
        } else {
            return ResponseJson.createDefaultError();
        }
    }
}
