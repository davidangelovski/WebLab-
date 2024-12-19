package mk.ukim.finki.lab.service.implementation;

import mk.ukim.finki.lab.model.Location;
import mk.ukim.finki.lab.repository.InMemoLocationRepository;
import mk.ukim.finki.lab.repository.jpa.LocationRepository;
import mk.ukim.finki.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImplementation implements LocationService {
//    private final InMemoLocationRepository inMemoLocationRepository;
      private final LocationRepository locationRepository;

    public LocationServiceImplementation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    @Override
    public Location findById(long locationId) {
        return locationRepository.findById(locationId).orElse(null);
    }
}
