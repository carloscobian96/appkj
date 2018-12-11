package broiler.database;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import broiler.util.ErrorFrame;
//import broiler.abstraction;

//import iconix.appkademyj.util.ErrorFrame;

public class NuevoAnoEscolar extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2008044124938207280L;
	private final JTextField semestreField;
	private final JTextField nuevoSemestreField;
	private final JTextField cuotaField;
	// private List students;

	public NuevoAnoEscolar(final broiler.abstraction.DatabaseConnect d) {
		setClosable(true);
		setBounds(100, 100, 765, 300);

		final JPanel panel = new JPanel();
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE).addContainerGap()));
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JLabel lblTransferirEstudiantesDel = new JLabel("Transferir estudiantes del a\u00F1o escolar:");
		lblTransferirEstudiantesDel.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblTransferirEstudiantesDel = new GridBagConstraints();
		gbc_lblTransferirEstudiantesDel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTransferirEstudiantesDel.anchor = GridBagConstraints.WEST;
		gbc_lblTransferirEstudiantesDel.gridx = 1;
		gbc_lblTransferirEstudiantesDel.gridy = 1;
		panel.add(lblTransferirEstudiantesDel, gbc_lblTransferirEstudiantesDel);

		semestreField = new JTextField();
		semestreField.setFont(new Font("Dialog", Font.PLAIN, 20));
		semestreField.setText("2016 - 2017");
		final GridBagConstraints gbc_semestreField = new GridBagConstraints();
		gbc_semestreField.anchor = GridBagConstraints.WEST;
		gbc_semestreField.insets = new Insets(0, 0, 5, 5);
		gbc_semestreField.gridx = 2;
		gbc_semestreField.gridy = 1;
		panel.add(semestreField, gbc_semestreField);
		semestreField.setColumns(10);

		final JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.anchor = GridBagConstraints.WEST;
		gbc_lblA.gridx = 3;
		gbc_lblA.gridy = 1;
		panel.add(lblA, gbc_lblA);

		nuevoSemestreField = new JTextField();
		nuevoSemestreField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nuevoSemestreField.setText("2017 - 2018");
		final GridBagConstraints gbc_nuevoSemestreField = new GridBagConstraints();
		gbc_nuevoSemestreField.anchor = GridBagConstraints.WEST;
		gbc_nuevoSemestreField.insets = new Insets(0, 0, 5, 0);
		gbc_nuevoSemestreField.gridx = 4;
		gbc_nuevoSemestreField.gridy = 1;
		panel.add(nuevoSemestreField, gbc_nuevoSemestreField);
		nuevoSemestreField.setColumns(10);

		final JLabel lblCuotaDeGraduacion = new JLabel("Cuota de Graduacion, 6, 9, 12:");
		lblCuotaDeGraduacion.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblCuotaDeGraduacion = new GridBagConstraints();
		gbc_lblCuotaDeGraduacion.anchor = GridBagConstraints.WEST;
		gbc_lblCuotaDeGraduacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuotaDeGraduacion.gridx = 1;
		gbc_lblCuotaDeGraduacion.gridy = 3;
		panel.add(lblCuotaDeGraduacion, gbc_lblCuotaDeGraduacion);

		cuotaField = new JTextField();
		cuotaField.setFont(new Font("Dialog", Font.PLAIN, 20));
		cuotaField.setText("100.00");
		final GridBagConstraints gbc_cuotaField = new GridBagConstraints();
		gbc_cuotaField.anchor = GridBagConstraints.WEST;
		gbc_cuotaField.insets = new Insets(0, 0, 5, 5);
		gbc_cuotaField.gridx = 2;
		gbc_cuotaField.gridy = 3;
		panel.add(cuotaField, gbc_cuotaField);
		cuotaField.setColumns(10);

		final JProgressBar progressBar = new JProgressBar();
		progressBar.setEnabled(false);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.GREEN);
		final GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		gbc_progressBar.gridx = 4;
		gbc_progressBar.gridy = 5;
		panel.add(progressBar, gbc_progressBar);
		getContentPane().setLayout(groupLayout);

		final JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				try {
					d.nuevoAnoEscolar(semestreField.getText(), nuevoSemestreField.getText(),
							Double.parseDouble(cuotaField.getText()));

					JOptionPane.showMessageDialog(null, "Exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);

				} catch (final SQLException | IllegalArgumentException | IllegalAccessException e2) {

					ErrorFrame exc = new ErrorFrame(e2, "Error Creando Estudiante");
					exc.setVisible(true);
					exc.toFront();
					exc.requestFocus();
					e2.printStackTrace();

				}

			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);

	}
}
