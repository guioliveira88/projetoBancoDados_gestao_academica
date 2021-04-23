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
import br.com.tabelasProjeto.dao.ProfessorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GerirProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Pesquisa;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTable table;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerirProfessor frame = new GerirProfessor();
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
	public GerirProfessor(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 83, 275, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "Indentificador"
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
		preenche(professores, model);
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
		
		JLabel lblGestoDeProfessor = new JLabel("Gest\u00E3o de Professor");
		lblGestoDeProfessor.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblGestoDeProfessor.setBounds(119, 11, 192, 14);
		contentPane.add(lblGestoDeProfessor);
		
		textField_Pesquisa = new JTextField();
		textField_Pesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(filtro);
				filtro.setRowFilter(RowFilter.regexFilter(textField_Pesquisa.getText()));
			}
		});
		textField_Pesquisa.setBounds(24, 52, 148, 20);
		contentPane.add(textField_Pesquisa);
		textField_Pesquisa.setColumns(10);
		
		btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroDeProfessor(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(299, 93, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor aux1 = new Professor();
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < professores.size(); i++) {
						if(professores.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							aux1 = professores.get(i);
						}
					}
					new CadastroDeProfessor(alunos,professores,disciplinas, aux1).setVisible(true);;
					dispose();
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Professor na lista para realizar a operação.");
			
			}
		});
		btnNewButton_2.setBounds(299, 127, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			Professor p = new Professor();
			ProfessorDAO professorDao = new ProfessorDAO();
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < professores.size(); i++) {
						if(professores.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							JOptionPane.showMessageDialog(null, "Professor excluída.");
							model.removeRow(table.getSelectedRow());
							try {
								professorDao.deletar(professores.get(i));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao excluir a Professor.");
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Professor na lista para realizar a operação.");
			
			
			}
		});
		btnNewButton_3.setBounds(299, 161, 89, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Voltar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuGestao(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(299, 195, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnAddDisc = new JButton(" Add disc ");
		btnAddDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < professores.size(); i++) {
						if(professores.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							new AdicionarDisciplina(professores.get(i), alunos, professores, disciplinas).setVisible(true);
							dispose();
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Professor na lista para realizar a operação.");
			
			
			}
		});
		btnAddDisc.setBounds(299, 229, 89, 23);
		contentPane.add(btnAddDisc);
	}
	public void preenche(ArrayList<Professor> professores,DefaultTableModel model) {
		Object rowData[] = new Object[2];
		for(int i = 0; i < professores.size(); i++) {
			rowData[0] = professores.get(i).getNome();
			rowData[1] = professores.get(i).getIdentificador();

			model.addRow(rowData);
		}	
	}
}
