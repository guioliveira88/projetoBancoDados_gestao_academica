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

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GerirNotaeFaltasDeAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerirNotaeFaltasDeAluno frame = new GerirNotaeFaltasDeAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GerirNotaeFaltasDeAluno(ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotasEFaltas = new JLabel("Notas e Faltas dos Alunos");
		lblNotasEFaltas.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNotasEFaltas.setBounds(79, 11, 282, 14);
		contentPane.add(lblNotasEFaltas);
		
		textField = new JTextField();
		textField.setBounds(22, 57, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Notas");
		btnNewButton.setBounds(335, 77, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Faltas");
		btnNewButton_1.setBounds(335, 131, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 98, 247, 152);
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

