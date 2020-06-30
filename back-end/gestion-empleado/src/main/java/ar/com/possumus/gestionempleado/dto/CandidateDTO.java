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
public class CandidateDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5040450641863009057L;

	private Long id;
	

	private ContactDTO contact;
	
	
	private String cv;
	
	private Set<SkillDTO> skills;
	

	private Set<JobDTO> jobs;
	
	private String name;
	
	private String lastname;
	
	private String photo;
	
	private LocalDate birthdate;
	
	private String dni;
	
	



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
	 * @return the contact
	 */
	public ContactDTO getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(ContactDTO contact) {
		this.contact = contact;
	}

	/**
	 * @return the cv
	 */
	public String getCv() {
		return cv;
	}

	/**
	 * @param cv the cv to set
	 */
	public void setCv(String cv) {
		this.cv = cv;
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
	 * @return the jobs
	 */
	public Set<JobDTO> getJobs() {
		return jobs;
	}

	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(Set<JobDTO> jobs) {
		this.jobs = jobs;
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
