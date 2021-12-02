package ventana;

import java.sql.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import IniciarSeccion.Real_login;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class login extends JFrame {

	private JPanel contentPane;
	public static JTable table;

	public static Connection con;
	public static PreparedStatement pst;
	public static ResultSet rs;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JTextField txtcontraseña;
	private JTextField txtBuscar;
	private JTextField txtTelefono;

	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/crudpractica", "root", "");
		} catch (ClassNotFoundException ex) {

			System.out.println("no found");
			// ex.printStackTrace();

		} catch (SQLException ex) {
			// ex.printStackTrace();
			// JOptionPane.showMessageDialog(null, "Excelente!!!!!");
			System.out.println("si found");
		}

	}

	
	/**
	 * Create the frame.
	 */

	public static void table_load() {
		try {
			pst = con.prepareStatement("select Nombre,Apellido,Usuario,Email,Contraseña,Telefono from usuarios");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public login() {
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CRUD de usuarios");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(155, 11, 169, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Personas Registradas");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(10, 42, 161, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.CYAN);
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 11));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Nombre, Apellido, Email, Telefono, Usuario, Contraseña;

				Nombre = txtNombre.getText();
				Apellido = txtApellido.getText();
				Email = txtEmail.getText();
				Telefono = txtTelefono.getText();
				Usuario = txtUsuario.getText();
				Contraseña = txtcontraseña.getText();
				try {
					pst = con.prepareStatement(
							"insert into usuarios(Nombre,Apellido,Usuario,Email,Contraseña,Telefono)values(?,?,?,?,?,?)");
					pst.setString(1, Nombre);
					pst.setString(2, Apellido);
					pst.setString(3, Usuario);
					pst.setString(4, Email);
					pst.setString(5, Contraseña);
					pst.setString(6, Telefono);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Usuario agregado!!!!!");
					table_load();

					txtNombre.setText("");
					txtApellido.setText("");
					txtUsuario.setText("");
					txtEmail.setText("");
					txtcontraseña.setText("");
					txtTelefono.setText("");
					txtNombre.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnAgregar.setBounds(10, 319, 89, 23);
		contentPane.add(btnAgregar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.CYAN);
		btnEditar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String bNombre, bApellido, bUsuario, bbuscar, bEmail, bContraseña, bTelefono;

				bNombre = txtNombre.getText();
				bApellido = txtApellido.getText();
				bUsuario = txtUsuario.getText();
				bbuscar = txtBuscar.getText();
				bEmail = txtEmail.getText();
				bContraseña = txtcontraseña.getText();
				bTelefono = txtTelefono.getText();

				try {
					pst = con.prepareStatement(
							"update usuarios set Nombre= ?,Apellido= ?,Usuario= ?,Email= ?,Contraseña= ?,Telefono= ? where Nombre = ?");
					pst.setString(1, bNombre);
					pst.setString(2, bApellido);
					pst.setString(3, bUsuario);
					pst.setString(4, bEmail);
					pst.setString(5, bContraseña);
					pst.setString(6, bTelefono);
					pst.setString(7, bbuscar);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Usuario editado !!!!!");
					table_load();

					txtNombre.setText("");
					txtApellido.setText("");
					txtUsuario.setText("");
					txtEmail.setText("");
					txtcontraseña.setText("");
					txtTelefono.setText("");
					txtBuscar.setText("");
					txtNombre.requestFocus();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}

		});
		btnEditar.setBounds(125, 319, 89, 23);
		contentPane.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.CYAN);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String bbuscar;

				bbuscar = txtBuscar.getText();

				try {
					pst = con.prepareStatement("delete from usuarios where Nombre =?");
					pst.setString(1, bbuscar);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Usuario Eliminado !!!!!");
					table_load();
					txtNombre.setText("");
					txtApellido.setText("");
					txtUsuario.setText("");
					txtEmail.setText("");
					txtcontraseña.setText("");
					txtTelefono.setText("");
					txtBuscar.setText("");
					txtNombre.requestFocus();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setBounds(235, 319, 89, 23);
		contentPane.add(btnEliminar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.CYAN);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salir();
			}
		});
		btnSalir.setFont(new Font("Arial", Font.BOLD, 11));
		btnSalir.setBounds(333, 319, 103, 23);
		contentPane.add(btnSalir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 446, 79);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		txtNombre = new JTextField();
		txtNombre.setBounds(85, 188, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(85, 232, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(85, 274, 86, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(278, 232, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtcontraseña = new JTextField();
		txtcontraseña.setBounds(278, 274, 86, 20);
		contentPane.add(txtcontraseña);
		txtcontraseña.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_2.setBounds(29, 191, 59, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_3.setBounds(29, 235, 59, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_4.setBounds(29, 277, 59, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_5.setBounds(195, 232, 59, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Contrase\u00F1a");
		lblNewLabel_6.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_6.setBounds(195, 274, 79, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Buscar por Nombre");
		lblNewLabel_7.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_7.setBounds(10, 152, 128, 14);
		contentPane.add(lblNewLabel_7);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(125, 147, 86, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.CYAN);
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 11));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				try {

					String Buscar = txtBuscar.getText();

					pst = con.prepareStatement(
							"select Nombre,Apellido,Usuario,Email,Contraseña,telefono from usuarios where Nombre = ?");
					pst.setString(1, Buscar);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String Nombre = rs.getString(1);
						String Apellido = rs.getString(2);
						String Usuario = rs.getString(3);
						String Email = rs.getString(4);
						String Contraseña = rs.getString(5);
						String telefono = rs.getString(6);

						txtNombre.setText(Nombre);
						txtApellido.setText(Apellido);
						txtUsuario.setText(Usuario);
						txtEmail.setText(Email);
						txtcontraseña.setText(Contraseña);
						txtTelefono.setText(telefono);

					} else {
						txtNombre.setText("");
						txtApellido.setText("");
						txtUsuario.setText("");
						txtEmail.setText("");
						txtcontraseña.setText("");
						txtTelefono.setText("");

					}

				} catch (SQLException ex) {

				}

			}
		});

		btnBuscar.setBounds(275, 147, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblNewLabel_8 = new JLabel("Telefono");
		lblNewLabel_8.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_8.setBounds(195, 191, 70, 14);
		contentPane.add(lblNewLabel_8);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(278, 188, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
	}

	protected void Salir() {
		JOptionPane.showMessageDialog(contentPane, "Usted a Cerrado Seccion");
		this.dispose();
		Real_login frame1 = new Real_login();
		frame1.setVisible(true);
		login frame = new login();
		login.Connect();
	}
}
