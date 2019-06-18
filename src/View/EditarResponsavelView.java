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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarResponsavelView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarResponsavelView frame = new EditarResponavelView();
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
	public EditarResponsavelView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarResponsavel = new JLabel("Editar Disciplina");
		lblEditarResponsavel.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarResponsavel.setBounds(10, 11, 403, 14);
		contentPane.add(lblEditarResponsavel);
		
		JComboBox<Responsavel> comboBox = new JComboBox<Responsavel>();
		comboBox.setBounds(155, 36, 115, 20);
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        textField.setText(comboBox.getSelectedItem().toString());
		    }
		});
		contentPane.add(comboBox);
		ResponsavelController controller = new ResponsavelController();
		comboBox.setModel(new JComboBox(controller.listar().toArray()).getModel());
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				ResponsavelController controller = new ResponsavelController();
				Responsavel responsavel = new Responsavel(textField.getText());
				Responsavel tmp = (Responsavel)comboBox.getSelectedItem();
				responsavel.setId(tmp.getId());
				controller.editar(responsavel);
				atualizar(comboBox);
				comboBox.setSelectedIndex(index);
				JOptionPane.showMessageDialog(null, "Responsavel editada com sucesso");
			}
		});
		btnNewButton.setBounds(165, 106, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(155, 75, 115, 20);
		textField.setText(comboBox.getSelectedItem().toString());
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
