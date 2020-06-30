/**
 * 
 */
package ar.com.possumus.gestionempleado.dto;

import java.io.Serializable;

/**
 * @author santiago
 *
 */
public class SkillDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4628205980467054978L;

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
	
	

}
