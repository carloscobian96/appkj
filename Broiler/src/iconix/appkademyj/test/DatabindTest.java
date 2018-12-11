package iconix.appkademyj.test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DatabindTest extends JPanel {

	private BindingGroup m_bindingGroup;
	private iconix.appkademyj.estudiante.Estudiante estudiante = new iconix.appkademyj.estudiante.Estudiante();
	private JTextField ano_EstudianteJTextField;
	private JCheckBox becaJCheckBox;
	private JTextField edadJTextField;
	private JTextField fechaJTextField;
	private JTextField fecha_NacimientoJTextField;
	private JTextField gradoJTextField;
	private JTextField nombreJTextField;
	private JTextField numero_EstudianteJTextField;
	private JTextField procedeJTextField;
	private JTextField saludoJTextField;
	private JTextField semestreJTextField;
	private JTextField sexoJTextField;
	private JTextField ssnJTextField;

	public DatabindTest(iconix.appkademyj.estudiante.Estudiante newEstudiante) {
		this();
		setEstudiante(newEstudiante);
	}

	public DatabindTest() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0E-4 };
		setLayout(gridBagLayout);

		JLabel ano_EstudianteLabel = new JLabel("Ano_Estudiante:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(ano_EstudianteLabel, labelGbc_0);

		ano_EstudianteJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(ano_EstudianteJTextField, componentGbc_0);

		JLabel becaLabel = new JLabel("Beca:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		add(becaLabel, labelGbc_1);

		becaJCheckBox = new JCheckBox();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 5);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		add(becaJCheckBox, componentGbc_1);

		JLabel edadLabel = new JLabel("Edad:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 2;
		add(edadLabel, labelGbc_2);

		edadJTextField = new JTextField();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.insets = new Insets(5, 0, 5, 5);
		componentGbc_2.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 2;
		add(edadJTextField, componentGbc_2);

		JLabel fechaLabel = new JLabel("Fecha:");
		GridBagConstraints labelGbc_3 = new GridBagConstraints();
		labelGbc_3.insets = new Insets(5, 5, 5, 5);
		labelGbc_3.gridx = 0;
		labelGbc_3.gridy = 3;
		add(fechaLabel, labelGbc_3);

		fechaJTextField = new JTextField();
		GridBagConstraints componentGbc_3 = new GridBagConstraints();
		componentGbc_3.insets = new Insets(5, 0, 5, 5);
		componentGbc_3.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_3.gridx = 1;
		componentGbc_3.gridy = 3;
		add(fechaJTextField, componentGbc_3);

		JLabel fecha_NacimientoLabel = new JLabel("Fecha_Nacimiento:");
		GridBagConstraints labelGbc_4 = new GridBagConstraints();
		labelGbc_4.insets = new Insets(5, 5, 5, 5);
		labelGbc_4.gridx = 0;
		labelGbc_4.gridy = 4;
		add(fecha_NacimientoLabel, labelGbc_4);

		fecha_NacimientoJTextField = new JTextField();
		GridBagConstraints componentGbc_4 = new GridBagConstraints();
		componentGbc_4.insets = new Insets(5, 0, 5, 5);
		componentGbc_4.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_4.gridx = 1;
		componentGbc_4.gridy = 4;
		add(fecha_NacimientoJTextField, componentGbc_4);

		JLabel gradoLabel = new JLabel("Grado:");
		GridBagConstraints labelGbc_5 = new GridBagConstraints();
		labelGbc_5.insets = new Insets(5, 5, 5, 5);
		labelGbc_5.gridx = 0;
		labelGbc_5.gridy = 5;
		add(gradoLabel, labelGbc_5);

		gradoJTextField = new JTextField();
		GridBagConstraints componentGbc_5 = new GridBagConstraints();
		componentGbc_5.insets = new Insets(5, 0, 5, 5);
		componentGbc_5.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_5.gridx = 1;
		componentGbc_5.gridy = 5;
		add(gradoJTextField, componentGbc_5);

		JLabel nombreLabel = new JLabel("Nombre:");
		GridBagConstraints labelGbc_6 = new GridBagConstraints();
		labelGbc_6.insets = new Insets(5, 5, 5, 5);
		labelGbc_6.gridx = 0;
		labelGbc_6.gridy = 6;
		add(nombreLabel, labelGbc_6);

		nombreJTextField = new JTextField();
		GridBagConstraints componentGbc_6 = new GridBagConstraints();
		componentGbc_6.insets = new Insets(5, 0, 5, 5);
		componentGbc_6.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_6.gridx = 1;
		componentGbc_6.gridy = 6;
		add(nombreJTextField, componentGbc_6);

		JLabel numero_EstudianteLabel = new JLabel("Numero_Estudiante:");
		GridBagConstraints labelGbc_7 = new GridBagConstraints();
		labelGbc_7.insets = new Insets(5, 5, 5, 5);
		labelGbc_7.gridx = 0;
		labelGbc_7.gridy = 7;
		add(numero_EstudianteLabel, labelGbc_7);

		numero_EstudianteJTextField = new JTextField();
		GridBagConstraints componentGbc_7 = new GridBagConstraints();
		componentGbc_7.insets = new Insets(5, 0, 5, 5);
		componentGbc_7.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_7.gridx = 1;
		componentGbc_7.gridy = 7;
		add(numero_EstudianteJTextField, componentGbc_7);

		JLabel procedeLabel = new JLabel("Procede:");
		GridBagConstraints labelGbc_8 = new GridBagConstraints();
		labelGbc_8.insets = new Insets(5, 5, 5, 5);
		labelGbc_8.gridx = 0;
		labelGbc_8.gridy = 8;
		add(procedeLabel, labelGbc_8);

		procedeJTextField = new JTextField();
		GridBagConstraints componentGbc_8 = new GridBagConstraints();
		componentGbc_8.insets = new Insets(5, 0, 5, 5);
		componentGbc_8.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_8.gridx = 1;
		componentGbc_8.gridy = 8;
		add(procedeJTextField, componentGbc_8);

		JLabel saludoLabel = new JLabel("Saludo:");
		GridBagConstraints labelGbc_9 = new GridBagConstraints();
		labelGbc_9.insets = new Insets(5, 5, 5, 5);
		labelGbc_9.gridx = 0;
		labelGbc_9.gridy = 9;
		add(saludoLabel, labelGbc_9);

		saludoJTextField = new JTextField();
		GridBagConstraints componentGbc_9 = new GridBagConstraints();
		componentGbc_9.insets = new Insets(5, 0, 5, 5);
		componentGbc_9.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_9.gridx = 1;
		componentGbc_9.gridy = 9;
		add(saludoJTextField, componentGbc_9);

		JLabel semestreLabel = new JLabel("Semestre:");
		GridBagConstraints labelGbc_10 = new GridBagConstraints();
		labelGbc_10.insets = new Insets(5, 5, 5, 5);
		labelGbc_10.gridx = 0;
		labelGbc_10.gridy = 10;
		add(semestreLabel, labelGbc_10);

		semestreJTextField = new JTextField();
		GridBagConstraints componentGbc_10 = new GridBagConstraints();
		componentGbc_10.insets = new Insets(5, 0, 5, 5);
		componentGbc_10.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_10.gridx = 1;
		componentGbc_10.gridy = 10;
		add(semestreJTextField, componentGbc_10);

		JLabel sexoLabel = new JLabel("Sexo:");
		GridBagConstraints labelGbc_11 = new GridBagConstraints();
		labelGbc_11.insets = new Insets(5, 5, 5, 5);
		labelGbc_11.gridx = 0;
		labelGbc_11.gridy = 11;
		add(sexoLabel, labelGbc_11);

		sexoJTextField = new JTextField();
		GridBagConstraints componentGbc_11 = new GridBagConstraints();
		componentGbc_11.insets = new Insets(5, 0, 5, 5);
		componentGbc_11.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_11.gridx = 1;
		componentGbc_11.gridy = 11;
		add(sexoJTextField, componentGbc_11);

		JLabel ssnLabel = new JLabel("Ssn:");
		GridBagConstraints labelGbc_12 = new GridBagConstraints();
		labelGbc_12.insets = new Insets(5, 5, 5, 5);
		labelGbc_12.gridx = 0;
		labelGbc_12.gridy = 12;
		add(ssnLabel, labelGbc_12);

		ssnJTextField = new JTextField();
		GridBagConstraints componentGbc_12 = new GridBagConstraints();
		componentGbc_12.insets = new Insets(5, 0, 5, 5);
		componentGbc_12.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_12.gridx = 1;
		componentGbc_12.gridy = 12;
		add(ssnJTextField, componentGbc_12);

		if (estudiante != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer> ano_EstudianteProperty = BeanProperty
				.create("ano_Estudiante");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer, javax.swing.JTextField, java.lang.String> autoBinding = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, ano_EstudianteProperty,
						ano_EstudianteJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer> becaProperty = BeanProperty
				.create("beca");
		BeanProperty<javax.swing.JCheckBox, java.lang.Boolean> selectedProperty = BeanProperty.create("selected");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer, javax.swing.JCheckBox, java.lang.Boolean> autoBinding_1 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, becaProperty, becaJCheckBox,
						selectedProperty);
		autoBinding_1.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer> edadProperty = BeanProperty
				.create("edad");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer, javax.swing.JTextField, java.lang.String> autoBinding_2 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, edadProperty, edadJTextField,
						textProperty_1);
		autoBinding_2.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> fechaProperty = BeanProperty
				.create("fecha");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_2 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_3 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, fechaProperty, fechaJTextField,
						textProperty_2);
		autoBinding_3.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> fecha_NacimientoProperty = BeanProperty
				.create("fecha_Nacimiento");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_3 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_4 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, fecha_NacimientoProperty,
						fecha_NacimientoJTextField, textProperty_3);
		autoBinding_4.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> gradoProperty = BeanProperty
				.create("grado");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_4 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_5 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, gradoProperty, gradoJTextField,
						textProperty_4);
		autoBinding_5.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> nombreProperty = BeanProperty
				.create("nombre");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_5 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_6 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, nombreProperty, nombreJTextField,
						textProperty_5);
		autoBinding_6.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer> numero_EstudianteProperty = BeanProperty
				.create("numero_Estudiante");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_6 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.Integer, javax.swing.JTextField, java.lang.String> autoBinding_7 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, numero_EstudianteProperty,
						numero_EstudianteJTextField, textProperty_6);
		autoBinding_7.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> procedeProperty = BeanProperty
				.create("procede");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_7 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_8 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, procedeProperty,
						procedeJTextField, textProperty_7);
		autoBinding_8.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> saludoProperty = BeanProperty
				.create("saludo");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_8 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_9 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, saludoProperty, saludoJTextField,
						textProperty_8);
		autoBinding_9.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> semestreProperty = BeanProperty
				.create("semestre");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_9 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_10 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, semestreProperty,
						semestreJTextField, textProperty_9);
		autoBinding_10.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> sexoProperty = BeanProperty
				.create("sexo");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_10 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_11 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, sexoProperty, sexoJTextField,
						textProperty_10);
		autoBinding_11.bind();
		//
		BeanProperty<iconix.appkademyj.estudiante.Estudiante, java.lang.String> ssnProperty = BeanProperty
				.create("ssn");
		BeanProperty<javax.swing.JTextField, java.lang.String> textProperty_11 = BeanProperty.create("text");
		AutoBinding<iconix.appkademyj.estudiante.Estudiante, java.lang.String, javax.swing.JTextField, java.lang.String> autoBinding_12 = Bindings
				.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, estudiante, ssnProperty, ssnJTextField,
						textProperty_11);
		autoBinding_12.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		bindingGroup.addBinding(autoBinding_4);
		bindingGroup.addBinding(autoBinding_5);
		bindingGroup.addBinding(autoBinding_6);
		bindingGroup.addBinding(autoBinding_7);
		bindingGroup.addBinding(autoBinding_8);
		bindingGroup.addBinding(autoBinding_9);
		bindingGroup.addBinding(autoBinding_10);
		bindingGroup.addBinding(autoBinding_11);
		bindingGroup.addBinding(autoBinding_12);
		//
		return bindingGroup;
	}

	public iconix.appkademyj.estudiante.Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(iconix.appkademyj.estudiante.Estudiante newEstudiante) {
		setEstudiante(newEstudiante, true);
	}

	public void setEstudiante(iconix.appkademyj.estudiante.Estudiante newEstudiante, boolean update) {
		estudiante = newEstudiante;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (estudiante != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

}
