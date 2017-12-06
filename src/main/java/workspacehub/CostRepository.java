package workspacehub;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CostRepository extends CrudRepository<Cost, Long> {

	List<WorkspaceHub> findByCost(String cost);
}
