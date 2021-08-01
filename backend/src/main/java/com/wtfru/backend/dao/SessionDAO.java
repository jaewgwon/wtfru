package com.wtfru.backend.dao;

import com.wtfru.backend.session.dto.SessionDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionDAO {
    @Select("select * from sessions where uid=#{uid}")
    public SessionDTO getByUid(String uid);
}
