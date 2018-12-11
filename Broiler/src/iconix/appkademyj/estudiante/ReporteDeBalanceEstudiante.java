package iconix.appkademyj.estudiante;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import iconix.appkademyj.util.ErrorFrame;
import iconix.database.DatabaseConnect;

public class ReporteDeBalanceEstudiante extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1240249919832646294L;
	private final JTable resultTable;
	private final String fecha;

	public ReporteDeBalanceEstudiante(final DatabaseConnect d) {

		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		final Date date = new Date();
		fecha = dateFormat.format(date);

		setTitle("Reportes de Balance: Estudiantes");
		try {
			setSelected(true);
		} catch (final PropertyVetoException e) {
			ErrorFrame exc = new ErrorFrame(e, "Error no Documentado");
			exc.setVisible(true);
			exc.toFront();
			exc.requestFocus();
			e.printStackTrace();
		}
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1299, 536);

		resultTable = new JTable();
		resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultTable.setRowHeight(30);
		final JScrollPane scrollPane = new JScrollPane(resultTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setEnabled(false);

		final JPanel panel = new JPanel();
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "2016 - 2017", "2017 - 2018", "2018 - 2019",
				"2019 - 2020", "2020 - 2021", "2021 - 2022" }));
		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);

		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1240, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(81, Short.MAX_VALUE)));
		final JButton btnSeguroSocal = new JButton("Todos los Estudiantes");
		btnSeguroSocal.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnSeguroSocal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				resultTable.setModel(d.getStudentReport(comboBox.getSelectedItem().toString(), false));
				resultTable.setFocusable(true);
				resultTable.setRowSelectionAllowed(true);
			}
		});
		final GridBagConstraints gbc_btnSeguroSocal = new GridBagConstraints();
		gbc_btnSeguroSocal.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeguroSocal.gridx = 1;
		gbc_btnSeguroSocal.gridy = 2;
		panel.add(btnSeguroSocal, gbc_btnSeguroSocal);

		final JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				try {

					final MessageFormat headerFormat = new MessageFormat(
							"Reporte De balance: " + comboBox.getSelectedItem().toString() + " : " + fecha);
					final MessageFormat footerFormat = new MessageFormat("- {0} -");
					resultTable.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
				} catch (final PrinterException e) {
					ErrorFrame exc = new ErrorFrame(e, "Error de formato");
					exc.setVisible(true);
					exc.toFront();
					exc.requestFocus();
					e.printStackTrace();
				}

			}
		});
		final GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
		getContentPane().setLayout(groupLayout);

	}
}
