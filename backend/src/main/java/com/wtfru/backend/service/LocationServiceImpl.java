package com.wtfru.backend.service;

import com.wtfru.backend.dao.LocationDAO;
import com.wtfru.backend.dao.SessionDAO;
import com.wtfru.backend.dto.LocationDTO;
import com.wtfru.backend.dto.SessionDTO;
import com.wtfru.backend.exception.DataIOException.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationDAO locationDAO;
    @Autowired
    SessionDAO sessionDAO;

    @Override
    @Transactional
    public LocationDTO postLocation(String sessionTitle, LocationDTO location) {
        SessionDTO session = sessionDAO.getByTitle(sessionTitle);

        if(!locationDAO.post(session.getUid(), location.getLatitude(), location.getLongitude())) {
            //TODO(KSY): Handle exception appropriately
            return null;
        }
        return locationDAO.get(session.getUid());
    }

    @Override
    public LocationDTO getLocation(String sessionTitle) {
        SessionDTO session = sessionDAO.getByTitle(sessionTitle);
        return locationDAO.get(session.getUid());
    }

    @Override
    public void patchLocation(LocationDTO location) throws SessionNotFoundException {
        if(!locationDAO.update(location.getLatitude(), location.getLongitude(), location.getSessionUid())) {
            throw new SessionNotFoundException("the session is not found");
        }
    }
}
