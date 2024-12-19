package mk.ukim.finki.lab.repository.jpa;

import mk.ukim.finki.lab.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAll();
}
