/**
 * 
 */
package ar.com.possumus.gestionempleado.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author santiago
 *
 */
public class CandidateLigthDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5040450641863009057L;


	private Long id;
		
	private String name;
	
	private String lastname;
	
	private String photo;
	
	private LocalDate birthdate;
	
	private String dni;
	
	
	private boolean iscv;
	
	private int random;
	
	private Set<SkillDTO> skills;
	
	
	

	/**
	 * @return the iscv
	 */
	public boolean isIscv() {
		return iscv;
	}

	/**
	 * @param iscv the iscv to set
	 */
	public void setIscv(boolean iscv) {
		this.iscv = iscv;
	}

	/**
	 * @return the random
	 */
	public int getRandom() {
		return random;
	}

	/**
	 * @param random the random to set
	 */
	public void setRandom(int random) {
		this.random = random;
	}


	/**
	 * @return the skills
	 */
	public Set<SkillDTO> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(Set<SkillDTO> skills) {
		this.skills = skills;
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	


}
