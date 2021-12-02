package IniciarSeccion;

public class Usuarios {

	private String Nombre;
	private String Apellido;
	private String Usuario;
	private String Email;
	private String Contraseña;
	private String Telefono;

	public Usuarios(String nombre, String apellido, String usuario, String email, String contraseña, String telefono) {
		Nombre = nombre;
		Apellido = apellido;
		Usuario = usuario;
		Email = email;
		Contraseña = contraseña;
		Telefono = telefono;
	}

	public Usuarios() {
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

}
