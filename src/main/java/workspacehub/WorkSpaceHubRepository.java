package workspacehub;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WorkSpaceHubRepository extends CrudRepository<WorkspaceHub, Long> {

	List<WorkspaceHub> findByParking(Parking parking);

	List<WorkspaceHub> findByCost(Cost cost);

	List<WorkspaceHub> findByCostAndParking(Cost cost, Parking parking);

	Collection<WorkspaceHub> findBySpaceTypeOrderByDisplayNameAsc(SpaceType spacetype);

}
