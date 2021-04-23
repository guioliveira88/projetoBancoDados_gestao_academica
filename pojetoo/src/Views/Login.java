package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestaoAcademica.Aluno;
import GestaoAcademica.Disciplina;
import GestaoAcademica.Professor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	private ArrayList<Aluno> alunos = new ArrayList<>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   */
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Usu\u00E1rios");
		lblUser.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblUser.setBounds(151, 11, 146, 58);
		contentPane.add(lblUser);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 91, 87, 28);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 130, 46, 14);
		contentPane.add(label);
		
		JLabel lblSenha = new JLabel(" senha:");
		lblSenha.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblSenha.setBounds(10, 140, 87, 28);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(99, 97, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 146, 224, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("admin") && textField_1.getText().equals("1234")) {
					new MenuGestao(alunos, professores, disciplinas).setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Erro");
				}
				
			}
		});
		btnNewButton.setBounds(99, 205, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("<<voltar>>");
		button.setBounds(234, 205, 100, 23);
		contentPane.add(button);
	}
}
