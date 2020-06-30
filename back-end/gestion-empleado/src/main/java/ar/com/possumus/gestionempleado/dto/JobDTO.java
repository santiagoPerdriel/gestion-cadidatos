/**
 * 
 */
package ar.com.possumus.gestionempleado.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author santiago
 *
 */
public class JobDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4861697692132444824L;

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
