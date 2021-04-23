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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AprovacoesDeAluno extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AprovacoesDeAluno frame = new AprovacoesDeAluno();
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
	public AprovacoesDeAluno(Disciplina d,ArrayList<Aluno> alunos,ArrayList<Professor> professores,ArrayList<Disciplina> disciplinas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 69, 265, 163);
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
		
		JLabel lblNewLabel = new JLabel("aprova\u00E7\u00F5es");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(162, 11, 124, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow() >= 0) {
					for (int i = 0; i < alunos.size(); i++) {
						if(alunos.get(i).getNome() == (String) table.getValueAt(table.getSelectedRow(), 0)) {
								for (int j = 0; j < alunos.get(i).getListaDeDisciplina().size(); j++) {
									if(alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno()>= 60 && alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno()<=100 && 
											alunos.get(i).getListaDeDisciplina().get(j).getFalta()<18){
									JOptionPane.showMessageDialog(null, "Aprovado nota: "+alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno() + " "+"falta :" + alunos.get(i).getListaDeDisciplina().get(j).getFalta());							
									
									}else if(alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno()>= 0 && alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno()<60 &&
											alunos.get(i).getListaDeDisciplina().get(j).getFalta()>18){
										JOptionPane.showMessageDialog(null, "Reprovado "+alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno());
									}else if(alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno()< 0 && alunos.get(i).getListaDeDisciplina().get(j).getNotaAluno()>100 &&alunos.get(i).getListaDeDisciplina().get(j).getFalta()<0 && alunos.get(i).getListaDeDisciplina().get(j).getFalta()>72) {
										JOptionPane.showMessageDialog(null, " erro nota OU  falta invalida ");
							}
						}
						}
					}
				}else
					JOptionPane.showMessageDialog(null, "Selecione um Disciplina na lista para realizar a operação.");
			}
		});
		btnNewButton.setBounds(318, 69, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AdicionarNotaFalta(alunos, professores, disciplinas,d).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(318, 117, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	public void preenche(Disciplina d,DefaultTableModel model) {
		Object rowData[] = new Object[3];
		for(int i = 0; i < d.getListaDeAlunos().size(); i++) {
			rowData[0] = d.getListaDeAlunos().get(i).getNome();
			rowData[1] = d.getListaDeAlunos().get(i).getMatricula();
			rowData[2] = d.getListaDeAlunos().get(i).getCurso();
			model.addRow(rowData);
		}	
	}
}

