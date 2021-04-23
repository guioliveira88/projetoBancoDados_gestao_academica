package Views;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import GestaoAcademica.Aluno;
import GestaoAcademica.Disciplina;
import GestaoAcademica.Professor;


public class AdicionarDisciplina extends JFrame {

	private JPanel contentPane;
	 private JTable table;
	 private JTable table1;

	/**
	 * Launch the application.
	 * @wbp.parser.constructor
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarDisciplina frame = new AdicionarDisciplina());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
s
	/**
	 * Create the frame.
	 */
		public AdicionarDisciplina(Aluno a,ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 45, 200, 161);
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
	preenche(a, model);
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
	
	JLabel lblMateria = new JLabel(" Materia");
	lblMateria.setFont(new java.awt.Font("Arial Black", java.awt.Font.BOLD, 16));
	lblMateria.setBounds(180, 11, 94, 23);
	contentPane.add(lblMateria);
	
	JButton btnNewButton_1 = new JButton("Excluir");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow() >= 0) {
				for (int i = 0; i < a.getListaDeDisciplina().size(); i++) {
					if(a.getListaDeDisciplina().get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
						JOptionPane.showMessageDialog(null, "Disciplina excluída.");
						model.removeRow(table.getSelectedRow());
					}
					else {
						JOptionPane.showMessageDialog(null, "Erro ao excluir a disciplina.");
					}
				}
			}else
				JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
		
		
		}
	});
	btnNewButton_1.setBounds(285, 227, 89, 23);
	contentPane.add(btnNewButton_1);
	
	JScrollPane scrollPane1 = new JScrollPane();
	scrollPane1.setBounds(236, 45, 188, 161);
	contentPane.add(scrollPane1);
	
	table1 = new JTable();
	scrollPane1.setViewportView(table1);
	table1.setModel(new DefaultTableModel(
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
	DefaultTableModel model1=  (DefaultTableModel) table1.getModel();
	preenche(disciplinas, model1);
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
	
	JButton btnNewButton = new JButton("Adicionar");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(table1.getSelectedRow() >= 0) {
				for (int i = 0; i < disciplinas.size(); i++) {
					if(disciplinas.get(i).getNome() == (String) table1.getValueAt(table1.getSelectedRow(), 0)) {
						JOptionPane.showMessageDialog(null, "Disciplina adicionada.");
						Object rowData[] = new Object[3];
							rowData[0] = disciplinas.get(i).getNome();
							rowData[1] = disciplinas.get(i).getCargahoraria();
							rowData[2] = disciplinas.get(i).getId();
							
							model.addRow(rowData);
							a.getListaDeDisciplina().add(disciplinas.get(i));
							disciplinas.get(i).getListaDeAlunos().add(a);
					}
				}
			}else
				JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
		}
		
	});
	btnNewButton.setBounds(79, 227, 89, 23);
	contentPane.add(btnNewButton);
	
	JButton btnNewButton_2 = new JButton("Voltar");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new GerirAlunos(alunos, professores, disciplinas).setVisible(true);
		}
	});
	btnNewButton_2.setBounds(180, 227, 89, 23);
	contentPane.add(btnNewButton_2);
		}
		
		public AdicionarDisciplina(Professor p,ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 45, 200, 161);
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
			preenche(p, model);
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
			
			JLabel lblMateria = new JLabel(" Materia");
			lblMateria.setFont(new java.awt.Font("Arial Black", java.awt.Font.BOLD, 16));
			lblMateria.setBounds(180, 11, 94, 23);
			contentPane.add(lblMateria);
			
			JButton btnNewButton_1 = new JButton("Excluir");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getSelectedRow() >= 0) {
						for (int i = 0; i < p.getListaDisciplinaProfessor().size(); i++) {
							if(p.getListaDisciplinaProfessor().get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
								JOptionPane.showMessageDialog(null, "Disciplina excluída.");
								model.removeRow(table.getSelectedRow());
							}
							else {
								JOptionPane.showMessageDialog(null, "Erro ao excluir a disciplina.");
							}
						}
					}else
						JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
				
				
				}
			});
			btnNewButton_1.setBounds(261, 227, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(236, 45, 188, 161);
			contentPane.add(scrollPane1);
			
			table1 = new JTable();
			scrollPane1.setViewportView(table1);
			table1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nome", "Carga Horaria"
				}
			) {

				private static final long serialVersionUID = 1L;

				@Override
				 public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
				 }
			});
			DefaultTableModel model1=  (DefaultTableModel) table1.getModel();
			preenche(disciplinas, model1);
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
			
			JButton btnNewButton = new JButton("Adicionar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table1.getSelectedRow() >= 0) {
						for (int i = 0; i < disciplinas.size(); i++) {
							if(disciplinas.get(i).getNome() == (String) table1.getValueAt(table1.getSelectedRow(), 0)) {
								JOptionPane.showMessageDialog(null, "Disciplina adicionada.");
								Object rowData[] = new Object[3];
									rowData[0] = disciplinas.get(i).getNome();
									rowData[1] = disciplinas.get(i).getCargahoraria();
									rowData[2] = disciplinas.get(i).getId();
									
									model.addRow(rowData);
									p.getListaDisciplinaProfessor().add(disciplinas.get(i));
							}
						}
					}else
						JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
				}
				
			});
			btnNewButton.setBounds(91, 227, 89, 23);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_2 = new JButton("Voltar");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new GerirAlunos(alunos, professores, disciplinas).setVisible(true);
				}
			});
			btnNewButton_2.setBounds(180, 227, 89, 23);
			contentPane.add(btnNewButton_2);
			
			JButton btnAddNotafalta = new JButton("Add Nota/Falta");
			btnAddNotafalta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow() >= 0) {
						for (int i = 0; i < p.getListaDisciplinaProfessor().size(); i++) {
							if(p.getListaDisciplinaProfessor().get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
								new AdicionarNotaFalta(alunos, professores, disciplinas, p.getListaDisciplinaProfessor().get(i)).setVisible(true);
								dispose();
							}
						}
					}else
						JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
				}
			});
			btnAddNotafalta.setBounds(10, 227, 99, 23);
			contentPane.add(btnAddNotafalta);
			
				}
		public void preenche(Aluno a,DefaultTableModel model) {
			Object rowData[] = new Object[3];
			for(int i = 0; i < a.getListaDeDisciplina().size(); i++) {
				rowData[0] = a.getListaDeDisciplina().get(i).getNome();
				rowData[1] = a.getListaDeDisciplina().get(i).getCargahoraria();
				rowData[2] = a.getListaDeDisciplina().get(i).getId();
				model.addRow(rowData);
			}	
		}
		
		public void preenche(Professor p,DefaultTableModel model) {
			Object rowData[] = new Object[3];
			for(int i = 0; i < p.getListaDisciplinaProfessor().size(); i++) {
				rowData[0] = p.getListaDisciplinaProfessor().get(i).getNome();
				rowData[1] = p.getListaDisciplinaProfessor().get(i).getCargahoraria();
				rowData[2] = p.getListaDisciplinaProfessor().get(i).getId();
				model.addRow(rowData);
			}	
		}
		
		public void preenche(ArrayList<Disciplina> disc,DefaultTableModel model) {
			Object rowData[] = new Object[3];
			for(int i = 0; i < disc.size(); i++) {
				rowData[0] = disc.get(i).getNome();
				rowData[1] = disc.get(i).getCargahoraria();
				rowData[2] = disc.get(i).getId();
				model.addRow(rowData);
			}	
		}
}

