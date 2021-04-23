package Views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestaoAcademica.Aluno;
import GestaoAcademica.Disciplina;
import GestaoAcademica.Professor;
import br.com.tabelasProjeto.dao.DisciplinaDAO;
import br.com.tabelasProjeto.dao.ProfessorDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class CadastroDeDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCargahoraria;
	private JTextField textFieldId;
	private JTextField textFieldIdprofessor;
	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeDisciplina frame = new CadastroDeDisciplina();
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
	 * @wbp.parser.constructor
	 */
	public CadastroDeDisciplina(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		lblCadastroDeDisciplina.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblCadastroDeDisciplina.setBounds(88, 11, 225, 23);
		contentPane.add(lblCadastroDeDisciplina);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(68, 62, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carga Hor\u00E1ria:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 87, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(88, 114, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID Professor:");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(25, 139, 104, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(124, 60, 259, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCargahoraria = new JTextField();
		textFieldCargahoraria.setBounds(124, 85, 259, 20);
		contentPane.add(textFieldCargahoraria);
		textFieldCargahoraria.setColumns(10);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(124, 112, 259, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldIdprofessor = new JTextField();
		textFieldIdprofessor.setBounds(124, 139, 259, 20);
		contentPane.add(textFieldIdprofessor);
		textFieldIdprofessor.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome  = textFieldNome.getText();
				String cargahoraria = textFieldCargahoraria.getText();
				String id = textFieldId.getText();
				String id_professor = textFieldIdprofessor.getText();
				
				
				Disciplina d = new Disciplina(nome, cargahoraria,id,id_professor);
				disciplinas.add(d);
				DisciplinaDAO disciplinaDao = new DisciplinaDAO();
				d.getId();
				d.getId_professor();
				d.getNome();
				d.getCargahoraria();
				disciplinaDao.save(d);
				
				for(Disciplina d1 : disciplinaDao.getDisciplina()) {
					System.err.println("Disciplina:" + d1.getNome());;
				}
				new GerirDisciplina(alunos,professores,disciplinas).setVisible(true);;
				dispose();
			}
		});
		btnNewButton.setBounds(98, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<Voltar>>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerirDisciplina(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(242, 209, 100, 23);
		contentPane.add(btnNewButton_1);
				
		
	}
	public CadastroDeDisciplina(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas,Disciplina d) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		lblCadastroDeDisciplina.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblCadastroDeDisciplina.setBounds(88, 11, 225, 23);
		contentPane.add(lblCadastroDeDisciplina);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 97, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carga Hor\u00E1ria:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel_1.setBounds(0, 155, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(88, 114, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID Professor:");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(25, 139, 104, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(133, 95, 259, 20);
		textFieldNome.setText(d.getNome());
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCargahoraria = new JTextField();
		textFieldCargahoraria.setBounds(133, 153, 259, 20);
		textFieldCargahoraria.setText(d.getCargahoraria());
		contentPane.add(textFieldCargahoraria);
		textFieldCargahoraria.setColumns(10);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(124, 112, 259, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldIdprofessor = new JTextField();
		textFieldIdprofessor.setBounds(124, 139, 259, 20);
		contentPane.add(textFieldIdprofessor);
		textFieldIdprofessor.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < disciplinas.size(); i++) {
					if(disciplinas.get(i).getNome() == d.getNome()) {
						disciplinas.remove(i);
					}
				}
				String nome  = textFieldNome.getText();
				String cargahoraria = textFieldCargahoraria.getText();
				String id = textFieldId.getText();
				String id_professor = textFieldIdprofessor.getText();
				
				 DisciplinaDAO disciplinaDao = new DisciplinaDAO();
					d.setNome(nome);
					d.setCargahoraria(cargahoraria);
					d.setId(id);
					d.setId_professor(id_professor);
				    disciplinas.add(d);
					try {
						disciplinaDao.alterar(d);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				new GerirDisciplina(alunos,professores,disciplinas).setVisible(true);;
				dispose();
			}
		});
		btnNewButton.setBounds(98, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<Voltar>>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerirDisciplina(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(242, 209, 100, 23);
		contentPane.add(btnNewButton_1);
	}
}

