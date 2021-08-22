package com.wtfru.backend.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import com.wtfru.backend.dto.LocationDTO;

@Repository
public interface LocationDAO {
    @Results(id = "locationDTO", value = {
            @Result(property = "locationId", column = "location_id", id = true),
            @Result(property = "sessionUid", column = "session_uid"),
            @Result(property = "updatedDate", column = "updated_date")
    })

    @Insert("insert into locations (session_uid, latitude, longitude) " +
            "values (#{sessionUid}, #{latitude}, #{longitude})")
    public boolean post(String sessionUid, Double latitude, Double longitude);

    @ResultMap("locationDTO")
    @Select("select * from locations where session_uid=#{sessionUid}")
    public LocationDTO get(String sessionUid);

    @Update("update locations set latitude=#{latitude}, longitude=#{longitude} " +
            "where session_uid=#{sessionUid}")
    public boolean update(Double latitude, Double longitude, String sessionUid);
}
