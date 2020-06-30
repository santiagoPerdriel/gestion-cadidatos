/**
 * 
 */
package ar.com.possumus.gestionempleado.dto;

import java.io.Serializable;

/**
 * @author santiago
 *
 */
public class ContactDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6889090087889234731L;

	private Long id;
	
	private String mail;
	
	private String telefono;

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
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	

}
