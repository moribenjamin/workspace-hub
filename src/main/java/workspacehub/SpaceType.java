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
	private String spaceImageUrl;
	
	@OneToMany(mappedBy = "spaceType")
	private Set<WorkspaceHub> workspaceHubs;
	
	protected SpaceType() {}
	
	public SpaceType (String spaceTitle, String spaceImageUrl) {
		this.spaceTitle = spaceTitle;
		this.spaceImageUrl = spaceImageUrl;
	}

	public Long getSpaceTypeId() {
		return spaceTypeId;
	}

	public String getSpaceTitle() {
		return spaceTitle;
	}
	public String getSpaceImageUrl() {
		return spaceImageUrl;
	}

	public Set<WorkspaceHub> getWorkspaceHubs() {
		return workspaceHubs;
	}

	@Override
	public String toString() {
		return String.format("SpaceType[spaceTitle='%s', spaceImageUrl='%s', workspaceHubs='%s']", spaceTitle, spaceImageUrl, workspaceHubs);
	}
}
