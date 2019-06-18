package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResponsavelView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponsavelView frame = new ResponsavelView();
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
	public ResponsavelView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarResponsavelView criarResponsavel = new CriarResponsavelView();
				criarResponsavel.setVisible(true);
			}
		});
		btnCriar.setBounds(176, 71, 89, 23);
		contentPane.add(btnCriar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarResponsavelView n = new EditarResponsavelView();
				n.setVisible(true);
			}
		});
		btnEditar.setBounds(176, 105, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverResponsavelView n = new RemoverResponsavelView();
				n.setVisible(true);
			}
		});
		btnRemover.setBounds(176, 139, 89, 23);
		contentPane.add(btnRemover);
		
		JLabel lblResponsavel = new JLabel("Discplina");
		lblResponsavel.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsavel.setBounds(40, 11, 345, 14);
		contentPane.add(lblResponsavel);
	}
}
