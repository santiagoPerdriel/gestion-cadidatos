/**
 * 
 */
package ar.com.possumus.gestionempleado.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author santiago
 *
 */
@Entity
@Table(name = "JOB")
public class Job implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 836216173030109264L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nameCompany;
	
	private LocalDate startCompany;
	
	private LocalDate finishCompoany;

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
	 * @return the nameCompany
	 */
	public String getNameCompany() {
		return nameCompany;
	}

	/**
	 * @param nameCompany the nameCompany to set
	 */
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	/**
	 * @return the startCompany
	 */
	public LocalDate getStartCompany() {
		return startCompany;
	}

	/**
	 * @param startCompany the startCompany to set
	 */
	public void setStartCompany(LocalDate startCompany) {
		this.startCompany = startCompany;
	}

	/**
	 * @return the finishCompoany
	 */
	public LocalDate getFinishCompoany() {
		return finishCompoany;
	}

	/**
	 * @param finishCompoany the finishCompoany to set
	 */
	public void setFinishCompoany(LocalDate finishCompoany) {
		this.finishCompoany = finishCompoany;
	}
	
	
	

}
