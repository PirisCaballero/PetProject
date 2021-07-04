package com.eVida.Recursos;

public class animal extends serVivo {
	
	protected String apodo , tipo , raza , peso , tipoSangre , fechaNacimiento;
	protected int idUsuario;
	
	public animal( String apo , String tip , String raz , String pes , String tipSan , String fechNac , int idUsu) {
		super();
		this.apodo = apo;
		this.tipo = tip;
		this.raza = raz;
		this.peso = pes;
		this.tipoSangre = tipSan;
		this.fechaNacimiento = fechNac;
		this.idUsuario = idUsu;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

}
