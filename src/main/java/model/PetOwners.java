package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import model.PetClass;

@Entity
public class PetOwners {
	@Id
	@GeneratedValue
	private int id;
	private String owner;
	@OneToMany(fetch = FetchType.LAZY)
    private List<PetClass> petClasses;
	
	public PetOwners() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PetOwners(String owner, List<PetClass> petClass) {
		super();
		this.owner = owner;
		this.petClasses = petClass;
	}
	public PetOwners(String owner) {
		super();
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public List<PetClass> getPetClass() {
		return petClasses;
	}
	public void setPetClass(PetClass petClass) {
		this.petClasses = (List<PetClass>) petClass;
	}
	@Override
	public String toString() {
		return "PetOwners [id=" + id + ", owner=" + owner + ", petClass=" + petClasses + "]";
	}
	
	
}
