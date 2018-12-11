package broiler.abstraction;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class Estadisticas extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3936914116163526152L;
	private final JTable table;

	public Estadisticas(final DatabaseConnect d) {
		setClosable(true);
		setTitle("Estadisticas");
		setBounds(100, 100, 1064, 609);

		final JPanel panel = new JPanel();
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE).addContainerGap()));
		final GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		final JComboBox<String> semestreBox = new JComboBox<String>();
		semestreBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent e) {
				table.setModel(d.getResult("select mes,sum(Pago) as total from pago_detalles where Semestre=\""
						+ semestreBox.getSelectedItem().toString() + "\" group by mes"));

			}
		});
		semestreBox.setModel(new DefaultComboBoxModel<String>(new String[] { "2016 - 2017", "2017 - 2018",
				"2018 - 2019", "2019 - 2020", "2020 - 2021", "2021 - 2022" }));
		semestreBox.setFont(new Font("Dialog", Font.PLAIN, 20));
		final GridBagConstraints gbc_semestreBox = new GridBagConstraints();
		gbc_semestreBox.insets = new Insets(0, 0, 5, 5);
		gbc_semestreBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_semestreBox.gridx = 1;
		gbc_semestreBox.gridy = 1;
		panel.add(semestreBox, gbc_semestreBox);

		final JLabel lblPagos = new JLabel("Pagos:");
		lblPagos.setFont(new Font("Dialog", Font.PLAIN, 18));
		final GridBagConstraints gbc_lblPagos = new GridBagConstraints();
		gbc_lblPagos.anchor = GridBagConstraints.WEST;
		gbc_lblPagos.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagos.gridx = 1;
		gbc_lblPagos.gridy = 2;
		panel.add(lblPagos, gbc_lblPagos);

		getContentPane().setLayout(groupLayout);

		final JSeparator separator = new JSeparator();
		final GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 3;
		panel.add(separator, gbc_separator);

		table = new JTable();
		final GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 7;
		gbc_table.gridwidth = 6;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 4;
		panel.add(table, gbc_table);

		table.setModel(d.getResult("select mes,sum(Pago) as total from pago_detalles where Semestre=\""
				+ semestreBox.getSelectedItem().toString() + "\" group by mes"));

	}
}
