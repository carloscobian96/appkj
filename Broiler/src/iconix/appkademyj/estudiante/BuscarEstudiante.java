package iconix.appkademyj.estudiante;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import iconix.appkademyj.util.ErrorFrame;
import iconix.database.DatabaseConnect;

public class BuscarEstudiante extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 640243994525155259L;
	private final JTextField textfield;
	private final JTable resultTable;

	public BuscarEstudiante(final DatabaseConnect d) {
		setTitle("Buscar Estudiante");
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
		setBounds(100, 100, 1299, 508);

		resultTable = new JTable();
		resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		resultTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultTable.setRowHeight(30);
		final JScrollPane scrollPane = new JScrollPane(resultTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setEnabled(false);

		final JPanel panel = new JPanel();
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "2016 - 2017", "2017 - 2018", "2018 - 2019",
				"2019 - 2020", "2020 - 2021", "2021 - 2022" }));
		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 14;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);

		final JLabel lblBuscarEstudiante = new JLabel("Buscar Estudiante:");
		final GridBagConstraints gbc_lblBuscarEstudiante = new GridBagConstraints();
		gbc_lblBuscarEstudiante.anchor = GridBagConstraints.WEST;
		gbc_lblBuscarEstudiante.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarEstudiante.gridx = 1;
		gbc_lblBuscarEstudiante.gridy = 1;
		panel.add(lblBuscarEstudiante, gbc_lblBuscarEstudiante);

		textfield = new JTextField();
		textfield.setColumns(10);
		final GridBagConstraints gbc_textfield = new GridBagConstraints();
		gbc_textfield.insets = new Insets(0, 0, 5, 5);
		gbc_textfield.anchor = GridBagConstraints.WEST;
		gbc_textfield.gridx = 4;
		gbc_textfield.gridy = 1;
		panel.add(textfield, gbc_textfield);

		final JButton btnBuscar = new JButton("Nombre");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				resultTable.setModel(d.getStudentByName(textfield.getText(), comboBox.getSelectedItem().toString()));
				resultTable.setFocusable(true);
				resultTable.setRowSelectionAllowed(true);
			}
		});
		final GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 7;
		gbc_btnBuscar.gridy = 1;
		panel.add(btnBuscar, gbc_btnBuscar);

		final JButton btnSeguroSocal = new JButton("Seguro Social");
		btnSeguroSocal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				resultTable.setModel(d.getStudentBySSN(textfield.getText(), comboBox.getSelectedItem().toString()));
				resultTable.setFocusable(true);
				resultTable.setRowSelectionAllowed(true);
			}
		});
		final GridBagConstraints gbc_btnSeguroSocal = new GridBagConstraints();
		gbc_btnSeguroSocal.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeguroSocal.gridx = 10;
		gbc_btnSeguroSocal.gridy = 1;
		panel.add(btnSeguroSocal, gbc_btnSeguroSocal);

		final JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final Integer id = Integer.parseInt(resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString());
				final Estudiante est = new Estudiante(d.getStudentById(id));
				final EditarEstudiante a = new EditarEstudiante(est, d);
				a.setVisible(true);
				getDesktopPane().add(a);
				a.toFront();
				a.requestFocus();

			}
		});

		final JButton btnGrado = new JButton("Grado");
		btnGrado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				resultTable.setModel(d.getStudentByGrade(textfield.getText(), comboBox.getSelectedItem().toString()));
				resultTable.setFocusable(true);
				resultTable.setRowSelectionAllowed(true);
			}
		});
		final GridBagConstraints gbc_btnGrado = new GridBagConstraints();
		gbc_btnGrado.insets = new Insets(0, 0, 5, 5);
		gbc_btnGrado.gridx = 12;
		gbc_btnGrado.gridy = 1;
		panel.add(btnGrado, gbc_btnGrado);

		final GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.anchor = GridBagConstraints.WEST;
		gbc_btnEditar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditar.gridx = 1;
		gbc_btnEditar.gridy = 3;
		panel.add(btnEditar, gbc_btnEditar);

		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1240, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
				.addContainerGap()));

		final JButton btnHacerPago = new JButton("Pagos");
		btnHacerPago.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final Integer id = Integer.parseInt(resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString());
				final Estudiante est = new Estudiante(d.getStudentById(id));
				final HacerPago a = new HacerPago(est, comboBox.getSelectedItem().toString());
				a.setVisible(true);
				getDesktopPane().add(a);
				a.toFront();
				a.requestFocus();

			}
		});

		final JButton btnPrestamo = new JButton("Desactivar");
		btnPrestamo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {

				final Integer id = Integer.parseInt(resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString());
				final int response = JOptionPane.showConfirmDialog(null, "Desea Desactivar a este estudiante?",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					d.deactivateStudentByID(id);
					JOptionPane.showMessageDialog(null, "Estudiante Eliminado", "Estudiante Eliminado",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		final GridBagConstraints gbc_btnPrestamo = new GridBagConstraints();
		gbc_btnPrestamo.anchor = GridBagConstraints.WEST;
		gbc_btnPrestamo.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrestamo.gridx = 4;
		gbc_btnPrestamo.gridy = 3;
		panel.add(btnPrestamo, gbc_btnPrestamo);
		final GridBagConstraints gbc_btnHacerPago = new GridBagConstraints();
		gbc_btnHacerPago.anchor = GridBagConstraints.WEST;
		gbc_btnHacerPago.insets = new Insets(0, 0, 5, 5);
		gbc_btnHacerPago.gridx = 7;
		gbc_btnHacerPago.gridy = 3;
		panel.add(btnHacerPago, gbc_btnHacerPago);
		getContentPane().setLayout(groupLayout);

	}
}
