package com.wtfru.backend.service;

import com.wtfru.backend.dao.SessionDAO;
import com.wtfru.backend.dao.StatusDAO;
import com.wtfru.backend.dto.SessionDTO;
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
    public void putStatus(Map<String, String> request) throws Exceptions.SessionNotFoundException {
        if(!statusDAO.update(request.get("uid"), Integer.parseInt(request.get("status")))) {
            throw new Exceptions.SessionNotFoundException("the session is not found");
        }
    }

    @Override
    public SessionDTO getStatus(Map<String, String> request) {
        return sessionDAO.getByUid(request.get("uid"));
    }
}