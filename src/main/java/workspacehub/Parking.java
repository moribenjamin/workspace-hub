package workspacehub;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parking {
	@Id
	@GeneratedValue
	private Long parkingId;

	private String parkingTitle;
	
	@OneToMany(mappedBy = "parking")
	private Set<WorkspaceHub> workspaceHubs;
	
	protected Parking() {}
	
	public Parking( String parkingTitle ) {
		this.parkingTitle = parkingTitle;
	}

	public Long getParkingId() {
		return parkingId;
	}

	public String getParkingTitle() {
		return parkingTitle;
	}

	public Set<WorkspaceHub> getWorkspaceHubs() {
		return workspaceHubs;
	}
	@Override
	public String toString() {
		return String.format("Parking[parkingTitle='%s']", parkingTitle);
	}
}


