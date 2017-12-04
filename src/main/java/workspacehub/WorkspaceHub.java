package workspacehub;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WorkspaceHub {

@Id
@GeneratedValue
private Long id;

private String name;
private String imageUrl;
@Lob
private String description;

@ManyToOne
private SpaceType spaceType;

@ManyToMany
private Set<Feature> features;

//@OneToOne
//private Address address;

private String address;

private String email;

private String phoneNumber;
private String website;
private String facebook;
private String twitter;

@ManyToOne
private Hours hours;
@ManyToOne
private Parking parking;
@ManyToOne
private Cost cost;
@ManyToOne
private Capacity capacity;


protected WorkspaceHub() {}

public WorkspaceHub(String name, String imageUrl, String email,String website, String facebook, String twitter, String address, String phoneNumber, String description, SpaceType spaceType, Hours hours,  Parking parking, Cost cost, Capacity capacity, Feature... features) {
	this.name = name;
	this.imageUrl = imageUrl;
	this.description = description;
	this.spaceType= spaceType;
	this.hours = hours;
	this.email = email;
	this.facebook = facebook;
	this.twitter = twitter;
	this.phoneNumber = phoneNumber;
	this.website = website;
	this.address = address;
	this.parking = parking;
	this.cost= cost;
	this.capacity = capacity;
	this.features = new HashSet<Feature>(Arrays.asList(features));
}

public Long getId() {
	return id;
}

public String getName() {
	return name;
}
public String getImageUrl() {
	return imageUrl;
}

public String getDescription() {
	return description;
}

public SpaceType getSpaceType() {
	return spaceType;
}

public Set<Feature> getFeatures() {
	return features;
}

public Hours getHours() {
	return hours;
}

public Parking getParking() {
	return parking;
}

public Cost getCost() {
	return cost;
}

public Capacity getCapacity() {
	return capacity;
}

public String getAddress() {
	return address;
}

public String getEmail() {
	return email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public String getWebsite() {
	return website;
}

public String getFacebook() {
	return facebook;
}

public String getTwitter() {
	return twitter;
}

public boolean isSpaceOpen(Hours hour) {
	LocalTime now = LocalTime.now();
	LocalDate date = LocalDate.now();
	String currentDay = date.getDayOfWeek()+"";
	if(hour.getHoursTitle().contains(currentDay)) {
		return true;
		}
	return false;
}
@Override
public String toString() {
	return String.format("WorkspaceHub[name='%s', imageUrl='%s', description='%s', spaceType='%s',features='%s', hours='%s', parking='%s', cost='%s',capacity='%s',email='%s',address='%s'phoneNumber='%s',website='%s']", name, imageUrl,
			description, spaceType, features, hours, parking, cost, capacity,email,address,phoneNumber,website, facebook, twitter);
}
}
