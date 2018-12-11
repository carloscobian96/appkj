package iconix.appkademyj.estudiante;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import iconix.database.DatabaseConnect;

public class AplicarRecargos extends JInternalFrame {

	private static final long serialVersionUID = -7509489968187788665L;
	private final JTextField recargo;
	private final JTextField ahorros;

	public AplicarRecargos(final DatabaseConnect d) {
		setTitle("Recargos");
		setClosable(true);
		setBounds(100, 100, 400, 510);

		final JPanel panel = new JPanel();
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE).addContainerGap()));
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_lblSemestre = new GridBagConstraints();
		gbc_lblSemestre.anchor = GridBagConstraints.WEST;
		gbc_lblSemestre.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemestre.gridx = 1;
		gbc_lblSemestre.gridy = 0;
		panel.add(lblSemestre, gbc_lblSemestre);

		final JComboBox<String> semestre = new JComboBox<String>();
		semestre.setFont(new Font("Dialog", Font.PLAIN, 22));
		semestre.setModel(new DefaultComboBoxModel<String>(new String[] { "2016 - 2017", "2017 - 2018", "2018 - 2019",
				"2019 - 2020", "2020 - 2021", "2021 - 2022", "2022 - 2023" }));
		final GridBagConstraints gbc_semestre = new GridBagConstraints();
		gbc_semestre.anchor = GridBagConstraints.WEST;
		gbc_semestre.insets = new Insets(0, 0, 5, 0);
		gbc_semestre.gridx = 3;
		gbc_semestre.gridy = 0;
		panel.add(semestre, gbc_semestre);

		final JLabel lblMes = new JLabel("Mes:");
		lblMes.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_lblMes = new GridBagConstraints();
		gbc_lblMes.anchor = GridBagConstraints.WEST;
		gbc_lblMes.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes.gridx = 1;
		gbc_lblMes.gridy = 1;
		panel.add(lblMes, gbc_lblMes);

		final JComboBox<String> mes = new JComboBox<String>();
		mes.setFont(new Font("Dialog", Font.PLAIN, 22));
		mes.setModel(new DefaultComboBoxModel<String>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
				"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
		final GridBagConstraints gbc_mes = new GridBagConstraints();
		gbc_mes.anchor = GridBagConstraints.WEST;
		gbc_mes.insets = new Insets(0, 0, 5, 0);
		gbc_mes.gridx = 3;
		gbc_mes.gridy = 1;
		panel.add(mes, gbc_mes);

		final JLabel lblCantidad = new JLabel("Recargo");
		lblCantidad.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.WEST;
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 1;
		gbc_lblCantidad.gridy = 2;
		panel.add(lblCantidad, gbc_lblCantidad);

		recargo = new JTextField();
		recargo.setText("20.0");
		recargo.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_recargo = new GridBagConstraints();
		gbc_recargo.anchor = GridBagConstraints.WEST;
		gbc_recargo.insets = new Insets(0, 0, 5, 0);
		gbc_recargo.gridx = 3;
		gbc_recargo.gridy = 2;
		panel.add(recargo, gbc_recargo);
		recargo.setColumns(10);

		final JButton btnNewButton = new JButton("Aplicar");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				if (recargo.getText() == "" || !isNumeric(recargo.getText())) {
					JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
							JOptionPane.WARNING_MESSAGE);
					recargo.requestFocus();
				} else {
					d.aplicarRecargos(semestre.getSelectedItem().toString(), mes.getSelectedItem().toString(),
							Double.parseDouble(recargo.getText()), Double.parseDouble(ahorros.getText()));
					JOptionPane.showMessageDialog(null,
							"Recargos Aplicados a todos los estudiantes \n con balance pendiente", "Recargos",
							JOptionPane.WARNING_MESSAGE);
					dispose();
				}
			}
		});

		final JLabel lblAhorros = new JLabel("Ahorros");
		lblAhorros.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_lblAhorros = new GridBagConstraints();
		gbc_lblAhorros.anchor = GridBagConstraints.WEST;
		gbc_lblAhorros.insets = new Insets(0, 0, 5, 5);
		gbc_lblAhorros.gridx = 1;
		gbc_lblAhorros.gridy = 3;
		panel.add(lblAhorros, gbc_lblAhorros);

		ahorros = new JTextField();
		ahorros.setText("20.0");
		ahorros.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_ahorros = new GridBagConstraints();
		gbc_ahorros.anchor = GridBagConstraints.WEST;
		gbc_ahorros.insets = new Insets(0, 0, 5, 0);
		gbc_ahorros.gridx = 3;
		gbc_ahorros.gridy = 3;
		panel.add(ahorros, gbc_ahorros);
		ahorros.setColumns(10);
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		panel.add(btnNewButton, gbc_btnNewButton);

		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 22));
		final GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.WEST;
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 5;
		panel.add(btnCancelar, gbc_btnCancelar);
		getContentPane().setLayout(groupLayout);

	}

	public static boolean isNumeric(final String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}
}
