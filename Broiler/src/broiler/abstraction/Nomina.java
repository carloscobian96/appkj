package broiler.abstraction;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
//
//import iconix.appkademyj.util.DoubleToWords;
//import iconix.appkademyj.util.ErrorFrame;
//import iconix.database.DatabaseConnect;

import broiler.util.DoubleToWords;
import broiler.util.ErrorFrame;

public class Nomina extends JInternalFrame {
	/**
	 * #FIXME input validation before query excecuting perhaps in a single validate
	 * method for table
	 * 
	 */
	private static final long serialVersionUID = -3657872731976588955L;
	private final JTable resultTable;
	private final String fecha;
	private final String fechaCorta;
	private final DatabaseConnect d;
	private JTable table;
	private Double[][] horas;

	public Nomina(final DatabaseConnect d) {
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
			ErrorFrame exc = new ErrorFrame(e, "Error Creando Estudiante");
			exc.setVisible(true);
			exc.toFront();
			exc.requestFocus();
			e.printStackTrace();
		}
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1299, 527);

		resultTable = new JTable();
		resultTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultTable.setRowHeight(30);
		final JScrollPane scrollPane = new JScrollPane(resultTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		resultTable.setModel(d.getNomina());
		resultTable.setFocusable(true);
		resultTable.setRowSelectionAllowed(true);

		resultTable.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("tableCellEditor".equals(evt.getPropertyName())) {
					recalcular();
				}
			}
		});

		resultTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				// System.out.println("Row: " + resultTable.getSelectedRow());
				table.setValueAt(horas[resultTable.getSelectedRow()][0], 0, 1);
				table.setValueAt(horas[resultTable.getSelectedRow()][1], 1, 1);
				table.setValueAt(horas[resultTable.getSelectedRow()][2], 2, 1);
				table.setValueAt(horas[resultTable.getSelectedRow()][3], 3, 1);
				table.setValueAt(horas[resultTable.getSelectedRow()][4], 4, 1);
				table.setValueAt(horas[resultTable.getSelectedRow()][5], 5, 1);

			}

		});

		JPanel panel_1 = new JPanel();

		JScrollPane scrollPane_1 = new JScrollPane();

		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1259, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPane_1,
												GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE).addGap(8)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 135,
												GroupLayout.PREFERRED_SIZE)
										.addGap(2))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
										.addContainerGap()))));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Dialog", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Regular", new Double(0.0) }, { "Enfermedad", new Double(0.0) },
						{ "Vacaciones", new Double(0.0) }, { "Feriado", new Double(0.0) },
						{ "Materndad", new Double(0.0) }, { "Total", new Double(0.0) }, },
				new String[] { "", "Horas" }) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { String.class, Double.class };

			@SuppressWarnings("unchecked")
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		table.setRowHeight(20);

		table.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					// if(horas[resultTable.getSelectedRow()][0]==null ||
					// horas[resultTable.getSelectedRow()][1]==null ||
					// horas[resultTable.getSelectedRow()][2]==null ||
					// horas[resultTable.getSelectedRow()][3]==null ||
					// horas[resultTable.getSelectedRow()][4]==null ||
					// horas[resultTable.getSelectedRow()][5]==null) {
					// throw new Exception();
					// }else {

					// System.out.println(evt.getPropertyName());
					if ("tableCellEditor".equals(evt.getPropertyName())) {
						Double resul = (Double) table.getValueAt(0, 1) + (Double) table.getValueAt(1, 1)
								+ (Double) table.getValueAt(2, 1) + (Double) table.getValueAt(3, 1)
								+ (Double) table.getValueAt(4, 1);
						table.setValueAt(resul, 5, 1);
						horas[resultTable.getSelectedRow()][0] = (Double) table.getValueAt(0, 1);
						horas[resultTable.getSelectedRow()][1] = (Double) table.getValueAt(1, 1);
						horas[resultTable.getSelectedRow()][2] = (Double) table.getValueAt(2, 1);
						horas[resultTable.getSelectedRow()][3] = (Double) table.getValueAt(3, 1);
						horas[resultTable.getSelectedRow()][4] = (Double) table.getValueAt(4, 1);
						horas[resultTable.getSelectedRow()][5] = (Double) table.getValueAt(5, 1);

						resultTable.setValueAt(resul, resultTable.getSelectedRow(), 5);
						recalcular(resultTable.getSelectedRow());
					}
					// }
				} catch (Exception e1) {
					ErrorFrame exc = new ErrorFrame(e1, "Error Validando: no pueden haber 0's en los campos");
					exc.setVisible(true);
					exc.toFront();
					exc.requestFocus();
					e1.printStackTrace();
				}
			}
		});

		scrollPane_1.setViewportView(table);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		final JButton btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.gridwidth = 2;
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 0;
		panel_1.add(btnEliminar, gbc_btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

				((DefaultTableModel) resultTable.getModel()).removeRow(resultTable.getSelectedRow());

			}
		});
		btnEliminar.setFont(new Font("Dialog", Font.PLAIN, 20));

		final JComboBox<Object> comboBox = new JComboBox<Object>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		panel_1.add(comboBox, gbc_comboBox);
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<Object>(d.getNominaDates().toArray()));

		final JButton btnValidarEImprimir = new JButton("Validar e Imprimir Reporte");
		GridBagConstraints gbc_btnValidarEImprimir = new GridBagConstraints();
		gbc_btnValidarEImprimir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValidarEImprimir.gridwidth = 2;
		gbc_btnValidarEImprimir.insets = new Insets(0, 0, 5, 5);
		gbc_btnValidarEImprimir.gridx = 0;
		gbc_btnValidarEImprimir.gridy = 1;
		panel_1.add(btnValidarEImprimir, gbc_btnValidarEImprimir);
		btnValidarEImprimir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				try {
					if (validarNomina()) {
						agregarTotales();
						final MessageFormat headerFormat = new MessageFormat("Reporte de Nomina: " + fecha);
						final MessageFormat footerFormat = new MessageFormat("- {0} -");

						d.registrarNomina(resultTable, horas, fecha);
						resultTable.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
						btnValidarEImprimir.setEnabled(false);
					} else {

					}

				} catch (final PrinterException e) {
					ErrorFrame exc = new ErrorFrame(e,
							"Error Indocumentado. Verifica los totales y los campos de horas.");
					exc.setVisible(true);
					exc.toFront();
					exc.requestFocus();
					e.printStackTrace();
				}
			}
		});
		btnValidarEImprimir.setFont(new Font("Dialog", Font.PLAIN, 20));

		final JButton btnAbrirRecordDe = new JButton("Abrir record de Nomina");
		GridBagConstraints gbc_btnAbrirRecordDe = new GridBagConstraints();
		gbc_btnAbrirRecordDe.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbrirRecordDe.insets = new Insets(0, 0, 5, 5);
		gbc_btnAbrirRecordDe.gridx = 2;
		gbc_btnAbrirRecordDe.gridy = 1;
		panel_1.add(btnAbrirRecordDe, gbc_btnAbrirRecordDe);
		btnAbrirRecordDe.setEnabled(false);
		btnAbrirRecordDe.setFont(new Font("Dialog", Font.PLAIN, 20));

		final JButton btnValidarECheques = new JButton("Validar e Imprimir Todos los Cheques");
		GridBagConstraints gbc_btnValidarECheques = new GridBagConstraints();
		gbc_btnValidarECheques.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnValidarECheques.gridwidth = 2;
		gbc_btnValidarECheques.insets = new Insets(0, 0, 0, 5);
		gbc_btnValidarECheques.gridx = 0;
		gbc_btnValidarECheques.gridy = 2;
		panel_1.add(btnValidarECheques, gbc_btnValidarECheques);
		btnValidarECheques.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {

				recalcular();
				if (validarNomina()) {
					try {
						for (int i = 0; i < resultTable.getRowCount(); i++) {
							generarCheque(i, Double.parseDouble(resultTable.getModel().getValueAt(i, 14).toString()))
									.print(null, null, false, null, null, true);
						}
					} catch (final PrinterException e2) {
						ErrorFrame exc = new ErrorFrame(e2, "Error Indocumentado. Verifica los totales");
						exc.setVisible(true);
						exc.toFront();
						exc.requestFocus();
						e2.printStackTrace();
					}
				}
			}
		});
		btnValidarECheques.setFont(new Font("Dialog", Font.PLAIN, 20));

		final JButton btnImprimirCheque = new JButton("Imprimir Cheque");
		GridBagConstraints gbc_btnImprimirCheque = new GridBagConstraints();
		gbc_btnImprimirCheque.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimirCheque.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimirCheque.gridx = 2;
		gbc_btnImprimirCheque.gridy = 2;
		panel_1.add(btnImprimirCheque, gbc_btnImprimirCheque);
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
					} catch (final PrinterException e2) {
						// TODO Auto-generated catch block
						// #FIXME ADD POP UP MESAGE FOR ERRORS IN NEGATIVE AMMOUNTS
						e2.printStackTrace();
					}

				}

			}
		});

		FillHourArray();
		getContentPane().setLayout(groupLayout);

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
			total += Double.parseDouble(resultTable.getModel().getValueAt(i, 3).toString());// add salario to total
			// calculate p/h salary
			total += Double.parseDouble(resultTable.getModel().getValueAt(i, 4).toString())

					* Double.parseDouble(resultTable.getModel().getValueAt(i, 5).toString());
			// calculate tax
			tax = Double.parseDouble(
					df2.format(((Double.parseDouble( resultTable.getModel().getValueAt(i, 6).toString()) / 100) * total)));
			// calculate FICA

			Fica = Double.parseDouble(
					df2.format(Double.parseDouble(resultTable.getModel().getValueAt(i, 8).toString()) / 100 * total));

			ded = Double.parseDouble(resultTable.getModel().getValueAt(i, 12).toString());// add salario to total
			cred = Double.parseDouble(resultTable.getModel().getValueAt(i, 13).toString());// add salario to
			// total

			/*
			 * // add salary total += Double.parseDouble((String)
			 * resultTable.getModel().getValueAt(i, 3));// add salario to total // calculate
			 * p/h salary total += (Double.parseDouble((String)
			 * resultTable.getModel().getValueAt(i, 4))
			 * 
			 * (Double.parseDouble((String) resultTable.getModel().getValueAt(i, 5)))); //
			 * calculate tax tax = Double.parseDouble(
			 * df2.format(((Double.parseDouble((String) resultTable.getModel().getValueAt(i,
			 * 6)) / 100) * total))); // calculate FICA
			 * 
			 * Fica = Double.parseDouble(
			 * df2.format(Double.parseDouble(resultTable.getModel().getValueAt(i,
			 * 8).toString()) / 100 * total));
			 * 
			 * ded = Double.parseDouble(resultTable.getModel().getValueAt(i,
			 * 12).toString());// add salario to total cred = Double.parseDouble((String)
			 * resultTable.getModel().getValueAt(i, 13).toString());// add salario to //
			 * total
			 */

			final Double totalFinal = Double.parseDouble(df2.format(total - Fica - tax - ded + cred
					- Double.parseDouble((String) resultTable.getModel().getValueAt(i, 10))
					- Double.parseDouble((String) resultTable.getModel().getValueAt(i, 11))));
			resultTable.setValueAt(tax, i, 7);
			resultTable.setValueAt(Fica, i, 9);
			resultTable.setValueAt(totalFinal, i, 14);
		}
	}

	public void recalcular(int i) {
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
				* (Double) resultTable.getModel().getValueAt(i, 5));
		// calculate tax
		tax = Double.parseDouble(
				df2.format(((Double.parseDouble((String) resultTable.getModel().getValueAt(i, 6)) / 100) * total)));
		// calculate FICA

		Fica = Double.parseDouble(
				df2.format(Double.parseDouble(resultTable.getModel().getValueAt(i, 8).toString()) / 100 * total));

		ded = Double.parseDouble(resultTable.getModel().getValueAt(i, 12).toString());// add salario to total
		cred = Double.parseDouble(resultTable.getModel().getValueAt(i, 13).toString());// add salario to
		// total

		final Double totalFinal = Double.parseDouble(df2.format(
				total - Fica - tax - ded + cred - Double.parseDouble((String) resultTable.getModel().getValueAt(i, 10))
						- Double.parseDouble((String) resultTable.getModel().getValueAt(i, 11))));
		resultTable.setValueAt(tax, i, 7);
		resultTable.setValueAt(Fica, i, 9);
		resultTable.setValueAt(totalFinal, i, 14);

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

	public void FillHourArray() {
		// System.out.println("Row Count: " + resultTable.getRowCount());
		horas = new Double[resultTable.getRowCount()][6];
		for (Double[] row : horas)
			Arrays.fill(row, 0.0);
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
		final Font h = new Font("Helvetica", Font.PLAIN, 10);
		textArea.setFont(h);
		textArea.setAlignmentY(Component.CENTER_ALIGNMENT);
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textArea.append("ACADEMIA COOPERATIVA DE INTEGRACION SOCIAL\n");
		textArea.append(resultTable.getModel().getValueAt(row, 0).toString() + " : "
				+ resultTable.getModel().getValueAt(row, 2).toString() + "\n");

		final Empleados emp = new Empleados(
				d.getEmployeeById(Integer.parseInt(resultTable.getModel().getValueAt(row, 0).toString())));
		final String acct = emp.getChartOfAcct();

		textArea.append("----------HORAS PAGADAS---------- PERIODO TERMINADO EN:" + fechaCorta + "\n");
		textArea.append("\n");
		
		textArea.append("Salario \tCosto P/H \tTax \tFICA \tPlan Medico \tCancer \n");

		textArea.append(
				  resultTable.getModel().getValueAt(row, 3).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 4).toString() + "$\t"			
				+ resultTable.getModel().getValueAt(row, 7).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 9).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 10).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 11).toString() + "$\n");
		textArea.append("Regular \tEnfermedad \tVacaciones \tFeriado \tMaternidad \tHoras Total \n");
		textArea.append(
				  horas[row][0].toString() + "\t"
				+ horas[row][1].toString() + "\t"
				+ horas[row][2].toString() + "\t"
				+ horas[row][3].toString() + "\t"
				+ horas[row][4].toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 5).toString() + "\n");	
		textArea.append("Ded \tCred \tTotal\n");
		textArea.append(resultTable.getModel().getValueAt(row, 12).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 13).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 14).toString() + "$\n");
		

		textArea.append("\n\n\n\n\n\n\n\n\n\n\n\n");

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

		textArea.append("Salario \tCosto P/H \tTax \tFICA \tPlan Medico \tCancer \n");

		textArea.append(
				  resultTable.getModel().getValueAt(row, 3).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 4).toString() + "$\t"			
				+ resultTable.getModel().getValueAt(row, 7).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 9).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 10).toString() +"$\t"
				+ resultTable.getModel().getValueAt(row, 11).toString() +"$\n");
		textArea.append("Regular \tEnfermedad \tVacaciones \tFeriado \tMaternidad \tHoras Total \n");
		textArea.append(
				  horas[row][0].toString() + "\t"
				+ horas[row][1].toString() + "\t"
				+ horas[row][2].toString() + "\t"
				+ horas[row][3].toString() + "\t"
				+ horas[row][4].toString() + "\t"
				+ resultTable.getModel().getValueAt(row, 5).toString() + "\n");	
		textArea.append("Ded \tCred \tTotal\n");
		textArea.append(resultTable.getModel().getValueAt(row, 12).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 13).toString() + "$\t"
				+ resultTable.getModel().getValueAt(row, 14).toString() + "$\n"
		);
		return textArea;
	}
}
