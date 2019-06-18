package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ResponsavelController;
import Model.Responsavel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoverResponsavelView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverResponsavelView frame = new RemoverResponsavelView();
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
	public RemoverResponsavelView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverResponsavel = new JLabel("Remover Responsavel");
		lblRemoverResponsavel.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverResponsavel.setBounds(44, 11, 340, 14);
		contentPane.add(lblRemoverResponsavel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(119, 54, 202, 20);
		ResponsavelController controller = new ResponsavelController();
		comboBox.setModel(new JComboBox(controller.listar().toArray()).getModel());
		
		contentPane.add(comboBox);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResponsavelController controller = new ResponsavelController();
				Responsavel responsavel = (Responsavel)comboBox.getSelectedItem();
				controller.remover(responsavel);
				comboBox.setModel(new JComboBox(controller.listar().toArray()).getModel());
				JOptionPane.showMessageDialog(null, "Responsavel excluida com sucesso");
			}
		});
		btnRemover.setBounds(176, 113, 89, 23);
		contentPane.add(btnRemover);
	}
}
