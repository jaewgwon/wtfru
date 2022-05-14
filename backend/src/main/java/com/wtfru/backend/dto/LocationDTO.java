package com.wtfru.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class LocationDTO {
    private int locationId;
    private String sessionUid;
    private double latitude;
    private double longitude;
    private Date updatedDate;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getSessionUid() {
        return sessionUid;
    }

    public void setSessionUid(String sessionUid) {
        this.sessionUid = sessionUid;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocationDTO() {
        this.locationId = 0;
        this.sessionUid = null;
        this.latitude = 0;
        this.longitude = 0;
        this.updatedDate = null;
    }

    public LocationDTO(int locationId, String sessionUid, double latitude, double longitude, Date updatedDate) {
        this.locationId = locationId;
        this.sessionUid = sessionUid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.updatedDate = updatedDate;
    }
}
