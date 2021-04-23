package Views;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import GestaoAcademica.Aluno;
import GestaoAcademica.Disciplina;
import GestaoAcademica.Professor;
import br.com.tabelasProjeto.dao.DisciplinaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AdicionarNotaFalta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNota;
	private JTextField textFieldFalta;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarNotaFalta frame = new AdicionarNotaFalta();
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
	public AdicionarNotaFalta(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas,Disciplina d) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Nota e Falta");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(88, 11, 266, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 201, 201);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Carga Horaria","id"
			}
		) {

			private static final long serialVersionUID = 1L;

			@Override
			 public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
			 }
		});
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
		preenche(d, model);
		for (int i = 0; i < table.getColumnCount(); i++) {
		      DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
		      TableColumn col = colModel.getColumn(i);
		      int width = 0;

		      TableCellRenderer renderer = col.getHeaderRenderer();
		      for (int r = 0; r < table.getRowCount(); r++) {
		        renderer = table.getCellRenderer(r, i);
		        Component comp = renderer.getTableCellRendererComponent(table, table.getValueAt(r, i),
		            false, false, r, i);
		        width = Math.max(width, comp.getPreferredSize().width);
		      }
		      col.setPreferredWidth(width + 2);
		}
		
		textFieldNota = new JTextField();
		textFieldNota.setBounds(283, 49, 86, 20);
		contentPane.add(textFieldNota);
		textFieldNota.setColumns(10);
		
		JButton btnNewButton = new JButton("add nota");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno a = new Aluno();
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < alunos.size(); i++) {
						if(alunos.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							if(!textFieldNota.getText().equals("")) {
								double nota = Double.parseDouble(textFieldNota.getText());
								for (int j = 0; j < alunos.get(i).getListaDeDisciplina().size(); j++) {
									if(alunos.get(i).getListaDeDisciplina().get(j).getNome().equals(d.getNome())){
										alunos.get(i).getListaDeDisciplina().get(j).setNotaAluno(alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno()+nota);
										JOptionPane.showMessageDialog(null, "Nota do aluno "+alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno());							
										
									}
								}
							}
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
			
			}
		});
		btnNewButton.setBounds(283, 80, 89, 23);
		contentPane.add(btnNewButton);
		
		textFieldFalta = new JTextField();
		textFieldFalta.setBounds(283, 113, 86, 20);
		contentPane.add(textFieldFalta);
		textFieldFalta.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("add falta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < alunos.size(); i++) {
						if(alunos.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							if(!textFieldFalta.getText().equals("")) {
								int falta = Integer.parseInt(textFieldFalta.getText());
								for (int j = 0; j < alunos.get(i).getListaDeDisciplina().size(); j++) {
									if(alunos.get(i).getListaDeDisciplina().get(j).getNome().equals(d.getNome())){
									alunos.get(i).getListaDeDisciplina().get(j).setFalta(alunos.get(i).getListaDeDisciplina().get(j).getFalta()+falta);	
									
									
									JOptionPane.showMessageDialog(null, "Faltas do aluno "+alunos.get(i).getListaDeDisciplina().get(j).getFalta());							
									}
								}
							}
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
			}
		});
		btnNewButton_1.setBounds(283, 145, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new AprovacoesDeAluno(d, alunos, professores, disciplinas).setVisible(true);
			dispose();
			}
		});
		btnContinuar.setBounds(233, 211, 89, 23);
		contentPane.add(btnContinuar);
		
		JButton btnVoltar = new JButton(" voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerirProfessor(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 211, 89, 23);
		contentPane.add(btnVoltar);
	}
	
	public void preenche(Disciplina d,DefaultTableModel model) {
		Object rowData[] = new Object[2];
		for(int i = 0; i < d.getListaDeAlunos().size(); i++) {
			rowData[0] = d.getListaDeAlunos().get(i).getNome();
			rowData[1] = d.getListaDeAlunos().get(i).getMatricula();
			
			model.addRow(rowData);
		}	
	}
}
