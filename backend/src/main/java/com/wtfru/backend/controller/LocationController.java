package com.wtfru.backend.controller;

import com.wtfru.backend.dao.SessionDAO;
import com.wtfru.backend.exception.DataIOException.*;
import com.wtfru.backend.service.LocationService;
import com.wtfru.backend.dto.LocationDTO;
import com.wtfru.backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/session")
public class LocationController {
    @Autowired
    LocationService locationService;
    @Autowired
    TokenService tokenService;

    @PostMapping(value = "/location", produces = "application/json; charset=utf-8")
    public ResponseEntity postLocation(HttpServletRequest servletRequest, @RequestBody Map<String, String> request) {
        String jwt = tokenService.resolveToken(servletRequest);
        String sessionTitle = tokenService.decodeToken(jwt);

        LocationDTO location = new LocationDTO();
        location.setLatitude(Double.parseDouble(request.get("latitude")));
        location.setLongitude(Double.parseDouble(request.get("longitude")));

        LocationDTO result;
        try {
            result = locationService.postLocation(sessionTitle,location);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The session is not found");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/location", produces = "application/json; charset=utf-8")
    public ResponseEntity getLocation(HttpServletRequest request) {
        LocationDTO result;
        String jwt = tokenService.resolveToken(request);

        try {
            result = locationService.getLocation(tokenService.decodeToken(jwt));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The location is not found");
        }

        return ResponseEntity.ok(result);
    }

    @PatchMapping(value = "/location", produces = "application/json; charset=utf-8")
    public ResponseEntity patchLocation(@RequestBody Map<String, String> request) {
        LocationDTO location = new LocationDTO();
        location.setSessionUid(request.get("uid"));
        location.setLatitude(Double.parseDouble(request.get("latitude")));
        location.setLongitude(Double.parseDouble(request.get("longitude")));

        try {
            locationService.patchLocation(location);
        }catch (SessionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error: The session is not found");
        }

        return ResponseEntity.ok("message: The location has been updated");
    }
}
