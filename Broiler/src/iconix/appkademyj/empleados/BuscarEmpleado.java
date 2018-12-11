package iconix.appkademyj.empleados;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import iconix.appkademyj.util.ErrorFrame;
import iconix.database.DatabaseConnect;

public class BuscarEmpleado extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8078984546431618671L;
	private final JTable resultTable;
	private final JTextField textfield;

	public BuscarEmpleado(final DatabaseConnect d) {
		setTitle("Buscar Empleado");

		try {
			setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			ErrorFrame frame = new ErrorFrame(e, "");
			frame.setVisible(true);
		}

		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 1299, 500);

		resultTable = new JTable();
		resultTable.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultTable.setRowHeight(30);
		final JScrollPane scrollPane = new JScrollPane(resultTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		final JPanel panel_1 = new JPanel();

		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1253,
										Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1253,
										Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE).addContainerGap()));
		final GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		final JLabel lblBuscarEstudiante = new JLabel("Buscar Empleado:");
		final GridBagConstraints gbc_lblBuscarEstudiante = new GridBagConstraints();
		gbc_lblBuscarEstudiante.insets = new Insets(0, 0, 0, 5);
		gbc_lblBuscarEstudiante.gridx = 1;
		gbc_lblBuscarEstudiante.gridy = 1;
		panel_1.add(lblBuscarEstudiante, gbc_lblBuscarEstudiante);

		textfield = new JTextField();
		final GridBagConstraints gbc_textfield = new GridBagConstraints();
		gbc_textfield.insets = new Insets(0, 0, 0, 5);
		gbc_textfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_textfield.gridx = 3;
		gbc_textfield.gridy = 1;
		panel_1.add(textfield, gbc_textfield);
		textfield.setColumns(10);

		final JButton btnBuscar = new JButton("Nombre");
		final GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscar.gridx = 5;
		gbc_btnBuscar.gridy = 1;
		panel_1.add(btnBuscar, gbc_btnBuscar);

		final JButton btnSeguroSocal = new JButton("Seguro Social");
		final GridBagConstraints gbc_btnSeguroSocal = new GridBagConstraints();
		gbc_btnSeguroSocal.insets = new Insets(0, 0, 0, 5);
		gbc_btnSeguroSocal.gridx = 7;
		gbc_btnSeguroSocal.gridy = 1;
		panel_1.add(btnSeguroSocal, gbc_btnSeguroSocal);

		final JButton btnEditar = new JButton("Editar");
		final GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 9;
		gbc_btnEditar.gridy = 1;
		panel_1.add(btnEditar, gbc_btnEditar);

		final JButton btnDesactivarEmpleado = new JButton("Desactivar Empleado");
		btnDesactivarEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {

				final Integer id = Integer.parseInt(resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString());
				final int response = JOptionPane.showConfirmDialog(null, "Desea Desactivar a este empleado??",
						"Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (response == JOptionPane.YES_OPTION) {
					d.deactivateEmployeeByID(id);
					JOptionPane.showMessageDialog(null, "Empleado Eliminado", "Empleado Eliminado",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		final GridBagConstraints gbc_btnDesactivarEmpleado = new GridBagConstraints();
		gbc_btnDesactivarEmpleado.gridx = 11;
		gbc_btnDesactivarEmpleado.gridy = 1;
		panel_1.add(btnDesactivarEmpleado, gbc_btnDesactivarEmpleado);
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {

				final Integer id = Integer.parseInt(resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString());
				final EmpleadoOld emp = new EmpleadoOld(d.getEmployeeById(id));
				final EditarEmpleado a = new EditarEmpleado(emp, d);
				a.setVisible(true);
				getDesktopPane().add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		btnSeguroSocal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				resultTable.setModel(d.getEmployeeBySSN(textfield.getText()));
				resultTable.setFocusable(true);
				resultTable.setRowSelectionAllowed(true);
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				resultTable.setModel(d.getEmployeeByName(textfield.getText()));
				resultTable.setFocusable(true);
				resultTable.setRowSelectionAllowed(true);
			}
		});
		getContentPane().setLayout(groupLayout);

	}
}
