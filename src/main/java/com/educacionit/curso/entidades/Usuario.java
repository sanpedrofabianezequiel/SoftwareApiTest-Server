package com.educacionit.curso.entidades;
import java.io.Serializable;

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String correo;
	private String clave;
	private Boolean Activo;
	
	public Usuario() {}
	
	public Usuario(String correo, String clave, Boolean activo) {
		super();
		this.correo = correo;
		this.clave = clave;
		Activo = activo;
	}
	
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", clave=" + clave + ", Activo=" + Activo + "]";
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Boolean getActivo() {
		return Activo;
	}
	public void setActivo(Boolean activo) {
		Activo = activo;
	}
	

}
