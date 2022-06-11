package com.this_project.dao;

import com.this_project.entity.Location;
import java.util.List;

public interface LocationDAO {
    void saveLocation(Location location);

    void updateLocation(Location location);

    void deleteLocation(Long id);

    List<Location> getLocationList();

    Location getLocationByName(String name);

    Location getLocationById(Long id);
}
