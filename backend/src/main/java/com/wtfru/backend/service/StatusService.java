package com.wtfru.backend.service;

import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface StatusService {
    public void putStatus(@RequestBody Map<String, String> request);
    public SessionDTO getStatus(@RequestBody Map<String, String> request);
}
