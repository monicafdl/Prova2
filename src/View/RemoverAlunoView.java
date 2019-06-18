package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ResponsavelController;
import Controller.AlunoController;
import Model.Aluno;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverAlunoView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverAlunoView frame = new RemoverAlunoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void atualizar(JComboBox c) {
		AlunoController controller = new AlunoController();
		c.setModel(new JComboBox(controller.listar().toArray()).getModel());
	}
	/**
	 * Create the frame.
	 */
	public RemoverAlunoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverAluno = new JLabel("Remover Aluno");
		lblRemoverAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverAluno.setBounds(33, 11, 366, 14);
		contentPane.add(lblRemoverAluno);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 53, 107, 20);
		contentPane.add(comboBox);
		atualizar(comboBox);
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlunoController controller = new AlunoController();
				Aluno aluno = (Aluno)comboBox.getSelectedItem();
				controller.remover(aluno);
				atualizar(comboBox);
				
			}
		});
		btnRemover.setBounds(159, 94, 107, 23);
		contentPane.add(btnRemover);
	}

}
