package com.dormitory.Dao;

import com.dormitory.model.po.Checkcode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by war on 2017/4/17.
 */
@Repository
public interface CheckcodeMapper {
    Checkcode selectCheckcodeById(@Param("check_id") int check_id);  //查询验证码
}
