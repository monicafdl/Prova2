package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ResponsavelController;
import Controller.AlunoController;
import Model.Responsavel;
import Model.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarAlunoView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarAlunoView frame = new EditarAlunoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void atualizarResponsavel(JComboBox c) {
		ResponsavelController controller = new ResponsavelController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
		
		
	}
	public void atualizarAluno(JComboBox c) {
		AlunoController controller = new AlunoController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
	}
	public EditarAlunoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarAluno = new JLabel("Editar Aluno");
		lblEditarAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarAluno.setBounds(30, 11, 345, 14);
		contentPane.add(lblEditarAluno);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(134, 36, 155, 20);
		contentPane.add(comboBox);
		atualizarAluno(comboBox);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(109, 100, 92, 20);
		Aluno aluno = (Aluno)comboBox.getSelectedItem();
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(aluno.getCpf());
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(109, 85, 46, 14);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 100, 164, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(aluno.getNome());
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(211, 85, 46, 14);
		contentPane.add(lblNome);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 145, 114, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(233, 145, 142, 20);
		contentPane.add(comboBox_1);
		atualizarResponsavel(comboBox_1);
		comboBox_1.setSelectedItem(aluno.getResponsavel());	
		JLabel lblResponsavel = new JLabel("Responsavel");
		lblResponsavel.setBounds(233, 131, 114, 14);
		contentPane.add(lblResponsavel);
		aluno = (Aluno)comboBox.getSelectedItem();
		for (int i=0; i<comboBox_1.getModel().getSize(); i++)
		{
		    if (comboBox_1.getItemAt(i).toString().equals(aluno.getResponsavel().getNome()))
		    {
		        comboBox_1.setSelectedIndex(i);
		        break;
		    }
		}	
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno aluno = (Aluno)comboBox.getSelectedItem();
				atualizarResponsavel(comboBox_1);
				textField.setText(aluno.getCpf());
				textField_1.setText(aluno.getNome());
			
				for (int i=0; i<comboBox_1.getModel().getSize(); i++)
				{
				    if (comboBox_1.getItemAt(i).toString().equals(aluno.getResponsavel().getNome()))
				    {
				        comboBox_1.setSelectedIndex(i);
				        break;
				    }
				}
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Responsavel responsavel = (Responsavel)comboBox_1.getSelectedItem();
				Aluno aluno = new Aluno(textField.getText(), textField_1.getText(), responsavel ,textField_2.getText());
				AlunoController controller = new AlunoController();
				
				controller.editar(aluno);
				JOptionPane.showMessageDialog(null, "Aluno editado com sucesso");
			}
		});
		btnEditar.setBounds(168, 192, 89, 23);
		contentPane.add(btnEditar);
	}

}