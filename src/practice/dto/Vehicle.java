package practice.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany(mappedBy="vehicles")	//only one table mapping
	private Collection<UserDetails> users=new ArrayList<UserDetails>();
	

	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Collection<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}
	public void connectVehicleToUser(UserDetails user){
		this.getUsers().add(user);
		user.getVehicles().add(this);
	}
}
