package com.wtfru.backend.controller;

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
    public ResponseEntity postLocation(@RequestBody Map<String, String> request) {
        LocationDTO location = new LocationDTO();
        location.setLatitude(Double.parseDouble(request.get("latitude")));
        location.setLongitude(Double.parseDouble(request.get("longitude")));
        LocationDTO result;

        result = locationService.postLocation(location);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/location", produces = "application/json; charset=utf-8")
    public ResponseEntity getLocation(HttpServletRequest request) {
        LocationDTO location = new LocationDTO();
        location.setLocationId();
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
