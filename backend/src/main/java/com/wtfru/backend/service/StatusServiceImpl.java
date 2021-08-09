package com.wtfru.backend.service;

import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusDAO statusDAO;
    @Autowired
    SessionDAO sessionDAO;

    @Override
    @Transactional
    public void putStatus(Map<String, String> request) {
        if(!statusDAO.update(request.get("uid"), request.get("status"))) {
            throw SessionNotFoundException;
        }
    }

    @Override
    public SessionDTO getStatus(Map<String, String> request) {
        return sessionDAO.get(request.get("uid"));
    }
}
