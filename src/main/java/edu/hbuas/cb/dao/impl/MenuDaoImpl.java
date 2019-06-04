package edu.hbuas.cb.dao.impl;

import edu.hbuas.cb.dao.MenuDao;
import edu.hbuas.cb.pojo.Menu;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * Author: Po
 * Date: 2019/4/30 19:04
 **/
@Repository
public class MenuDaoImpl implements MenuDao {
    private final MongoTemplate mongoTemplate;

    public MenuDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Menu> getMenu() {
        return mongoTemplate.findAll(Menu.class);
    }
}
