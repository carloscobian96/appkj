package broiler.abstraction;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//import iconix.appkademyj.estudiante.EditarEstudiante;
//import iconix.appkademyj.util.ErrorFrame;
//import iconix.database.DatabaseConnect;

public class CrearEmpleado2 extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7227620850319182665L;
	private final JTextField nombreField;
	private final JTextField ssnField;
	private final JTextField dependientesField;
	private final JTextField nacimientoField;
	private final JTextField empleoField;
	private final JTextField telefonoField;
	private final JTextField posicionField;
	private final JTextField estadoCivilField;
	private final JTextField acctField;
	private final JTextField postalField;
	private final JTextField fisicaField;
	private final JTextField salarioField;
	private final ButtonGroup salarioHora = new ButtonGroup();
	private final JTextField planCancerField;
	private final JTextField planMedicoField;
	private final JTextField taxField;
	private final JTextField totalPagadoField;
	private final JTextField dedField;
	private final JTextField credField;

	public CrearEmpleado2(final DatabaseConnect d) {
		setClosable(true);
		setTitle("Crear Empleado");
		setBounds(100, 100, 927, 609);

		final JPanel panel = new JPanel();
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE).addContainerGap()));
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		nombreField = new JTextField();
		final GridBagConstraints gbc_nombreField = new GridBagConstraints();
		gbc_nombreField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreField.gridx = 3;
		gbc_nombreField.gridy = 1;
		panel.add(nombreField, gbc_nombreField);
		nombreField.setColumns(10);

		final JRadioButton rdbtnSalarioQuincenal = new JRadioButton("Salario Quincenal");
		rdbtnSalarioQuincenal.setSelected(true);
		rdbtnSalarioQuincenal.setFont(new Font("Dialog", Font.PLAIN, 20));
		salarioHora.add(rdbtnSalarioQuincenal);
		final GridBagConstraints gbc_rdbtnSalarioQuincenal = new GridBagConstraints();
		gbc_rdbtnSalarioQuincenal.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSalarioQuincenal.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSalarioQuincenal.gridx = 5;
		gbc_rdbtnSalarioQuincenal.gridy = 1;
		panel.add(rdbtnSalarioQuincenal, gbc_rdbtnSalarioQuincenal);

		salarioField = new JTextField();
		final GridBagConstraints gbc_salarioField = new GridBagConstraints();
		gbc_salarioField.insets = new Insets(0, 0, 5, 0);
		gbc_salarioField.fill = GridBagConstraints.HORIZONTAL;
		gbc_salarioField.gridx = 7;
		gbc_salarioField.gridy = 1;
		panel.add(salarioField, gbc_salarioField);
		salarioField.setColumns(10);

		final JLabel lblNewLabel_1 = new JLabel("SSN:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		ssnField = new JTextField();
		ssnField.setColumns(10);
		final GridBagConstraints gbc_ssnField = new GridBagConstraints();
		gbc_ssnField.insets = new Insets(0, 0, 5, 5);
		gbc_ssnField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ssnField.gridx = 3;
		gbc_ssnField.gridy = 2;
		panel.add(ssnField, gbc_ssnField);

		final JRadioButton rdbtnPagaPorHora = new JRadioButton("Paga por Hora");
		rdbtnPagaPorHora.setFont(new Font("Dialog", Font.PLAIN, 20));
		salarioHora.add(rdbtnPagaPorHora);
		final GridBagConstraints gbc_rdbtnPagaPorHora = new GridBagConstraints();
		gbc_rdbtnPagaPorHora.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPagaPorHora.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPagaPorHora.gridx = 5;
		gbc_rdbtnPagaPorHora.gridy = 2;
		panel.add(rdbtnPagaPorHora, gbc_rdbtnPagaPorHora);

		final JLabel lblNumeroDeDependiented = new JLabel("Numero de Dependientes:");
		lblNumeroDeDependiented.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblNumeroDeDependiented = new GridBagConstraints();
		gbc_lblNumeroDeDependiented.anchor = GridBagConstraints.WEST;
		gbc_lblNumeroDeDependiented.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDeDependiented.gridx = 1;
		gbc_lblNumeroDeDependiented.gridy = 3;
		panel.add(lblNumeroDeDependiented, gbc_lblNumeroDeDependiented);

		dependientesField = new JTextField();
		dependientesField.setColumns(10);
		final GridBagConstraints gbc_dependientesField = new GridBagConstraints();
		gbc_dependientesField.insets = new Insets(0, 0, 5, 5);
		gbc_dependientesField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dependientesField.gridx = 3;
		gbc_dependientesField.gridy = 3;
		panel.add(dependientesField, gbc_dependientesField);

		final JLabel lblNewLabel_2 = new JLabel("Tax %");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		taxField = new JTextField();
		taxField.setText("2");
		final GridBagConstraints gbc_taxField = new GridBagConstraints();
		gbc_taxField.insets = new Insets(0, 0, 5, 0);
		gbc_taxField.fill = GridBagConstraints.HORIZONTAL;
		gbc_taxField.gridx = 7;
		gbc_taxField.gridy = 3;
		panel.add(taxField, gbc_taxField);
		taxField.setColumns(10);

		final JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 1;
		gbc_lblFechaDeNacimiento.gridy = 4;
		panel.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);

		nacimientoField = new JTextField();
		nacimientoField.setColumns(10);
		final GridBagConstraints gbc_nacimientoField = new GridBagConstraints();
		gbc_nacimientoField.insets = new Insets(0, 0, 5, 5);
		gbc_nacimientoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nacimientoField.gridx = 3;
		gbc_nacimientoField.gridy = 4;
		panel.add(nacimientoField, gbc_nacimientoField);

		final JLabel lblPlanMedico = new JLabel("Plan Medico(quincena):");
		lblPlanMedico.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblPlanMedico = new GridBagConstraints();
		gbc_lblPlanMedico.anchor = GridBagConstraints.WEST;
		gbc_lblPlanMedico.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanMedico.gridx = 5;
		gbc_lblPlanMedico.gridy = 4;
		panel.add(lblPlanMedico, gbc_lblPlanMedico);

		planMedicoField = new JTextField();
		planMedicoField.setText("34.14");
		final GridBagConstraints gbc_planMedicoField = new GridBagConstraints();
		gbc_planMedicoField.insets = new Insets(0, 0, 5, 0);
		gbc_planMedicoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_planMedicoField.gridx = 7;
		gbc_planMedicoField.gridy = 4;
		panel.add(planMedicoField, gbc_planMedicoField);
		planMedicoField.setColumns(10);

		final JLabel lblFechaDeEmpleo = new JLabel("Fecha de Empleo:");
		lblFechaDeEmpleo.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblFechaDeEmpleo = new GridBagConstraints();
		gbc_lblFechaDeEmpleo.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeEmpleo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeEmpleo.gridx = 1;
		gbc_lblFechaDeEmpleo.gridy = 5;
		panel.add(lblFechaDeEmpleo, gbc_lblFechaDeEmpleo);

		empleoField = new JTextField();
		empleoField.setColumns(10);
		final GridBagConstraints gbc_empleoField = new GridBagConstraints();
		gbc_empleoField.insets = new Insets(0, 0, 5, 5);
		gbc_empleoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_empleoField.gridx = 3;
		gbc_empleoField.gridy = 5;
		panel.add(empleoField, gbc_empleoField);

		final JLabel lblPlanCancer = new JLabel("Plan Cancer(quincena):");
		lblPlanCancer.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblPlanCancer = new GridBagConstraints();
		gbc_lblPlanCancer.anchor = GridBagConstraints.WEST;
		gbc_lblPlanCancer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanCancer.gridx = 5;
		gbc_lblPlanCancer.gridy = 5;
		panel.add(lblPlanCancer, gbc_lblPlanCancer);

		planCancerField = new JTextField();
		planCancerField.setText("30.74");
		final GridBagConstraints gbc_planCancerField = new GridBagConstraints();
		gbc_planCancerField.insets = new Insets(0, 0, 5, 0);
		gbc_planCancerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_planCancerField.gridx = 7;
		gbc_planCancerField.gridy = 5;
		panel.add(planCancerField, gbc_planCancerField);
		planCancerField.setColumns(10);

		final JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 6;
		panel.add(lblTelefono, gbc_lblTelefono);

		telefonoField = new JTextField();
		telefonoField.setColumns(10);
		final GridBagConstraints gbc_telefonoField = new GridBagConstraints();
		gbc_telefonoField.insets = new Insets(0, 0, 5, 5);
		gbc_telefonoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonoField.gridx = 3;
		gbc_telefonoField.gridy = 6;
		panel.add(telefonoField, gbc_telefonoField);

		final JLabel lblTotalPagado = new JLabel("Total Pagado:");
		lblTotalPagado.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblTotalPagado = new GridBagConstraints();
		gbc_lblTotalPagado.anchor = GridBagConstraints.WEST;
		gbc_lblTotalPagado.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalPagado.gridx = 5;
		gbc_lblTotalPagado.gridy = 6;
		panel.add(lblTotalPagado, gbc_lblTotalPagado);

		totalPagadoField = new JTextField();
		totalPagadoField.setText("0.0");
		final GridBagConstraints gbc_totalPagadoField = new GridBagConstraints();
		gbc_totalPagadoField.insets = new Insets(0, 0, 5, 0);
		gbc_totalPagadoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalPagadoField.gridx = 7;
		gbc_totalPagadoField.gridy = 6;
		panel.add(totalPagadoField, gbc_totalPagadoField);
		totalPagadoField.setColumns(10);

		final JLabel lblDireccionFisica = new JLabel("Direccion Fisica:");
		lblDireccionFisica.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblDireccionFisica = new GridBagConstraints();
		gbc_lblDireccionFisica.anchor = GridBagConstraints.WEST;
		gbc_lblDireccionFisica.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccionFisica.gridx = 1;
		gbc_lblDireccionFisica.gridy = 7;
		panel.add(lblDireccionFisica, gbc_lblDireccionFisica);

		fisicaField = new JTextField();
		final GridBagConstraints gbc_fisicaField = new GridBagConstraints();
		gbc_fisicaField.insets = new Insets(0, 0, 5, 5);
		gbc_fisicaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fisicaField.gridx = 3;
		gbc_fisicaField.gridy = 7;
		panel.add(fisicaField, gbc_fisicaField);
		fisicaField.setColumns(10);

		final JLabel lblNewLabel_3 = new JLabel("Ded");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 5;
		gbc_lblNewLabel_3.gridy = 7;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		dedField = new JTextField();
		dedField.setText("0.0");
		final GridBagConstraints gbc_dedField = new GridBagConstraints();
		gbc_dedField.insets = new Insets(0, 0, 5, 0);
		gbc_dedField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dedField.gridx = 7;
		gbc_dedField.gridy = 7;
		panel.add(dedField, gbc_dedField);
		dedField.setColumns(10);

		final JLabel lblDireccionPostal = new JLabel("Direccion Postal:");
		lblDireccionPostal.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblDireccionPostal = new GridBagConstraints();
		gbc_lblDireccionPostal.anchor = GridBagConstraints.WEST;
		gbc_lblDireccionPostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccionPostal.gridx = 1;
		gbc_lblDireccionPostal.gridy = 8;
		panel.add(lblDireccionPostal, gbc_lblDireccionPostal);

		postalField = new JTextField();
		final GridBagConstraints gbc_postalField = new GridBagConstraints();
		gbc_postalField.insets = new Insets(0, 0, 5, 5);
		gbc_postalField.fill = GridBagConstraints.HORIZONTAL;
		gbc_postalField.gridx = 3;
		gbc_postalField.gridy = 8;
		panel.add(postalField, gbc_postalField);
		postalField.setColumns(10);

		final JLabel lblCred = new JLabel("Cred:");
		lblCred.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblCred = new GridBagConstraints();
		gbc_lblCred.anchor = GridBagConstraints.WEST;
		gbc_lblCred.insets = new Insets(0, 0, 5, 5);
		gbc_lblCred.gridx = 5;
		gbc_lblCred.gridy = 8;
		panel.add(lblCred, gbc_lblCred);

		credField = new JTextField();
		credField.setText("0.0");
		final GridBagConstraints gbc_credField = new GridBagConstraints();
		gbc_credField.insets = new Insets(0, 0, 5, 0);
		gbc_credField.fill = GridBagConstraints.HORIZONTAL;
		gbc_credField.gridx = 7;
		gbc_credField.gridy = 8;
		panel.add(credField, gbc_credField);
		credField.setColumns(10);

		final JLabel lblPosicion = new JLabel("Posicion:");
		lblPosicion.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblPosicion = new GridBagConstraints();
		gbc_lblPosicion.anchor = GridBagConstraints.WEST;
		gbc_lblPosicion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosicion.gridx = 1;
		gbc_lblPosicion.gridy = 9;
		panel.add(lblPosicion, gbc_lblPosicion);

		posicionField = new JTextField();
		posicionField.setColumns(10);
		final GridBagConstraints gbc_posicionField = new GridBagConstraints();
		gbc_posicionField.insets = new Insets(0, 0, 5, 5);
		gbc_posicionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_posicionField.gridx = 3;
		gbc_posicionField.gridy = 9;
		panel.add(posicionField, gbc_posicionField);

		final JCheckBox regBox = new JCheckBox("Regular");
		regBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent e) {
				if (!regBox.isSelected()) {
					taxField.setText("0");
				} else {
					taxField.setText("2");
				}
			}
		});
		regBox.setSelected(true);
		regBox.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_regBox = new GridBagConstraints();
		gbc_regBox.anchor = GridBagConstraints.WEST;
		gbc_regBox.insets = new Insets(0, 0, 5, 5);
		gbc_regBox.gridx = 5;
		gbc_regBox.gridy = 9;
		panel.add(regBox, gbc_regBox);

		final JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblEstadoCivil = new GridBagConstraints();
		gbc_lblEstadoCivil.anchor = GridBagConstraints.WEST;
		gbc_lblEstadoCivil.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstadoCivil.gridx = 1;
		gbc_lblEstadoCivil.gridy = 10;
		panel.add(lblEstadoCivil, gbc_lblEstadoCivil);

		estadoCivilField = new JTextField();
		estadoCivilField.setColumns(10);
		final GridBagConstraints gbc_estadoCivilField = new GridBagConstraints();
		gbc_estadoCivilField.insets = new Insets(0, 0, 5, 5);
		gbc_estadoCivilField.fill = GridBagConstraints.HORIZONTAL;
		gbc_estadoCivilField.gridx = 3;
		gbc_estadoCivilField.gridy = 10;
		panel.add(estadoCivilField, gbc_estadoCivilField);

		final JLabel lblChartOfAcct = new JLabel("Chart of ACCT:");
		lblChartOfAcct.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_lblChartOfAcct = new GridBagConstraints();
		gbc_lblChartOfAcct.anchor = GridBagConstraints.WEST;
		gbc_lblChartOfAcct.insets = new Insets(0, 0, 5, 5);
		gbc_lblChartOfAcct.gridx = 1;
		gbc_lblChartOfAcct.gridy = 11;
		panel.add(lblChartOfAcct, gbc_lblChartOfAcct);

		acctField = new JTextField();
		acctField.setText("20200");
		acctField.setColumns(10);
		final GridBagConstraints gbc_acctField = new GridBagConstraints();
		gbc_acctField.insets = new Insets(0, 0, 5, 5);
		gbc_acctField.fill = GridBagConstraints.HORIZONTAL;
		gbc_acctField.gridx = 3;
		gbc_acctField.gridy = 11;
		panel.add(acctField, gbc_acctField);

		final JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				try {
					Double salario = 0.0;
					Double rate = 0.0;
					Double fica;
					if (rdbtnSalarioQuincenal.isSelected()) {
						salario = Double.parseDouble(salarioField.getText());
					} else {
						rate = Double.parseDouble(salarioField.getText());
					}
					if (regBox.isSelected()) {
						fica = 0.0765;
					} else {
						fica = 0.0;
					}

					if (verify()) {
						final Empleados e = new Empleados(nombreField.getText(), Integer.parseInt(ssnField.getText()),
								Integer.parseInt(dependientesField.getText()), nacimientoField.getText(),
								empleoField.getText(), telefonoField.getText(), fisicaField.getText(),
								postalField.getText(), posicionField.getText(), estadoCivilField.getText(),
								acctField.getText(), rdbtnSalarioQuincenal.isSelected(), salario, rate,
								Double.parseDouble(taxField.getText()), regBox.isSelected(), fica,
								Double.parseDouble(planMedicoField.getText()),
								Double.parseDouble(planCancerField.getText()), true,
								Double.parseDouble(totalPagadoField.getText()), Double.parseDouble(dedField.getText()),
								Double.parseDouble(credField.getText()));
						e.update(d);
						JOptionPane.showMessageDialog(null, "Empleado Creado Exitosamente!", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				} catch (NumberFormatException | HeadlessException | SQLException e) {
					e.printStackTrace();
					ErrorFrame frame = new ErrorFrame(e, "Error Creando Empleado");
					frame.setVisible(true);
				}

			}
		});
		final GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrear.gridx = 5;
		gbc_btnCrear.gridy = 11;
		panel.add(btnCrear, gbc_btnCrear);
		btnCrear.setIcon(new ImageIcon(EditarEstudiante.class.getResource("/org/jdesktop/laffy/icons/save-24.png")));

		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				dispose();
			}
		});
		final GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 11;
		panel.add(btnCancelar, gbc_btnCancelar);
		btnCancelar.setIcon(new ImageIcon(
				EditarEstudiante.class.getResource("/org/jdesktop/swingx/plaf/basic/resources/error16.png")));

		getContentPane().setLayout(groupLayout);

	}

	public boolean verify() {
		if (nombreField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			nombreField.requestFocus();
			return false;
		} else if (ssnField.getText().equals("") || !isNumeric(ssnField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			ssnField.requestFocus();
			return false;
		} else if (dependientesField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			dependientesField.requestFocus();
			return false;
		} else if (nacimientoField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			nacimientoField.requestFocus();
			return false;
		} else if (empleoField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			empleoField.requestFocus();
			return false;
		} else if (telefonoField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			telefonoField.requestFocus();
			return false;
		} else if (fisicaField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			fisicaField.requestFocus();
			return false;
		} else if (postalField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			postalField.requestFocus();
			return false;
		} else if (posicionField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			posicionField.requestFocus();
			return false;
		} else if (estadoCivilField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			estadoCivilField.requestFocus();
			return false;
		} else if (acctField.getText().equals("") || !isNumeric(acctField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			acctField.requestFocus();
			return false;
		} else if (salarioField.getText().equals("") || !isNumeric(salarioField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto", JOptionPane.WARNING_MESSAGE);
			salarioField.requestFocus();
			return false;
		} else if (taxField.getText().equals("") || !isNumeric(taxField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto o incompatible",
					JOptionPane.WARNING_MESSAGE);
			taxField.requestFocus();
			return false;
		} else if (planMedicoField.getText().equals("") || !isNumeric(planMedicoField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto o incompatible",
					JOptionPane.WARNING_MESSAGE);
			planMedicoField.requestFocus();
			return false;
		} else if (planCancerField.getText().equals("") || !isNumeric(planCancerField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto o incompatible",
					JOptionPane.WARNING_MESSAGE);
			planCancerField.requestFocus();
			return false;
		} else if (totalPagadoField.getText().equals("") || !isNumeric(totalPagadoField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto o incompatible",
					JOptionPane.WARNING_MESSAGE);
			totalPagadoField.requestFocus();
			return false;
		} else if (dedField.getText().equals("") || !isNumeric(dedField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto o incompatible",
					JOptionPane.WARNING_MESSAGE);
			dedField.requestFocus();
			return false;
		} else if (credField.getText().equals("") || !isNumeric(credField.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio", "Incompleto o incompatible",
					JOptionPane.WARNING_MESSAGE);
			credField.requestFocus();
			return false;
		}
		return true;
	}

	public static boolean isNumeric(final String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}
}
