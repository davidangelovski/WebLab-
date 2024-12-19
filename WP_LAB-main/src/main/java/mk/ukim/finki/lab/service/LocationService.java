package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> findAll();
    Location findById(long id);
}
