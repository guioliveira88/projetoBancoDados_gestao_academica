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
import br.com.tabelasProjeto.dao.DisciplinaDAO;

import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GerirDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Pesquisa;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
    private JTable table;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerirDisciplina frame = new GerirDisciplina();
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
	public GerirDisciplina(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 96, 191, 142);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Nome", "carga Horaria","id"
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
		preenche(disciplinas, model);
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
		textField_Pesquisa.setBounds(26, 67, 148, 20);
		contentPane.add(textField_Pesquisa);
		textField_Pesquisa.setColumns(10);
		
		JLabel lblGestoDeDisciplina = new JLabel("Gest\u00E3o de  Disciplina");
		lblGestoDeDisciplina.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblGestoDeDisciplina.setBounds(108, 11, 198, 23);
		contentPane.add(lblGestoDeDisciplina);
		
		btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CadastroDeDisciplina(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(301, 66, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Disciplina aux2 = new Disciplina();
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < disciplinas.size(); i++) {
						if(disciplinas.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							aux2= disciplinas.get(i);
						}
					}
					new CadastroDeDisciplina(alunos,professores,disciplinas, aux2).setVisible(true);;
					dispose();
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Disciplinas na lista para realizar a operação.");
			}
			
		});
		btnNewButton_1.setBounds(301, 99, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisciplinaDAO  d = new DisciplinaDAO(); 
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < disciplinas.size(); i++) {
						if(disciplinas.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
							JOptionPane.showMessageDialog(null, "Disciplina excluída.");
							model.removeRow(table.getSelectedRow());
						    try {
								d.deletar(disciplinas.get(i));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Erro ao excluir a disciplina.");
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
			
			}
		});
		btnNewButton_2.setBounds(301, 133, 89, 29);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuGestao(alunos,professores,disciplinas).setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(301, 190, 89, 23);
		contentPane.add(btnNewButton_3);
		
	
	}
	public void preenche(ArrayList<Disciplina> disciplinas,DefaultTableModel model) {
		Object rowData[] = new Object[3];
		for(int i = 0; i < disciplinas.size(); i++) {
			rowData[0] = disciplinas.get(i).getNome();
			rowData[1] = disciplinas.get(i).getCargahoraria();
			rowData[2] = disciplinas.get(i).getId();
			model.addRow(rowData);
		}	
	}
}

