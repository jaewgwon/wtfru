package com.wtfru.backend.service;

import com.wtfru.backend.dao.LocationDAO;
import com.wtfru.backend.dto.LocationDTO;
import com.wtfru.backend.exception.DataIOException.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationDAO locationDAO;

    @Override
    @Transactional
    public LocationDTO postLocation(LocationDTO location) {return locationDAO.post(location);}

    @Override
    public LocationDTO getLocation(String sessionUid) {return locationDAO.get(sessionUid);}

    @Override
    public void patchLocation(String sessionUid, LocationDTO location) throws SessionNotFoundException {
        if(!locationDAO.update(sessionUid, location)) {
            throw new SessionNotFoundException("the session is not found");
        }
    }
}
