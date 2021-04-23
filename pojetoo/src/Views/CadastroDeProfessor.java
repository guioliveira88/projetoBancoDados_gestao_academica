package Views;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestaoAcademica.Aluno;
import GestaoAcademica.Disciplina;
import GestaoAcademica.Professor;
import br.com.tabelasProjeto.dao.AlunoDAO;
import br.com.tabelasProjeto.dao.ProfessorDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CadastroDeProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldIdade;
	private JTextField textFieldIdenficador;
	
	private JPasswordField passwordField;
	private JTextField textFieldCurso;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadrastroDeProfessor frame = new CadrastroDeProfessor();
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
	public CadastroDeProfessor(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProfessor = new JLabel(" Cadastro De Professor");
		lblCadastroDeProfessor.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblCadastroDeProfessor.setBounds(104, 11, 233, 14);
		contentPane.add(lblCadastroDeProfessor);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNome.setBounds(62, 48, 65, 14);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("CPF   :");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setBounds(62, 73, 56, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Idade:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(62, 98, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMatricula = new JLabel("Indentificador: ");
		lblMatricula.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMatricula.setBounds(0, 125, 116, 14);
		contentPane.add(lblMatricula);
		
		JLabel lblNewLabel_2 = new JLabel("Curso   :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(55, 150, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(114, 46, 297, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(114, 71, 297, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(112, 96, 299, 20);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		textFieldIdenficador = new JTextField();
		textFieldIdenficador.setBounds(112, 123, 299, 20);
		contentPane.add(textFieldIdenficador);
		textFieldIdenficador.setColumns(10);
		
		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(114, 150, 297, 20);
		contentPane.add(textFieldCurso);
		textFieldCurso.setColumns(10);
		
	
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCPF.getText();
 				String idade = textFieldIdade.getText();
 				String nome = textFieldNome.getText();
				String identificador = textFieldIdenficador.getText();
			    String curso = textFieldCurso.getText(); 
			
			Professor p = new Professor(cpf, Integer.parseInt(idade),nome, identificador,curso);
				professores.add(p);
				ProfessorDAO professorDao = new ProfessorDAO();
				p.getCpf();
				p.getIdade();
				p.getNome();
				p.getIdentificador();
				p.getCurso();
				professorDao.save(p);
				
				for(Professor p1 : professorDao.getProfessores()) {
					System.err.println("Professor:" + p1.getNome());;
				}
				new GerirProfessor(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(93, 181, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" <<Voltar >>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerirProfessor(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(248, 181, 99, 23);
		contentPane.add(btnNewButton_1);
		
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public CadastroDeProfessor(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas,Professor p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeProfessor = new JLabel(" Cadastro De Professor");
		lblCadastroDeProfessor.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblCadastroDeProfessor.setBounds(104, 11, 233, 14);
		contentPane.add(lblCadastroDeProfessor);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNome.setBounds(62, 48, 65, 14);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("CPF   :");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setBounds(62, 73, 56, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Idade:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(62, 98, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMatricula = new JLabel("Indentificador : ");
		lblMatricula.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblMatricula.setBounds(2, 125, 116, 14);
		contentPane.add(lblMatricula);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(114, 46, 297, 20);
		textFieldNome.setText(p.getNome());
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(114, 71, 297, 20);
		textFieldCPF.setText(p.getCpf());
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(112, 96, 299, 20);
		textFieldIdade.setText(String.valueOf(p.getIdade()));
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		textFieldIdenficador = new JTextField();
		textFieldIdenficador.setBounds(112, 123, 299, 20);
		textFieldIdenficador.setText(p.getIdentificador());
		contentPane.add(textFieldIdenficador);
		textFieldIdenficador.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < professores.size(); i++) {
					if(professores.get(i).getIdentificador() == p.getIdentificador()) {
						professores.remove(i);
					}
					
				}
				String nome = textFieldNome.getText();
 				String idade = textFieldIdade.getText();
 				String cpf = textFieldCPF.getText();
 				String identificador = textFieldIdenficador.getText();
			 
		        
		        ProfessorDAO professorDao = new ProfessorDAO();
				p.setNome(nome);
				p.setCpf(cpf);
				p.setIdade(Integer.parseInt(idade));
				p.setIdentificador(identificador);
			    professores.add(p);
				try {
					professorDao.alterar(p);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new GerirProfessor(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(138, 181, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" <<Voltar >>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerirProfessor(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(248, 181, 99, 23);
		contentPane.add(btnNewButton_1);
		
	
		
	}
}

