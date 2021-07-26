package com.wtfru.backend.session.dao;

import com.wtfru.backend.session.dto.SessionDTO;
import org.apache.ibatis.annotations.*;

public interface SessionDAO {
    @Results(id="ssession", value={
            @Result(property = "uid", column = "uid"),
            @Result(property = "sessionId", column = "session_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "password", column = "password"),
            @Result(property = "locationLink", column = "location_link"),
            @Result(property = "status", column = "status")
    })

    @Select("select * from sessions where session_id=#{sessionId}")
    public SessionDTO get(int sessionId);

    @Delete("delete from sessions where uid=#{uid}")
    public int delete(String uid);

    @Insert("insert into sessions (session_id, title, password, location_link, status) " +
            "values (nextval('session_id'),#{title},#{password},#{locationLink}, 0)")
    public boolean post(String title, String password, String locationLink);

    @Select("select exists (select * from sessions where title=#{title}) as isChk")
    public int isTitleAvailable(String title);

    @Select("select *  from sessions where title = #{title}")
    public SessionDTO getByTitle(String title);

}
