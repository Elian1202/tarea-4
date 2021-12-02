package IniciarSeccion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Registro.Registrar;
import ventana.login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class Real_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Real_login frame = new Real_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}**/

	/**
	 * Create the frame.
	 */
	public Real_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(35, 71, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(35, 107, 99, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(132, 68, 114, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar Seccion");
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 12));
		btnIniciar.setBackground(Color.CYAN);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIniciar.setBounds(132, 156, 132, 23);
		contentPane.add(btnIniciar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrarse.setBackground(Color.CYAN);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registrar();
			}
		});
		btnRegistrarse.setBounds(132, 190, 132, 23);
		contentPane.add(btnRegistrarse);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(132, 104, 114, 20);
		contentPane.add(txtContraseña);
		
		JLabel lblNewLabel_2 = new JLabel("Iniciar Seccion");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(119, 22, 145, 20);
		contentPane.add(lblNewLabel_2);
	}

	protected void Registrar() {
		this.dispose();
		login.Connect();
		Registrar frame = new Registrar();
		frame.setVisible(true);
	}

	protected void ingresar() {
		
		String usuario = txtUsuario.getText();
		String contraseña = String.valueOf(txtContraseña.getPassword());
		
		if(txtUsuario.getText().isEmpty() ){
			
			JOptionPane.showMessageDialog(contentPane, "Debe completar todos los datos", "Error",JOptionPane.ERROR_MESSAGE);

	}else {
		if(String.valueOf(txtContraseña.getPassword()).isEmpty()) {
			
			JOptionPane.showMessageDialog(contentPane, "Debe completar todos los datos", "Error",JOptionPane.ERROR_MESSAGE);
		}
		else {

			
			GestionUsuario gestionusuario = new GestionUsuario();
			
			Usuarios usuario2 = new Usuarios();
			usuario2.setUsuario(usuario);
			usuario2.setContraseña(contraseña);
			
			Usuarios usu = gestionusuario.obtenerUsuario(usuario2);
			
			if(usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			this.dispose();
			login frame = new login();
			frame.setVisible(true);
			login.Connect();
			login.table_load();
			}else
			{
				JOptionPane.showMessageDialog(contentPane, "Datos Invalidos", "Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
	}
}
