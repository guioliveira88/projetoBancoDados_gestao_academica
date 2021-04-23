package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestaoAcademica.Aluno;
import GestaoAcademica.Universidade;
import br.com.tabelasProjeto.dao.AlunoDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CriarUniversidade extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarUniversidade frame = new CriarUniversidade();
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
	public CriarUniversidade() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(118, 110, 306, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Gest\u00E3o Acad\u00EAmica");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(118, 11, 186, 40);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textField.getText();
				Universidade u = Universidade.getInstance();
				u.setNome(nome);
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(166, 201, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblInstitui = new JLabel("Local de Ensino:");
		lblInstitui.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblInstitui.setBounds(0, 113, 120, 14);
		contentPane.add(lblInstitui);
	}
}
