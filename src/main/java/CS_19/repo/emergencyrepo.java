package CS_19.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CS_19.Entity.EmergencyLocation;

@Repository
public interface emergencyrepo extends JpaRepository<EmergencyLocation,Integer> {
}
