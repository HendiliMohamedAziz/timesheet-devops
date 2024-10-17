package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "T_USER")
public class User implements Serializable {
	//this is modification comment
	//2eme modification

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;   
	
	private String firstName; 
	
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Enumerated(EnumType.STRING)
	Role role;

	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	
	public User() {	}

	public User(String firstName, String lastName, Date dateNaissance, Role role, Entreprise entreprise) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.entreprise = entreprise;
	}


	public User(Long id, String firstName, String lastName, Date dateNaissance, Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}

	public User(String firstName, String lastName, Date dateNaissance, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateNaissance="
				+ dateNaissance + ", role=" + role + "]";
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
}
