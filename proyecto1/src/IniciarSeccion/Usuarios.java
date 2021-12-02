package IniciarSeccion;

public class Usuarios {

	private String Nombre;
	private String Apellido;
	private String Usuario;
	private String Email;
	private String Contrase�a;
	private String Telefono;

	public Usuarios(String nombre, String apellido, String usuario, String email, String contrase�a, String telefono) {
		Nombre = nombre;
		Apellido = apellido;
		Usuario = usuario;
		Email = email;
		Contrase�a = contrase�a;
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

	public String getContrase�a() {
		return Contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

}
