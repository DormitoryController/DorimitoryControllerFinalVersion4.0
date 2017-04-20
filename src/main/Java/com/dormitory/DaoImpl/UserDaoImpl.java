package com.dormitory.DaoImpl;

import com.dormitory.Dao.UserDao;
import com.dormitory.model.po.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 赵嗣瑜 on 2017/4/19.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public String addUser() {
        return "test";
    }

    public List<User> findUser() {
        return sqlSessionTemplate.selectList("findUser");
    }
}
