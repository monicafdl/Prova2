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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarAlunoView extends JFrame {

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
					CriarAlunoView frame = new CriarAlunoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void atualizar(JComboBox c) {
		ResponsavelController controller = new ResponsavelController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
	}
	
	
	/**
	 * Create the frame.
	 */
	public CriarAlunoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserirAluno = new JLabel("Inserir Professor");
		lblInserirAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirAluno.setBounds(57, 11, 291, 14);
		contentPane.add(lblInserirAluno);
		
		textField = new JTextField();
		textField.setBounds(122, 60, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(122, 46, 89, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(122, 91, 89, 14);
		contentPane.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 105, 143, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 150, 143, 20);
		contentPane.add(textField_2);
		
		
		
		
		JLabel lblresponsavel = new JLabel("responsavel");
		lblresponsavel.setBounds(122, 181, 111, 14);
		contentPane.add(lblresponsavel);
		
		JComboBox<Responsavel> comboBox = new JComboBox<Responsavel>();
		atualizar(comboBox);
		comboBox.setBounds(122, 195, 144, 20);
		contentPane.add(comboBox);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoController controller = new AlunoController();
				Aluno aluno = new Aluno(textField.getText(), textField_1.getText(), (Responsavel)comboBox.getSelectedItem(), textField_2.getText());
				controller.create(aluno);
				JOptionPane.showMessageDialog(null, "Aluno "+aluno.getNome()+" criado com sucesso");
			}
		});
		btnInserir.setBounds(144, 246, 89, 23);
		contentPane.add(btnInserir);
	}
}
