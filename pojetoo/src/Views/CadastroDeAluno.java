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

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastroDeAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMatricula;
	private JTextField textFieldIdade;
	private JTextField textFieldCPF;
	
	private JTextField textFieldCurso;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeAluno frame = new CadastroDeAluno();
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
	public CadastroDeAluno(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadrastro = new JLabel("Cadrastro de Aluno");
		lblCadrastro.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblCadrastro.setBounds(122, 21, 198, 19);
		contentPane.add(lblCadrastro);
		
		JLabel lblNewLabel = new JLabel("Nome:  ");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setBounds(42, 67, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" CPF:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(52, 98, 39, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(42, 136, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matricula:");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_3.setBounds(14, 168, 75, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(109, 65, 248, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(109, 166, 248, 20);
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldNome.getText();
				String cpf = textFieldCPF.getText();
				String idade = textFieldIdade.getText();
				String matricula = textFieldMatricula.getText();
				String curso = textFieldCurso.getText();
				
				Aluno a = new Aluno(matricula, cpf,Integer.parseInt(idade), nome,curso);
				alunos.add(a);
				AlunoDAO alunoDao = new AlunoDAO();
				a.getMatricula();
				a.getCpf();
				a.getIdade();
				a.getNome();
				a.getCurso();
				alunoDao.save(a);
				for(Aluno a1 : alunoDao.getAlunos()) {
					System.err.println("Aluno:" + a1.getNome());;
				}
				
				new GerirAlunos(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_2.setBounds(109, 227, 113, 23);
		contentPane.add(btnNewButton_2);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(109, 134, 248, 20);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(109, 96, 248, 20);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JButton btnNewButton = new JButton("<<Voltar>>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerirAlunos(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setBounds(244, 227, 113, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(45, 193, 46, 14);
		contentPane.add(lblCurso);
		
		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(109, 190, 248, 20);
		contentPane.add(textFieldCurso);
		textFieldCurso.setColumns(10);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public CadastroDeAluno(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas,Aluno a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadrastro = new JLabel("Cadrastro de Aluno");
		lblCadrastro.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblCadrastro.setBounds(122, 21, 198, 19);
		contentPane.add(lblCadrastro);
		
		JLabel lblNewLabel = new JLabel("Nome:  ");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setBounds(42, 67, 57, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" CPF:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(52, 98, 39, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_2.setBounds(42, 136, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Matricula:");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_3.setBounds(14, 168, 75, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(109, 65, 248, 20);
		textFieldNome.setText(a.getNome());
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldMatricula = new JTextField();
		textFieldMatricula.setBounds(109, 166, 248, 20);
		textFieldMatricula.setText(a.getMatricula());
		contentPane.add(textFieldMatricula);
		textFieldMatricula.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < alunos.size(); i++) {
					if(alunos.get(i).getNome()== a.getNome()) {
						alunos.remove(i);
					}
				}
				String nome = textFieldNome.getText();
				String cpf = textFieldCPF.getText();
				String idade = textFieldIdade.getText();
				String matricula = textFieldMatricula.getText();
				String curso = textFieldCurso.getText();
				AlunoDAO alunoDao = new AlunoDAO();
				a.setNome(nome);
				a.setCpf(cpf);
				a.setIdade(Integer.parseInt(idade));
				a.setMatricula(matricula);
				a.setCurso(curso);
				
				alunos.add(a);
				try {
					alunoDao.alterar(a);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new GerirAlunos(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
				
				
		});
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_2.setBounds(109, 227, 113, 23);
		contentPane.add(btnNewButton_2);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(109, 134, 248, 20);
		textFieldIdade.setText(String.valueOf(a.getIdade()));
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(109, 96, 248, 20);
		textFieldCPF.setText(a.getCpf());
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JButton btnNewButton = new JButton("<<Voltar>>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerirAlunos(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setBounds(244, 227, 113, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(45, 193, 46, 14);
		contentPane.add(lblCurso);
		
		textFieldCurso = new JTextField();
		textFieldCurso.setBounds(109, 190, 248, 20);
		textFieldCurso.setText(a.getCurso());
		contentPane.add(textFieldCurso);
		textFieldCurso.setColumns(10);
	}
}
