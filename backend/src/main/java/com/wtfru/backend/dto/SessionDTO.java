package com.wtfru.backend.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
public class SessionDTO {
    private String uid;
    private int sessionId;
    private String title;
    private String password;
    private String locationLink;
    private int status;
    private Date expiredDate;
    private LocationDTO locationDTO;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLocationLink() {
        return locationLink;
    }

    public void setLocationLink(String locationLink) {
        this.locationLink = locationLink;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public LocationDTO getLocationDTO() {
        return locationDTO;
    }

    public void setLocationDTO(LocationDTO locationDTO) {
        this.locationDTO = locationDTO;
    }

    public SessionDTO() {
        this.uid = null;
        this.sessionId = 0;
        this.title = null;
        this.password = null;
        this.locationLink = null;
        this.status = 0;
    }

    public SessionDTO(String uid, int sessionId, String title, String password, String locationLink, int status) {
        this.uid = uid;
        this.sessionId = sessionId;
        this.title = title;
        this.password = password;
        this.locationLink = locationLink;
        this.status = status;
    }
}
