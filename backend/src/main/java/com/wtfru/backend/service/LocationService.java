package com.wtfru.backend.service;

import com.wtfru.backend.dto.LocationDTO;
import com.wtfru.backend.exception.DataIOException;

public interface LocationService {
    public LocationDTO postLocation(LocationDTO location);

    public LocationDTO getLocation(String sessionUid);

    public void patchLocation(LocationDTO location) throws DataIOException.SessionNotFoundException;
}
