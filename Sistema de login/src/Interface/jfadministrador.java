package Interface;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.DAO;
import javax.swing.JPasswordField;

public class jfadministrador extends JFrame {

	private JPanel contentPane;
	DAO dao = new DAO();
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
	public jfadministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 364);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><center>Bem vindo!<br>Administrador</center></html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(167, 11, 256, 70);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 574, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Cadastro de usuários</center></html>");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(178, 105, 238, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsurio.setBounds(12, 167, 59, 20);
		contentPane.add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(70, 169, 210, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(296, 11, 1, 284);
		contentPane.add(verticalStrut);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setBounds(279, 202, 36, 1);
		contentPane.add(horizontalGlue);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(316, 167, 59, 20);
		contentPane.add(lblSenha);
		
		JLabel lblTipoDeConta = new JLabel("Tipo de conta:");
		lblTipoDeConta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeConta.setBounds(66, 223, 110, 20);
		contentPane.add(lblTipoDeConta);
		
		JRadioButton rdbtnAdministrativo = new JRadioButton("Administrativa");
		rdbtnAdministrativo.setSelected(true);
		rdbtnAdministrativo.setBounds(242, 223, 109, 23);
		contentPane.add(rdbtnAdministrativo);
		
		JRadioButton rdbtnPadro = new JRadioButton("Padrão");
		rdbtnPadro.setSelected(true);
		rdbtnPadro.setBounds(417, 224, 109, 23);
		contentPane.add(rdbtnPadro);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnPadro);
		grupo.add(rdbtnAdministrativo);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = null;
				if(rdbtnPadro.isSelected()) {
					tipo = "P";
				}
				if(rdbtnAdministrativo.isSelected()) {
					tipo = "A";
				}
				dao.addUsuario(txtUsuario.getText(), txtSenha.getText(), tipo);
				JOptionPane.showMessageDialog(null, "<html><center>Usuário cadastrado com sucesso!</center></html>", "Sucesso", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		btnCadastrar.setBounds(236, 273, 121, 41);
		contentPane.add(btnCadastrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(362, 170, 210, 18);
		contentPane.add(txtSenha);
		


	}
}
