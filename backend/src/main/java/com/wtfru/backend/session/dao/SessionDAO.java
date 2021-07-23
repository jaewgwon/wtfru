package com.wtfru.backend.session.dao;

import com.wtfru.backend.session.dto.SessionDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

public interface SessionDAO {
    @Results(id="session", value={
            @Result(property = "uid", column = "uid"),
            @Result(property = "sessionId", column = "session_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "password", column = "password"),
            @Result(property = "locationLink", column = "location_link"),
            @Result(property = "status", column = "status")
    })

    @Select("select * from sessions where session_id=#{sessionId}")
    public SessionDTO selectSession(int sessionId);

    @Delete("delete from sessions where uid=#{uid}")
    public int deleteSession(String uid);

    @Insert("insert into sessions (session_id, title, password, location_link, status) " +
            "values (nextval('session_id'),#{title},#{password},#{locationLink}, 0)")
    public int insertSession(String title, String password, String locationLink);

    @Select("select title from sessions where title=#{title}")
    public boolean isTitleAvailable(String title);

}
