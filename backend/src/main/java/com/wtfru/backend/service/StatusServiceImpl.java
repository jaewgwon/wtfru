package com.wtfru.backend.service;

import com.wtfru.backend.dao.SessionDAO;
import com.wtfru.backend.dao.StatusDAO;
import com.wtfru.backend.exception.Exceptions;
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
    public void putStatus(SessionDTO session) throws Exceptions.SessionNotFoundException {
        if(!statusDAO.update(session.getUid(), session.getStatus())) {
            throw new Exceptions.SessionNotFoundException("the session is not found");
        }
    }

    @Override
    public SessionDTO getStatus(SessionDTO session) {
        return sessionDAO.getByUid(session.getUid());
    }
}
