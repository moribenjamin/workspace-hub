package workspacehub;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ParkingRepository extends CrudRepository<Parking, Long> {

	List<WorkspaceHub> findByParking(String parking);

}
