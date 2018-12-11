package iconix.appkademyj.estudiante;

import java.awt.Component;
import java.awt.EventQueue;
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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import iconix.appkademyj.util.ErrorFrame;
import iconix.database.DatabaseConnect;

public class HacerPago extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8329994283932528361L;
	private final JTextField cantidad;
	private final JTextField balance;
	private final JTextField pago;
	private final JTextField recargo;
	private final JTextField fecharecargo;
	private final JTextField fechapago;
	private final JTextField ahorro;
	private final JTextField recibo;
	private final JTable editTable;
	private final JTable historialTable;
	private final Estudiante e;
	private final String termino;
	private final String fecha;
	private final DatabaseConnect d;
	private Double tempRecargo=0.0;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					final HacerPago frame = new HacerPago(new Estudiante(), "2016 - 2017");
					frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * FALTA --asegurar que este selecconado uno de los meses o hacer pagos globales
	 * posbles --matematcas de hacer pagos
	 * 
	 */

	/**
	 * Create the frame.
	 */
	public HacerPago(final Estudiante e, final String semestre) {
		setMaximizable(true);
		try {
			setSelected(true);
		} catch (final PropertyVetoException e1) {
			ErrorFrame exc = new ErrorFrame(e1, "Error Creando Estudiante");
			exc.setVisible(true);
			exc.toFront();
			exc.requestFocus();
			e1.printStackTrace();
		}
		d = new DatabaseConnect();

		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		final Date date = new Date();
		fecha = dateFormat.format(date);
		this.e = e;
		termino = semestre;

		setClosable(true);
		setBounds(100, 100, 1121, 570);
		setTitle("Hacer Pago de Estudiante: " + e.getNombre() + " Termino:" + termino);
		final JPanel panel_2 = new JPanel();

		historialTable = new JTable();
		historialTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		historialTable.setRowHeight(30);
		editTable = new JTable();
		editTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(final ListSelectionEvent event) {
				if (editTable.getSelectedRow() > -1) {
					// print first column value from selected row
					balance.setText(editTable.getValueAt(editTable.getSelectedRow(), 2).toString());
					cantidad.setText(editTable.getValueAt(editTable.getSelectedRow(), 1).toString());
					recargo.setText(editTable.getValueAt(editTable.getSelectedRow(), 3).toString());
					
					tempRecargo = Double.parseDouble(editTable.getValueAt(editTable.getSelectedRow(), 3).toString());
					
//					recargo2.setText(editTable.getValueAt(editTable.getSelectedRow(), 4).toString());
					pago.setText("0");
					ahorro.setText(editTable.getValueAt(editTable.getSelectedRow(), 4).toString());
					recibo.setText("0");

					historialTable.setModel(d.getPaymentHistory(e, termino,
							editTable.getValueAt(editTable.getSelectedRow(), 0).toString()));
					historialTable.setFocusable(true);
					historialTable.setRowSelectionAllowed(true);

				}
			}
		});
		editTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		editTable.setRowHeight(30);

		final JScrollPane editScroll = new JScrollPane(editTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		final JScrollPane historialScroll = new JScrollPane(historialTable,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(editScroll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(historialScroll, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(historialScroll, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(editScroll, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addGap(98)));

		editScroll.setViewportView(editTable);
		final GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		final JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidad.gridx = 0;
		gbc_lblCantidad.gridy = 0;
		panel_2.add(lblCantidad, gbc_lblCantidad);

		cantidad = new JTextField();
		cantidad.setEditable(false);
		final GridBagConstraints gbc_cantidad = new GridBagConstraints();
		gbc_cantidad.gridwidth = 3;
		gbc_cantidad.insets = new Insets(0, 0, 5, 0);
		gbc_cantidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_cantidad.gridx = 2;
		gbc_cantidad.gridy = 0;
		panel_2.add(cantidad, gbc_cantidad);
		cantidad.setColumns(10);

		final JLabel label = new JLabel("");
		final GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		panel_2.add(label, gbc_label);

		final JLabel lblBalancePendiente = new JLabel("Balance Pendiente");
		lblBalancePendiente.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblBalancePendiente = new GridBagConstraints();
		gbc_lblBalancePendiente.insets = new Insets(0, 0, 5, 5);
		gbc_lblBalancePendiente.gridx = 0;
		gbc_lblBalancePendiente.gridy = 2;
		panel_2.add(lblBalancePendiente, gbc_lblBalancePendiente);

		balance = new JTextField();
		balance.setEditable(false);
		final GridBagConstraints gbc_balance = new GridBagConstraints();
		gbc_balance.anchor = GridBagConstraints.SOUTH;
		gbc_balance.gridwidth = 3;
		gbc_balance.insets = new Insets(0, 0, 5, 0);
		gbc_balance.fill = GridBagConstraints.HORIZONTAL;
		gbc_balance.gridx = 2;
		gbc_balance.gridy = 2;
		panel_2.add(balance, gbc_balance);
		balance.setColumns(10);

		final JLabel lblPago = new JLabel("Pago");
		lblPago.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblPago = new GridBagConstraints();
		gbc_lblPago.insets = new Insets(0, 0, 5, 5);
		gbc_lblPago.gridx = 0;
		gbc_lblPago.gridy = 3;
		panel_2.add(lblPago, gbc_lblPago);

		pago = new JTextField();
		final GridBagConstraints gbc_pago = new GridBagConstraints();
		gbc_pago.gridwidth = 3;
		gbc_pago.insets = new Insets(0, 0, 5, 0);
		gbc_pago.fill = GridBagConstraints.HORIZONTAL;
		gbc_pago.gridx = 2;
		gbc_pago.gridy = 3;
		panel_2.add(pago, gbc_pago);
		pago.setColumns(10);

		final JSeparator separator = new JSeparator();
		final GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 5;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		panel_2.add(separator, gbc_separator);

		final JLabel lblFechaPago = new JLabel("Fecha Pago");
		lblFechaPago.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblFechaPago = new GridBagConstraints();
		gbc_lblFechaPago.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaPago.gridx = 0;
		gbc_lblFechaPago.gridy = 5;
		panel_2.add(lblFechaPago, gbc_lblFechaPago);

		fechapago = new JTextField();
		final GridBagConstraints gbc_fechapago = new GridBagConstraints();
		gbc_fechapago.gridwidth = 2;
		gbc_fechapago.insets = new Insets(0, 0, 5, 5);
		gbc_fechapago.fill = GridBagConstraints.HORIZONTAL;
		gbc_fechapago.gridx = 2;
		gbc_fechapago.gridy = 5;
		panel_2.add(fechapago, gbc_fechapago);
		fechapago.setColumns(10);
		fechapago.setText(fecha);

		final JLabel lblRecargo = new JLabel("Recargo");
		lblRecargo.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblRecargo = new GridBagConstraints();
		gbc_lblRecargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblRecargo.gridx = 0;
		gbc_lblRecargo.gridy = 6;
		panel_2.add(lblRecargo, gbc_lblRecargo);

		recargo = new JTextField();
		final GridBagConstraints gbc_recargo = new GridBagConstraints();
		gbc_recargo.insets = new Insets(0, 0, 5, 5);
		gbc_recargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_recargo.gridx = 2;
		gbc_recargo.gridy = 6;
		panel_2.add(recargo, gbc_recargo);
		recargo.setColumns(10);

		final JLabel lblFechaRecargo = new JLabel("Fecha Recargo");
		lblFechaRecargo.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblFechaRecargo = new GridBagConstraints();
		gbc_lblFechaRecargo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaRecargo.gridx = 0;
		gbc_lblFechaRecargo.gridy = 7;
		panel_2.add(lblFechaRecargo, gbc_lblFechaRecargo);

		fecharecargo = new JTextField();
		final GridBagConstraints gbc_fecharecargo = new GridBagConstraints();
		gbc_fecharecargo.gridwidth = 2;
		gbc_fecharecargo.insets = new Insets(0, 0, 5, 5);
		gbc_fecharecargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_fecharecargo.gridx = 2;
		gbc_fecharecargo.gridy = 7;
		panel_2.add(fecharecargo, gbc_fecharecargo);
		fecharecargo.setColumns(10);
		fecharecargo.setText(fecha);

		final JSeparator separator_1 = new JSeparator();
		final GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 5;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 8;
		panel_2.add(separator_1, gbc_separator_1);

		final JLabel lblAhorro = new JLabel("Ahorro");
		lblAhorro.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblAhorro = new GridBagConstraints();
		gbc_lblAhorro.insets = new Insets(0, 0, 5, 5);
		gbc_lblAhorro.gridx = 0;
		gbc_lblAhorro.gridy = 9;
		panel_2.add(lblAhorro, gbc_lblAhorro);

		ahorro = new JTextField();
		final GridBagConstraints gbc_ahorro = new GridBagConstraints();
		gbc_ahorro.gridwidth = 3;
		gbc_ahorro.insets = new Insets(0, 0, 5, 0);
		gbc_ahorro.fill = GridBagConstraints.HORIZONTAL;
		gbc_ahorro.gridx = 2;
		gbc_ahorro.gridy = 9;
		panel_2.add(ahorro, gbc_ahorro);
		ahorro.setColumns(10);

		final JLabel lblRecibo = new JLabel("Recibo");
		lblRecibo.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblRecibo = new GridBagConstraints();
		gbc_lblRecibo.insets = new Insets(0, 0, 5, 5);
		gbc_lblRecibo.gridx = 0;
		gbc_lblRecibo.gridy = 10;
		panel_2.add(lblRecibo, gbc_lblRecibo);

		recibo = new JTextField();
		final GridBagConstraints gbc_recibo = new GridBagConstraints();
		gbc_recibo.insets = new Insets(0, 0, 5, 0);
		gbc_recibo.gridwidth = 3;
		gbc_recibo.fill = GridBagConstraints.HORIZONTAL;
		gbc_recibo.gridx = 2;
		gbc_recibo.gridy = 10;
		panel_2.add(recibo, gbc_recibo);
		recibo.setColumns(10);

		final JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				pagarMes();

			}
		});
		final GridBagConstraints gbc_btnPagar = new GridBagConstraints();
		gbc_btnPagar.insets = new Insets(0, 0, 0, 5);
		gbc_btnPagar.gridx = 2;
		gbc_btnPagar.gridy = 11;
		panel_2.add(btnPagar, gbc_btnPagar);

		final JButton btnImprimirReporte = new JButton("Imprimir Reporte");
		btnImprimirReporte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {

				final JTextArea textArea = new JTextArea();

				textArea.setAlignmentY(Component.CENTER_ALIGNMENT);
				textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
				textArea.append("ACADEMIA COOPERATIVA DE INTEGRACION SOCIAL\n");
				textArea.append("URB. VALLE TOLIMA D1 CALLE LUIS VIGOREAUX\n");
				textArea.append("Cagual, Puerto Rico 00727-2310\n");
				textArea.append("Tel: 787-746-7523 Fax: 787-746-7523\n\n\n");
				textArea.append("Estado de Cuenta: " + fecha + "\n");// FECHA
				textArea.append(e.getNombre() + "\n");// nombre estudiante
				textArea.append("SEMESTE: " + e.getSemestre() + "   " + "AÑO: " + e.getAno_Estudiante() + "  "
						+ "GRADO: " + e.getGrado() + "\n");// semestre año grado
				textArea.append("\n");

				double sum = 0.00;
				for (int i = 0; i < 15; i++) {
					System.out.println(Double.parseDouble(editTable.getValueAt(i, 2).toString()));
					sum += Double.parseDouble(editTable.getValueAt(i, 2).toString());
					sum += Double.parseDouble(editTable.getValueAt(i, 3).toString())
							- Double.parseDouble(editTable.getValueAt(i, 4).toString());
				}
				textArea.append("BALANCE PENDIENTE: +" + sum + "\n");

				try {
					final MessageFormat headerFormat = new MessageFormat(
							e.getNombre() + " Reporte de Pagos: " + termino);
					final MessageFormat headerFormat2 = new MessageFormat(
							e.getNombre() + " Historial de Pagos: " + termino);
					final MessageFormat footerFormat = new MessageFormat("- {0} -");
					historialTable.setModel(d.getFullPaymentHistory(e, termino));
					historialTable.getColumnModel().getColumn(0).setPreferredWidth(40);
					historialTable.getColumnModel().getColumn(4).setPreferredWidth(40);
					historialTable.getColumnModel().getColumn(5).setPreferredWidth(40);
					historialTable.getColumnModel().getColumn(3).setPreferredWidth(100);

					textArea.print();
					editTable.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
					historialTable.print(PrintMode.FIT_WIDTH, headerFormat2, footerFormat);
				} catch (final PrinterException e1) {
					ErrorFrame exc = new ErrorFrame(e1, "Error de printer no documentado.");
					exc.setVisible(true);
					exc.toFront();
					exc.requestFocus();
					e1.printStackTrace();
				}
			}
		});
		final GridBagConstraints gbc_btnImprimirReporte = new GridBagConstraints();
		gbc_btnImprimirReporte.insets = new Insets(0, 0, 0, 5);
		gbc_btnImprimirReporte.gridx = 3;
		gbc_btnImprimirReporte.gridy = 11;
		panel_2.add(btnImprimirReporte, gbc_btnImprimirReporte);
		getContentPane().setLayout(groupLayout);
		loadData();

	}

	public void loadData() {
		// DatabaseConnect d = new DatabaseConnect();
		editTable.setModel(d.getStudentPayments(e, termino));
		editTable.setFocusable(true);
		editTable.setRowSelectionAllowed(true);
		historialTable.setModel(d.getFullPaymentHistory(e, termino));

	}

	public static boolean isNumeric(final String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	public boolean pagarMes() {

		if (!isNumeric(pago.getText())) {
			return false;
		}
		if (Double.parseDouble(pago.getText()) > Double.parseDouble(cantidad.getText())) {
			// create whole balance calculations here possibly through iteration of balances
			// due
			// this would create too may queries try to calculate and do everything before
			// excecuting. Maybe recursion?
			JOptionPane.showMessageDialog(null, "Cantidad es Mayor que lo debido");
			return false;
		}
		// history or data calculations first?
		d.issuePayment(e.getID(), editTable.getValueAt(editTable.getSelectedRow(), 0).toString(),
				Double.parseDouble(pago.getText()), Double.parseDouble(balance.getText()),
				Double.parseDouble(recargo.getText()),
				tempRecargo
						- Double.parseDouble(editTable.getValueAt(editTable.getSelectedRow(), 4).toString()),
				Double.parseDouble(ahorro.getText()), recibo.getText(), fechapago.getText(), termino);

		updateTables();
		cantidad.setText("");
		balance.setText("");
		pago.setText("");
		recargo.setText("");
		ahorro.setText("");
		recibo.setText("");
		return false;
	}

	public void updateTables() {
		historialTable.setModel(
				d.getPaymentHistory(e, termino, editTable.getValueAt(editTable.getSelectedRow(), 0).toString()));
		historialTable.setFocusable(true);
		historialTable.setRowSelectionAllowed(true);
		editTable.setModel(d.getStudentPayments(e, termino));
		editTable.setFocusable(true);
		editTable.setRowSelectionAllowed(true);
	}
}
