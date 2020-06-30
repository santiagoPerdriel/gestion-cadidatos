package ar.com.possumus.gestionempleado.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL")
public class Skill implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4804630660151029434L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String  timeUse;
	
	private String technology;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	/**
	 * @return the timeUse
	 */
	public String getTimeUse() {
		return timeUse;
	}

	/**
	 * @param timeUse the timeUse to set
	 */
	public void setTimeUse(String timeUse) {
		this.timeUse = timeUse;
	}


	

}
