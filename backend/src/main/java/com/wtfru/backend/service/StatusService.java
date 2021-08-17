package com.wtfru.backend.service;

import com.wtfru.backend.exception.*;
import com.wtfru.backend.dto.SessionDTO;

public interface StatusService {
    public void putStatus(SessionDTO session) throws DataIOException.SessionNotFoundException;
    public SessionDTO getStatus(SessionDTO session);
}
