package com.proyecto.app.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Table;

@Access(AccessType.FIELD)
@Entity
@Table(name="user")
public class usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7580930226520065448L;
		@Id
		private int id;
		private int username;
		private int password;

}
