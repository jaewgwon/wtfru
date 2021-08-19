package com.wtfru.backend.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.wtfru.backend.dto.LocationDTO;

@Repository
public interface LocationDAO {
    @Insert("insert into locations values")
    public LocationDTO post(LocationDTO location);

    @Select("select from locations where session_uid=#{sessionUid}")
    public LocationDTO get(String sessionUid);

    @Update("update locations set latitude={location.latitude}, longitude=#{location.longitude} " +
            "where session_uid=#{location.sessionUid")
    public boolean update(LocationDTO location);
}
