package workspacehub;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SpaceType {

	@Id
	@GeneratedValue
	private Long spaceTypeId;

	private String spaceTitle;
	
	@OneToMany(mappedBy = "spaceType")
	private Set<WorkspaceHub> workspaceHubs;
	
	protected SpaceType() {}
	
	public SpaceType (String spaceTitle) {
		this.spaceTitle = spaceTitle;
	}

	public Long getSpaceTypeId() {
		return spaceTypeId;
	}

	public String getSpaceTitle() {
		return spaceTitle;
	}

	public Set<WorkspaceHub> getWorkspaceHubs() {
		return workspaceHubs;
	}

	@Override
	public String toString() {
		return String.format("SpaceType[spaceTitle='%s', workspaceHubs='%s']", spaceTitle, workspaceHubs);
	}
}
