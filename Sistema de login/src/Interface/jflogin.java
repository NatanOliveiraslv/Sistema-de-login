package Interface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.DAO;
import javax.swing.JPasswordField;


public class jflogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	DAO dao = new DAO();
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Windows".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException| javax.swing.UnsupportedLookAndFeelException ex) {
		            System.err.println(ex);}
				try {
					jflogin frame = new jflogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jflogin() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Login");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 210);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUsuario = new JLabel("Usuario:");
		lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbUsuario.setBounds(28, 31, 50, 17);
		contentPane.add(lbUsuario);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSenha.setBounds(35, 74, 43, 17);
		contentPane.add(lbSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(90, 31, 232, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfadministrador administrador = new jfadministrador();
				jfpadrao padrao = new jfpadrao();
				
				String usuario = txtUsuario.getText();
				@SuppressWarnings("deprecation")
				String senha = txtSenha.getText();
				try {
				if(dao.logar(usuario, senha).equals("A")) {
					administrador.setVisible(true);
					dispose();
				}
				if(dao.logar(usuario, senha).equals("P")) {
					padrao.setVisible(true);
					dispose();
				}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorreto(s)", "Alerta", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btEntrar.setBounds(90, 114, 79, 23);
		contentPane.add(btEntrar);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btSair.setBounds(191, 114, 79, 23);
		contentPane.add(btSair);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(90, 74, 232, 20);
		contentPane.add(txtSenha);
		


	}
}
