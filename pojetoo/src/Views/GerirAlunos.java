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
import javax.swing.table.TableRowSorter;

import GestaoAcademica.Aluno;
import GestaoAcademica.Disciplina;
import GestaoAcademica.Professor;
import br.com.tabelasProjeto.dao.AlunoDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GerirAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Pesquisa;
	private JTable table;
	private Aluno a;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerirAlunos frame = new GerirAlunos();
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
	public GerirAlunos(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas)  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 85, 275, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Matricula", "Curso"
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
		preenche(alunos, model);
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
		
		textField_Pesquisa = new JTextField();
		textField_Pesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(filtro);
				filtro.setRowFilter(RowFilter.regexFilter(textField_Pesquisa.getText()));
			}
		});
		textField_Pesquisa.setBounds(26, 59, 148, 20);
		contentPane.add(textField_Pesquisa);
		textField_Pesquisa.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroDeAluno(alunos, professores, disciplinas).setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(311, 85, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aux = new Aluno();
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < alunos.size(); i++) {
						if(alunos.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							aux = alunos.get(i);
						}
					}
					new CadastroDeAluno(alunos,professores,disciplinas, aux).setVisible(true);;
					dispose();
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Aluno na lista para realizar a operação.");
			}
		});
		btnEditar.setBounds(311, 119, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			AlunoDAO alunoDao = new AlunoDAO(); 
			Aluno a = new Aluno();
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < alunos.size(); i++) {
						if(alunos.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							JOptionPane.showMessageDialog(null, "aluno excluído.");
							model.removeRow(table.getSelectedRow());
							
							try {
								alunoDao.deletar(a);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao excluir aluno.");
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Aluno na lista para realizar a operação.");
			}
		});
		btnExcluir.setBounds(311, 153, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuGestao(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(311, 187, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblG = new JLabel("Gest\u00E3o de aluno");
		lblG.setBounds(172, 11, 94, 14);
		contentPane.add(lblG);
		
		JButton btnAddDisc = new JButton(" add disc");
		btnAddDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < alunos.size(); i++) {
						if(alunos.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							new AdicionarDisciplina(alunos.get(i),alunos,professores,disciplinas).setVisible(true);
							dispose();
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Aluno na lista para realizar a operação.");
				
			}
		});
		btnAddDisc.setBounds(311, 221, 89, 23);
		contentPane.add(btnAddDisc);
	}
	
	public void preenche(ArrayList<Aluno> alunos,DefaultTableModel model) {
		Object rowData[] = new Object[3];
		for(int i = 0; i < alunos.size(); i++) {
			rowData[0] = alunos.get(i).getNome();
			rowData[1] = alunos.get(i).getMatricula();
			rowData[2] = alunos.get(i).getCurso();
			model.addRow(rowData);
		}	
	}
}

