package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoLocationRepository {
    private Map<Long, Location> locations;

    public InMemoLocationRepository() {
        locations = new HashMap<>();
        for (int i=0; i<5; i++) {
            locations.put((long)1000+i, new Location((long)1000+i, String.format("Name%d", i), String.format("Address%d", i), String.format("Capacity%d", i), String.format("Description%d", i)));
        }
    }
    public Map<Long,Location> findAll() {
        return locations;
    }
}
