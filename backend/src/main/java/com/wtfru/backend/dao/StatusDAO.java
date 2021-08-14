package com.wtfru.backend.dao;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDAO {
    @Update("update sessions set status=#{status} where uid=#{uid}")
    public boolean update(String uid, int status);
}
