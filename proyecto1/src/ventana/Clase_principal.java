package ventana;

import IniciarSeccion.Real_login;

public class Clase_principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Real_login frame1 = new Real_login();
		frame1.setVisible(true);
		login frame = new login();
		login.Connect();
		
		/*try {
			login frame = new login();
			frame.setVisible(true);
			login.Connect();
			login.table_load();
			
		} catch (Exception e) {
			e.printStackTrace();
		}**/
	}

}
