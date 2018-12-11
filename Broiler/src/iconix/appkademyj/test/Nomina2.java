package iconix.appkademyj.test;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import iconix.appkademyj.empleados.EmpleadoOld;
import iconix.appkademyj.util.DoubleToWords;
import iconix.database.DatabaseConnect;

public class Nomina2 extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3657872731976588955L;
	private final JTable resultTable;
	private final String fecha;
	private final String fechaCorta;
	private final DatabaseConnect d;

	public Nomina2(final DatabaseConnect d) {
		this.d = d;
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Date date = new Date();
		fecha = dateFormat.format(date);

		final DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yy");
		final Date date2 = new Date();
		fechaCorta = dateFormat2.format(date2);

		setTitle("Nomina");
		try {
			setSelected(true);
		} catch (final PropertyVetoException e) {
			e.printStackTrace();
		}
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1299, 467);

		resultTable = new JTable();
		resultTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultTable.setRowHeight(30);
		final JScrollPane scrollPane = new JScrollPane(resultTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		resultTable.setModel(d.getNomina());
		resultTable.setFocusable(true);
		resultTable.setRowSelectionAllowed(true);

		final JPanel panel = new JPanel();

		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE).addGap(226)));
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		getContentPane().setLayout(groupLayout);

		final JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

				((DefaultTableModel) resultTable.getModel()).removeRow(resultTable.getSelectedRow());

			}
		});
		btnEliminar.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 1;
		gbc_btnEliminar.gridy = 1;
		panel.add(btnEliminar, gbc_btnEliminar);

		final JButton btnRecalcular = new JButton("Recalcular");
		btnRecalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				recalcular();
			}
		});
		btnRecalcular.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_btnRecalcular = new GridBagConstraints();
		gbc_btnRecalcular.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecalcular.gridx = 3;
		gbc_btnRecalcular.gridy = 1;
		panel.add(btnRecalcular, gbc_btnRecalcular);

		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		comboBox.setModel(new DefaultComboBoxModel<Object>(d.getNominaDates().toArray()));

		final JButton btnValidarEImprimir = new JButton("Validar e Imprimir Reporte");
		btnValidarEImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				try {
					recalcular();
					if (validarNomina()) {

						agregarTotales();

						// PrinterJob pj = PrinterJob.getPrinterJob();
						// Book book = new Book();
						final MessageFormat headerFormat = new MessageFormat("Reporte de Nomina: " + fecha);
						final MessageFormat footerFormat = new MessageFormat("- {0} -");

						d.registrarNomina(resultTable, fecha);
						// book.append(new NominaTitle(), pj.defaultPage());
						// book.append(resultTable.getPrintable(PrintMode.FIT_WIDTH, headerFormat,
						// footerFormat), pj.defaultPage());
						// book.append(new EndPage(), pj.defaultPage());
						// pj.setPageable(book);
						// pj.print();
						resultTable.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
						// dispose();
						btnValidarEImprimir.setEnabled(false);
					} else {

					}

				} catch (final PrinterException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error de Nomina",
							"Error procesando. \n Verifica los campos de horas.", JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			}
		});

		final JButton btnImprimirCheque = new JButton("Imprimir Cheque");
		btnImprimirCheque.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnImprimirCheque.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				recalcular();
				final int row = resultTable.getSelectedRow();
				final Double total = Double.parseDouble(resultTable.getModel().getValueAt(row, 14).toString());
				if (row != -1 && total > 0) {
					try {
						generarCheque(row, total).print();
						// generarCheque(row,total).print( null,null,false, null ,null, true);
					} catch (final PrinterException e2) {
						// TODO Auto-generated catch block
						// #FIXME ADD POP UP MESAGE FOR ERRORS IN NEGATIVE AMMOUNTS
						e2.printStackTrace();
					}

				}

			}
		});
		final GridBagConstraints gbc_btnImprimirCheque = new GridBagConstraints();
		gbc_btnImprimirCheque.insets = new Insets(0, 0, 5, 5);
		gbc_btnImprimirCheque.gridx = 7;
		gbc_btnImprimirCheque.gridy = 1;
		panel.add(btnImprimirCheque, gbc_btnImprimirCheque);
		btnValidarEImprimir.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_btnValidarEImprimir = new GridBagConstraints();
		gbc_btnValidarEImprimir.gridwidth = 3;
		gbc_btnValidarEImprimir.insets = new Insets(0, 0, 0, 5);
		gbc_btnValidarEImprimir.gridx = 1;
		gbc_btnValidarEImprimir.gridy = 2;
		panel.add(btnValidarEImprimir, gbc_btnValidarEImprimir);

		final JButton btnAbrirRecordDe = new JButton("Abrir record de Nomina");
		btnAbrirRecordDe.setEnabled(false);
		btnAbrirRecordDe.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_btnAbrirRecordDe = new GridBagConstraints();
		gbc_btnAbrirRecordDe.insets = new Insets(0, 0, 0, 5);
		gbc_btnAbrirRecordDe.gridx = 5;
		gbc_btnAbrirRecordDe.gridy = 2;
		panel.add(btnAbrirRecordDe, gbc_btnAbrirRecordDe);

		final JButton btnNewButton = new JButton("Validar e Imprimir Todos los Cheques");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

				recalcular();
				if (validarNomina()) {
					// int row = resultTable.getSelectedRow();
					// Double total = Double.parseDouble(resultTable.getModel().getValueAt(row,
					// 13).toString());

					try {

						for (int i = 0; i < resultTable.getRowCount(); i++) {
							generarCheque(i, Double.parseDouble(resultTable.getModel().getValueAt(i, 14).toString()))
									.print(null, null, false, null, null, true);
							;
						}

						// generarCheque(row, total).print();
						// generarCheque(row,total).print( null,null,false, null ,null, true);
					} catch (final PrinterException e2) {
						// TODO Auto-generated catch block
						// #FIXME ADD POP UP MESAGE FOR ERRORS IN NEGATIVE AMMOUNTS
						e2.printStackTrace();
					}

				}

			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);

	}

	public void recalcular() {
		for (int i = 0; i < resultTable.getRowCount(); i++) {
			Double total = 0.0;
			Double tax = 0.0;
			Double Fica = 0.0;
			Double ded = 0.0;
			Double cred = 0.0;
			final DecimalFormat df2 = new DecimalFormat(".##");

			// add salary
			total += Double.parseDouble((String) resultTable.getModel().getValueAt(i, 3));// add salario to total
			// calculate p/h salary
			total += (Double.parseDouble((String) resultTable.getModel().getValueAt(i, 4))
					* Double.parseDouble((String) resultTable.getModel().getValueAt(i, 5)));
			// calculate tax
			tax = Double.parseDouble(
					df2.format(((Double.parseDouble((String) resultTable.getModel().getValueAt(i, 6)) / 100) * total)));
			// calculate FICA

			Fica = Double.parseDouble(
					df2.format(Double.parseDouble(resultTable.getModel().getValueAt(i, 8).toString()) / 100 * total));

			ded = Double.parseDouble(resultTable.getModel().getValueAt(i, 12).toString());// add salario to total
			cred = Double.parseDouble(resultTable.getModel().getValueAt(i, 13).toString());// add salario to
			// total

			final Double totalFinal = Double.parseDouble(df2.format(total - Fica - tax - ded + cred
					- Double.parseDouble((String) resultTable.getModel().getValueAt(i, 10))
					- Double.parseDouble((String) resultTable.getModel().getValueAt(i, 11))));
			resultTable.setValueAt(tax, i, 7);
			resultTable.setValueAt(Fica, i, 9);
			resultTable.setValueAt(totalFinal, i, 14);
		}

	}

	public boolean agregarTotales() {
		for (int i = 0; i < resultTable.getRowCount(); i++) {
			Double total = 0.0;
			total += Double.parseDouble(resultTable.getModel().getValueAt(i, 3).toString());// add salario to total
			// calculate p/h salary
			total += (Double.parseDouble(resultTable.getModel().getValueAt(i, 4).toString())
					* Double.parseDouble(resultTable.getModel().getValueAt(i, 5).toString()));

			d.agregarATotalEmpleado(Integer.parseInt(resultTable.getModel().getValueAt(i, 0).toString()), total);
		}

		return true;
	}

	public boolean validarNomina() {
		for (int i = 0; i < resultTable.getRowCount(); i++) {
			if (Double.parseDouble(resultTable.getModel().getValueAt(i, 14).toString()) < 0) {
				JOptionPane.showMessageDialog(null, "Error de Nomina", "Cantidad a pagar Negativa",
						JOptionPane.WARNING_MESSAGE);
				resultTable.requestFocus();
				resultTable.editCellAt(i, 5);
				return false;
			}
		}

		return true;

	}

	public JTextArea generarCheque(final int row, final Double total) {

		final JTextArea textArea = new JTextArea();

		textArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textArea.append("ACADEMIA COOPERATIVA DE INTEGRACION SOCIAL\n");
		textArea.append(resultTable.getModel().getValueAt(row, 0).toString() + " : "
				+ resultTable.getModel().getValueAt(row, 2).toString() + "\n");

		final EmpleadoOld emp = new EmpleadoOld(
				d.getEmployeeById(Integer.parseInt(resultTable.getModel().getValueAt(row, 0).toString())));
		final String acct = emp.getChartOfAcct();

		textArea.append("----------HORAS PAGADAS---------- PERIODO TERMINADO EN:" + fechaCorta + "\n");
		textArea.append("\n");

		textArea.append("Salario \t Costo P/H \t Horas \t Tax \t FICA \t Medicare \t Cancer \n");

		textArea.append(resultTable.getModel().getValueAt(row, 3).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 4).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 5).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 7).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 9).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 10).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 11).toString() + "\n\n\n");

		textArea.append("Ded \t cred \t total\n");

		textArea.append(resultTable.getModel().getValueAt(row, 12).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 13).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 14).toString() + "\n"

		);

		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA\n");
		// textArea.append("TABLA DE DATA TOTAL A PAGAR\n");

		textArea.append("\n\n\n\n\n\n\n\n\n\n\n\n");

		final Font h = new Font("Helvetica", Font.PLAIN, 10);
		textArea.setFont(h);

		textArea.append("				" + fechaCorta + "		" + total + "\n");
		textArea.append(DoubleToWords.doubleConvert(total) + "\n");
		textArea.append(resultTable.getModel().getValueAt(row, 2).toString() + "\n\n");// nombre
		textArea.append(acct);

		textArea.append("\n\n\n\n\n\n\n\n");

		textArea.append("ACADEMIA COOPERATIVA DE INTEGRACION SOCIAL\n");
		textArea.append(resultTable.getModel().getValueAt(row, 0).toString() + " : "
				+ resultTable.getModel().getValueAt(row, 2).toString() + "\n");
		textArea.append("----------HORAS PAGADAS---------- PERIODO TERMINADO EN:" + fechaCorta + "\n");
		textArea.append("\n");

		textArea.append("Salario \t Costo P/H \t Horas \t Tax \t FICA \t Medicare \t Cancer \n");

		textArea.append(resultTable.getModel().getValueAt(row, 3).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 4).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 5).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 7).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 9).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 10).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 11).toString() + "\n\n\n");

		textArea.append("Ded \t cred \t total\n");

		textArea.append(resultTable.getModel().getValueAt(row, 12).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 13).toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 14).toString() + "\n"

		);
		return textArea;
	}
}
