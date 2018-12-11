package iconix.appkademyj.estudiante;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import iconix.appkademyj.util.ErrorFrame;
import iconix.database.DatabaseConnect;

public class CrearEstudiante extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -154910934954824639L;
	private final JTextField ano;
	private final JTextField num;
	private final JTextField semestre;
	private final JTextField nombre;
	private final JTextField ssn;
	private final JTextField saludo;
	private final JTextField edad;
	private final JTextField fecha_nacimiento;
	private final JTextField desc_matricula;
	private final JTextField fecha;
	private final JTextField procede;
	private final String fechaDeHoy;
	private final JTextField grado2;

	public CrearEstudiante(final DatabaseConnect d) {
		try {
			setSelected(true);
		} catch (final PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setClosable(true);
		setTitle("Crear Estudiante");
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 22));
		setBounds(100, 100, 896, 490);

		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		final Date date = new Date();
		fechaDeHoy = dateFormat.format(date);

		final JPanel panel = new JPanel();
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 854, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(104, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout
						.createSequentialGroup().addGap(17).addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(27, Short.MAX_VALUE)));
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JLabel lblAoEstudiante = new JLabel("A\u00F1o Estudiante");
		final GridBagConstraints gbc_lblAoEstudiante = new GridBagConstraints();
		gbc_lblAoEstudiante.anchor = GridBagConstraints.WEST;
		gbc_lblAoEstudiante.insets = new Insets(0, 0, 5, 5);
		gbc_lblAoEstudiante.gridx = 0;
		gbc_lblAoEstudiante.gridy = 0;
		panel.add(lblAoEstudiante, gbc_lblAoEstudiante);
		lblAoEstudiante.setFont(new Font("Dialog", Font.PLAIN, 22));

		ano = new JTextField();
		ano.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_ano = new GridBagConstraints();
		gbc_ano.insets = new Insets(0, 0, 5, 5);
		gbc_ano.fill = GridBagConstraints.HORIZONTAL;
		gbc_ano.gridx = 2;
		gbc_ano.gridy = 0;
		panel.add(ano, gbc_ano);
		ano.setColumns(10);

		final JLabel lblDescuentoMatricula = new JLabel("Descuento Matricula");
		final GridBagConstraints gbc_lblDescuentoMatricula = new GridBagConstraints();
		gbc_lblDescuentoMatricula.anchor = GridBagConstraints.WEST;
		gbc_lblDescuentoMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuentoMatricula.gridx = 6;
		gbc_lblDescuentoMatricula.gridy = 0;
		panel.add(lblDescuentoMatricula, gbc_lblDescuentoMatricula);
		lblDescuentoMatricula.setFont(new Font("Dialog", Font.PLAIN, 22));

		desc_matricula = new JTextField();
		desc_matricula.setText("0");
		desc_matricula.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_desc_matricula = new GridBagConstraints();
		gbc_desc_matricula.insets = new Insets(0, 0, 5, 0);
		gbc_desc_matricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_desc_matricula.gridx = 7;
		gbc_desc_matricula.gridy = 0;
		panel.add(desc_matricula, gbc_desc_matricula);
		desc_matricula.setColumns(10);

		final JLabel lblEstudiante = new JLabel("# Estudiante");
		final GridBagConstraints gbc_lblEstudiante = new GridBagConstraints();
		gbc_lblEstudiante.anchor = GridBagConstraints.WEST;
		gbc_lblEstudiante.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstudiante.gridx = 0;
		gbc_lblEstudiante.gridy = 1;
		panel.add(lblEstudiante, gbc_lblEstudiante);
		lblEstudiante.setFont(new Font("Dialog", Font.PLAIN, 22));

		num = new JTextField();
		num.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_num = new GridBagConstraints();
		gbc_num.insets = new Insets(0, 0, 5, 5);
		gbc_num.fill = GridBagConstraints.HORIZONTAL;
		gbc_num.gridx = 2;
		gbc_num.gridy = 1;
		panel.add(num, gbc_num);
		num.setColumns(10);

		final JLabel lblProcede = new JLabel("Procede");
		final GridBagConstraints gbc_lblProcede = new GridBagConstraints();
		gbc_lblProcede.anchor = GridBagConstraints.WEST;
		gbc_lblProcede.insets = new Insets(0, 0, 5, 5);
		gbc_lblProcede.gridx = 6;
		gbc_lblProcede.gridy = 1;
		panel.add(lblProcede, gbc_lblProcede);
		lblProcede.setFont(new Font("Dialog", Font.PLAIN, 22));

		procede = new JTextField();
		procede.setText("PR");
		procede.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_procede = new GridBagConstraints();
		gbc_procede.insets = new Insets(0, 0, 5, 0);
		gbc_procede.fill = GridBagConstraints.HORIZONTAL;
		gbc_procede.gridx = 7;
		gbc_procede.gridy = 1;
		panel.add(procede, gbc_procede);
		procede.setColumns(10);

		final JLabel lblGrado = new JLabel("Grado");
		final GridBagConstraints gbc_lblGrado = new GridBagConstraints();
		gbc_lblGrado.anchor = GridBagConstraints.WEST;
		gbc_lblGrado.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrado.gridx = 0;
		gbc_lblGrado.gridy = 2;
		panel.add(lblGrado, gbc_lblGrado);
		lblGrado.setFont(new Font("Dialog", Font.PLAIN, 22));

		final JComboBox<String> grado = new JComboBox<String>();
		grado.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_grado = new GridBagConstraints();
		gbc_grado.anchor = GridBagConstraints.WEST;
		gbc_grado.insets = new Insets(0, 0, 5, 5);
		gbc_grado.gridx = 2;
		gbc_grado.gridy = 2;
		panel.add(grado, gbc_grado);
		grado.setModel(new DefaultComboBoxModel<String>(
				new String[] { "PK", "K", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

		grado2 = new JTextField();
		grado2.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_grado2 = new GridBagConstraints();
		gbc_grado2.gridwidth = 2;
		gbc_grado2.insets = new Insets(0, 0, 5, 5);
		gbc_grado2.fill = GridBagConstraints.HORIZONTAL;
		gbc_grado2.gridx = 3;
		gbc_grado2.gridy = 2;
		panel.add(grado2, gbc_grado2);
		grado2.setColumns(10);

		final JLabel lblBeca = new JLabel("Beca");
		final GridBagConstraints gbc_lblBeca = new GridBagConstraints();
		gbc_lblBeca.anchor = GridBagConstraints.WEST;
		gbc_lblBeca.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeca.gridx = 6;
		gbc_lblBeca.gridy = 2;
		panel.add(lblBeca, gbc_lblBeca);
		lblBeca.setFont(new Font("Dialog", Font.PLAIN, 22));

		final JCheckBox beca = new JCheckBox("");
		beca.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_beca = new GridBagConstraints();
		gbc_beca.insets = new Insets(0, 0, 5, 0);
		gbc_beca.anchor = GridBagConstraints.WEST;
		gbc_beca.gridx = 7;
		gbc_beca.gridy = 2;
		panel.add(beca, gbc_beca);

		final JLabel lblSemestre = new JLabel("Semestre(2016 - 2017)");
		final GridBagConstraints gbc_lblSemestre = new GridBagConstraints();
		gbc_lblSemestre.anchor = GridBagConstraints.WEST;
		gbc_lblSemestre.insets = new Insets(0, 0, 5, 5);
		gbc_lblSemestre.gridx = 0;
		gbc_lblSemestre.gridy = 3;
		panel.add(lblSemestre, gbc_lblSemestre);
		lblSemestre.setFont(new Font("Dialog", Font.PLAIN, 22));

		semestre = new JTextField();
		semestre.setText("2016 - 2017");
		semestre.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_semestre = new GridBagConstraints();
		gbc_semestre.insets = new Insets(0, 0, 5, 5);
		gbc_semestre.fill = GridBagConstraints.HORIZONTAL;
		gbc_semestre.gridx = 2;
		gbc_semestre.gridy = 3;
		panel.add(semestre, gbc_semestre);
		semestre.setColumns(10);

		final JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		final GridBagConstraints gbc_lblFechaDeNacimiento = new GridBagConstraints();
		gbc_lblFechaDeNacimiento.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeNacimiento.gridx = 6;
		gbc_lblFechaDeNacimiento.gridy = 3;
		panel.add(lblFechaDeNacimiento, gbc_lblFechaDeNacimiento);
		lblFechaDeNacimiento.setFont(new Font("Dialog", Font.PLAIN, 22));

		fecha_nacimiento = new JTextField();
		fecha_nacimiento.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_fecha_nacimiento = new GridBagConstraints();
		gbc_fecha_nacimiento.insets = new Insets(0, 0, 5, 0);
		gbc_fecha_nacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_fecha_nacimiento.gridx = 7;
		gbc_fecha_nacimiento.gridy = 3;
		panel.add(fecha_nacimiento, gbc_fecha_nacimiento);
		fecha_nacimiento.setColumns(10);

		final JLabel lblNombre = new JLabel("Nombre");
		final GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		panel.add(lblNombre, gbc_lblNombre);
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 22));

		nombre = new JTextField();
		nombre.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombre.gridx = 2;
		gbc_nombre.gridy = 4;
		panel.add(nombre, gbc_nombre);
		nombre.setColumns(10);

		final JLabel lblEdad = new JLabel("Edad");
		final GridBagConstraints gbc_lblEdad = new GridBagConstraints();
		gbc_lblEdad.anchor = GridBagConstraints.WEST;
		gbc_lblEdad.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdad.gridx = 6;
		gbc_lblEdad.gridy = 4;
		panel.add(lblEdad, gbc_lblEdad);
		lblEdad.setFont(new Font("Dialog", Font.PLAIN, 22));

		edad = new JTextField();
		edad.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_edad = new GridBagConstraints();
		gbc_edad.insets = new Insets(0, 0, 5, 0);
		gbc_edad.fill = GridBagConstraints.HORIZONTAL;
		gbc_edad.gridx = 7;
		gbc_edad.gridy = 4;
		panel.add(edad, gbc_edad);
		edad.setColumns(10);

		final JLabel lblSexo = new JLabel("Sexo");
		final GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.WEST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 5;
		panel.add(lblSexo, gbc_lblSexo);
		lblSexo.setFont(new Font("Dialog", Font.PLAIN, 22));

		final JComboBox<String> sexo = new JComboBox<String>();
		sexo.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_sexo = new GridBagConstraints();
		gbc_sexo.anchor = GridBagConstraints.WEST;
		gbc_sexo.insets = new Insets(0, 0, 5, 5);
		gbc_sexo.gridx = 2;
		gbc_sexo.gridy = 5;
		panel.add(sexo, gbc_sexo);
		sexo.setModel(new DefaultComboBoxModel<String>(new String[] { "MASCULINO", "FEMENINO" }));

		final JLabel lblSaludo = new JLabel("Saludo");
		final GridBagConstraints gbc_lblSaludo = new GridBagConstraints();
		gbc_lblSaludo.anchor = GridBagConstraints.WEST;
		gbc_lblSaludo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaludo.gridx = 6;
		gbc_lblSaludo.gridy = 5;
		panel.add(lblSaludo, gbc_lblSaludo);
		lblSaludo.setFont(new Font("Dialog", Font.PLAIN, 22));

		saludo = new JTextField();
		saludo.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_saludo = new GridBagConstraints();
		gbc_saludo.insets = new Insets(0, 0, 5, 0);
		gbc_saludo.fill = GridBagConstraints.HORIZONTAL;
		gbc_saludo.gridx = 7;
		gbc_saludo.gridy = 5;
		panel.add(saludo, gbc_saludo);
		saludo.setColumns(10);

		final JLabel lblStatus = new JLabel("Status");
		final GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.anchor = GridBagConstraints.WEST;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 0;
		gbc_lblStatus.gridy = 7;
		panel.add(lblStatus, gbc_lblStatus);
		lblStatus.setFont(new Font("Dialog", Font.PLAIN, 22));

		final JComboBox<String> status = new JComboBox<String>();
		status.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_status = new GridBagConstraints();
		gbc_status.anchor = GridBagConstraints.WEST;
		gbc_status.insets = new Insets(0, 0, 5, 5);
		gbc_status.gridx = 2;
		gbc_status.gridy = 7;
		panel.add(status, gbc_status);
		status.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Nuevo", "Rematricula", "Baja", "Transferido" }));

		final JLabel lblFecha = new JLabel("Fecha (yyyy/mm/dd)");
		final GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.WEST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 8;
		panel.add(lblFecha, gbc_lblFecha);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 22));

		fecha = new JTextField();
		fecha.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_fecha = new GridBagConstraints();
		gbc_fecha.insets = new Insets(0, 0, 5, 5);
		gbc_fecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_fecha.gridx = 2;
		gbc_fecha.gridy = 8;
		panel.add(fecha, gbc_fecha);
		fecha.setColumns(10);
		fecha.setText(fechaDeHoy);

		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				Double cuota = 0.0;
				int tempID=0;
				try {
					if (verify()) {
						System.out.println(status.getSelectedItem().toString());
						final Estudiante e = new Estudiante(null, Integer.parseInt(num.getText()),
								Integer.parseInt(ano.getText()), grado.getSelectedItem().toString() + grado2.getText(),
								semestre.getText(), nombre.getText(), sexo.getSelectedItem().toString(), ssn.getText(),
								status.getSelectedItem().toString(), fecha.getText(), null, null, null, "",
								Double.parseDouble(desc_matricula.getText()), procede.getText(),
								beca.isSelected() ? 1 : 0, 0.00, fecha_nacimiento.getText(),
								Integer.parseInt(edad.getText()), saludo.getText(), 0.00, 0.00, 0.00, "00", true);

						tempID=e.update(d);

						if (e.getGrado().contains("6") || e.getGrado().contains("9") || e.getGrado().contains("12")) {
							cuota = 100.0;
						}

						d.fillData(tempID, e.getDesc_Matricula(), e.getSemestre(),
								cuota, 0.0);
						JOptionPane.showMessageDialog(null, "Estudiante Creado Exitosamente!", "Exito",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				} catch (HeadlessException | SQLException | IllegalArgumentException | IllegalAccessException e) {
					ErrorFrame exc = new ErrorFrame(e, "Error Creando Estudiante");
					exc.setVisible(true);
					exc.toFront();
					exc.requestFocus();
					e.printStackTrace();

				}
			}
		});
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 8;
		panel.add(btnGuardar, gbc_btnGuardar);
		btnGuardar.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnGuardar.setIcon(new ImageIcon(CrearEstudiante.class.getResource("/org/jdesktop/laffy/icons/save-24.png")));

		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				dispose();
			}
		});
		final GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.anchor = GridBagConstraints.WEST;
		gbc_btnCancelar.gridx = 7;
		gbc_btnCancelar.gridy = 8;
		panel.add(btnCancelar, gbc_btnCancelar);
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 22));
		btnCancelar.setIcon(new ImageIcon(
				CrearEstudiante.class.getResource("/org/jdesktop/swingx/plaf/basic/resources/error16.png")));

		final JLabel lblSsn = new JLabel("SSN");
		final GridBagConstraints gbc_lblSsn = new GridBagConstraints();
		gbc_lblSsn.anchor = GridBagConstraints.WEST;
		gbc_lblSsn.insets = new Insets(0, 0, 5, 5);
		gbc_lblSsn.gridx = 0;
		gbc_lblSsn.gridy = 6;
		panel.add(lblSsn, gbc_lblSsn);
		lblSsn.setFont(new Font("Dialog", Font.PLAIN, 22));

		ssn = new JTextField();
		ssn.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_ssn = new GridBagConstraints();
		gbc_ssn.insets = new Insets(0, 0, 5, 5);
		gbc_ssn.fill = GridBagConstraints.HORIZONTAL;
		gbc_ssn.gridx = 2;
		gbc_ssn.gridy = 6;
		panel.add(ssn, gbc_ssn);
		ssn.setColumns(10);
		getContentPane().setLayout(groupLayout);

	}

	public boolean verify() {
		if (ano.getText().equals("") || !isNumeric(ano.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			ano.requestFocus();
			return false;
		} else if (num.getText().equals("") || !isNumeric(num.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			num.requestFocus();
			return false;
		} else if (semestre.getText().equals("") || semestre.getText().length() != 11) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			semestre.requestFocus();
			return false;
		} else if (nombre.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			nombre.requestFocus();
			return false;
		} else if (ssn.getText().equals("") || !isNumeric(ssn.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			ssn.requestFocus();
			return false;
			// }else if(fecha.getText().equals("") || fecha.getText().length()!=10 ||
			// (fecha.getText().charAt(4)!='-') || (fecha.getText().charAt(4)!='-')) {
		} else if (fecha.getText().equals("") || fecha.getText().length() != 10) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			fecha.requestFocus();
			return false;
		} else if (desc_matricula.getText().equals("") || !isNumeric((desc_matricula.getText()))) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			desc_matricula.requestFocus();
			return false;
		} else if (procede.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			procede.requestFocus();
			return false;
		} else if (fecha_nacimiento.getText().equals("") || fecha_nacimiento.getText().length() != 10) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			fecha_nacimiento.requestFocus();
			return false;
		} else if (edad.getText().equals("") || !isNumeric(edad.getText())) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			edad.requestFocus();
			return false;
		} else if (saludo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Vacio o incompatible", "Incompleto",
					JOptionPane.WARNING_MESSAGE);
			saludo.requestFocus();
			return false;
		}
		return true;
	}

	public static boolean isNumeric(final String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

}
