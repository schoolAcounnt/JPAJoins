package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class PetClass {
	@Id
	@GeneratedValue
	private int id;
	private String animal;
	private String name;
	public PetClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PetClass(int id, String animal, String name) {
		super();
		this.id = id;
		this.animal = animal;
		this.name = name;
	}
	public PetClass(String animal, String name) {
		super();
		this.animal = animal;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PetClass [id=" + id + ", animal=" + animal + ", name=" + name + "]";
	}
	
	
}
