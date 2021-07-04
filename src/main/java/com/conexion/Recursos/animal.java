package com.conexion.Recursos;

public class animal extends serVivo {

	protected String apodo, tipo, raza, peso, tipoSangre, fechaNacimiento, fechaFueAgregado;
	protected int idUsuario;
	protected String idAnimal;

	public animal() {
	}

	public animal(String apo, String tip, String raz, String pes, String tipSan, String fechNac, int idUsu) {
		super();
		this.apodo = apo;
		this.tipo = tip;
		this.raza = raz;
		this.peso = pes;
		this.tipoSangre = tipSan;
		this.fechaNacimiento = fechNac;
		this.idUsuario = idUsu;
	}

	public String getFechaFueAgregado() {
		return fechaFueAgregado;
	}

	public void setFechaFueAgregado(String fechaFueAgregado) {
		this.fechaFueAgregado = fechaFueAgregado;
	}

	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		this.idAnimal = idAnimal;
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

	public String toString() {
		String str = this.apodo + "," + this.tipo + "," + this.raza + "," + this.peso + "," + this.tipoSangre + ","
				+ this.fechaNacimiento + "," + this.getIdUsuario();
		return str;
	}

}
