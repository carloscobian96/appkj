package broiler.abstraction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import broiler.abstraction.BuscarEmpleado2;
import broiler.database.NuevoAnoEscolar;
import broiler.util.ErrorFrame;
import broiler.util.LoginDialog;

//import iconix.appkademyj.empleados.BuscarEmpleado;
//import iconix.appkademyj.empleados.CrearEmpleado;
//import iconix.appkademyj.empleados.Nomina;
//import iconix.appkademyj.estudiante.AplicarRecargos;
//import iconix.appkademyj.estudiante.BuscarEstudiante;
//import iconix.appkademyj.estudiante.CrearEstudiante;
//import iconix.appkademyj.estudiante.ReporteDeBalanceEstudiante;
//import iconix.appkademyj.util.ErrorFrame;
//import iconix.appkademyj.util.LoginDialog;
//import iconix.database.DatabaseConnect;
//import iconix.database.Estadisticas;
//import iconix.database.NuevoAnoEscolar;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class RootFrameBroiler extends JFrame {
	private static final long serialVersionUID = -8018228221085286714L;
	private final JPanel contentPane;
	private final DatabaseConnect d = new DatabaseConnect();
	private BufferedImage wallpaper;
	static RootFrameBroiler frame=null;

	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
//					final RootFrameBroiler frame = new RootFrameBroiler();
//					frame.setVisible(true);
//					LoginDialog loginDlg = new LoginDialog(frame);
					
					
					
					
					
//					LoginDialog loginDlg = new LoginDialog(null);
//					loginDlg.setVisible(true);
//					if (loginDlg.isSucceeded()) {
						frame = new RootFrameBroiler();
						frame.setVisible(true);
//						frame.setTitle("BROILER: " + loginDlg.getUsername());
						frame.setTitle("BROILER:" );

//					} else {
////						frame.dispose();
//						System.exit(0);
//					}

				} catch (final Exception e) {
					e.printStackTrace();
					ErrorFrame frame = new ErrorFrame(e, "Error in Main");
					frame.setVisible(true);
				} finally {
//					frame.dispose();
//					System.exit(0);
				}
			}
		});
	}

	public RootFrameBroiler() {

		// LOAD DEFAULT DIMENSIONS
//		setUndecorated(true);

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(RootFrameBroiler.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setFont(new Font("Dialog", Font.PLAIN, 24));
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
		setLocationRelativeTo(null);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			wallpaper = ImageIO.read(RootFrameBroiler.class.getResourceAsStream("/broiler/img/wallpaper.png"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// CHANGE LOOK AND FEEL
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			e2.printStackTrace();
		}

		final JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		setJMenuBar(menuBar);

		final JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Dialog", Font.PLAIN, 22));
		menuBar.add(mnMenu);

		final JMenu mnCambiarBaseDe = new JMenu("Cambiar Base de Datos");
		mnCambiarBaseDe.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnMenu.add(mnCambiarBaseDe);

		final JMenuItem mntmDefault = new JMenuItem("Default");
		mntmDefault.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnCambiarBaseDe.add(mntmDefault);

		final JMenuItem mntmVariables = new JMenuItem("Variables");
		mntmVariables.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// try {
				// @SuppressWarnings("null")
				// int x = (Integer) null;
				// int y = 12;
				// System.out.println(x + y);
				// } catch (Exception ex) {
				// // TODO Auto-generated catch block
				// ex.printStackTrace();
				//
				// ErrorFrame frame = new ErrorFrame(ex, "MAMAGUEBO");
				// frame.setVisible(true);
				//
				// }
			}
		});
		mntmVariables.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnMenu.add(mntmVariables);

		final JMenuItem mntmExit = new JMenuItem("Cerrar");
		mntmExit.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnMenu.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				System.exit(0);
			}
		});

		final JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				grphcs.drawImage(wallpaper, 0, 0, null);
			}

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(wallpaper.getWidth(), wallpaper.getHeight());
			}
		};

		final JMenu mnEstudiantes = new JMenu("Estudiantes");
		mnEstudiantes.setFont(new Font("Dialog", Font.PLAIN, 22));
		menuBar.add(mnEstudiantes);

		final JMenuItem mntmEstudiante = new JMenuItem("Crear Nuevo");
		mnEstudiantes.add(mntmEstudiante);
		mntmEstudiante.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final CrearEstudiante a = new CrearEstudiante(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		mntmEstudiante.setFont(new Font("Dialog", Font.PLAIN, 22));

		final JMenuItem mntmEstudiante_1 = new JMenuItem("Buscar ");
		mnEstudiantes.add(mntmEstudiante_1);
		mntmEstudiante_1.setFont(new Font("Dialog", Font.PLAIN, 22));

		final JMenuItem mntmRegistrarRecargos = new JMenuItem("Registrar Recargos y Ahorros");
		mnEstudiantes.add(mntmRegistrarRecargos);
		mntmRegistrarRecargos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final AplicarRecargos a = new AplicarRecargos(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		mntmRegistrarRecargos.setFont(new Font("Dialog", Font.PLAIN, 22));

		final JMenuItem mntmVerReporteDe = new JMenuItem("Ver Reporte de Balances");
		mntmVerReporteDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final ReporteDeBalanceEstudiante a = new ReporteDeBalanceEstudiante(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		mntmVerReporteDe.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnEstudiantes.add(mntmVerReporteDe);

		final JMenu mnEmpleados = new JMenu("Empleados");
		mnEmpleados.setFont(new Font("Dialog", Font.PLAIN, 22));
		menuBar.add(mnEmpleados);

		final JMenuItem mntmCrearEmpleado = new JMenuItem("Crear Empleado");
		mntmCrearEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final CrearEmpleado2 a = new CrearEmpleado2(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		mntmCrearEmpleado.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnEmpleados.add(mntmCrearEmpleado);

		final JMenuItem mntmVerEmpleados = new JMenuItem("Ver Empleados");
		mntmVerEmpleados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final BuscarEmpleado2 a = new BuscarEmpleado2(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();

			}
		});
		mntmVerEmpleados.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnEmpleados.add(mntmVerEmpleados);

		final JMenuItem mntmCorrerNomina = new JMenuItem("Correr Nomina");
		mntmCorrerNomina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				final Nomina a = new Nomina(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		mntmCorrerNomina.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnEmpleados.add(mntmCorrerNomina);

		final JMenu mnAdministracion = new JMenu("Administracion");
		mnAdministracion.setFont(new Font("Dialog", Font.PLAIN, 22));
		menuBar.add(mnAdministracion);

		final JMenuItem mntmResetData = new JMenuItem("Reset Payment Data");
		mntmResetData.setEnabled(false);
		mntmResetData.setFont(new Font("Dialog", Font.PLAIN, 22));
		mntmResetData.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				try {
					d.emptyPaymentData();
					d.fillData();
					d.descuentosDeMatricula("2016 - 2017");
					JOptionPane.showMessageDialog(null, "Done!");
				} catch (HeadlessException | SQLException e) {
					e.printStackTrace();
					ErrorFrame frame = new ErrorFrame(e, "Error ");
					frame.setVisible(true);
				}

			}
		});
		mnAdministracion.add(mntmResetData);

		final JMenuItem mntmExportarEstudiantes = new JMenuItem("Exportar Estudiantes");
		mntmExportarEstudiantes.setFont(new Font("Dialog", Font.PLAIN, 22));
		mntmExportarEstudiantes.setEnabled(false);
		mnAdministracion.add(mntmExportarEstudiantes);

		final JMenuItem mntmExportarEmpleados = new JMenuItem("Exportar Empleados");
		mntmExportarEmpleados.setEnabled(false);
		mntmExportarEmpleados.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnAdministracion.add(mntmExportarEmpleados);

		final JMenuItem mntmExportarPagos = new JMenuItem("Exportar Pagos");
		mntmExportarPagos.setFont(new Font("Dialog", Font.PLAIN, 22));
		mntmExportarPagos.setEnabled(false);
		mnAdministracion.add(mntmExportarPagos);

		final JMenuItem mntmExportarHistorialDe = new JMenuItem("Exportar historial de Pagos");
		mntmExportarHistorialDe.setFont(new Font("Dialog", Font.PLAIN, 22));
		mntmExportarHistorialDe.setEnabled(false);
		mnAdministracion.add(mntmExportarHistorialDe);

		final JMenuItem mntmEstadisticas = new JMenuItem("Estadisticas");
		mntmEstadisticas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final Estadisticas a = new Estadisticas(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		mntmEstadisticas.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnAdministracion.add(mntmEstadisticas);

		final JMenuItem mntmNuevoAoEscolar = new JMenuItem("Nuevo A\u00F1o Escolar");
		mntmNuevoAoEscolar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final NuevoAnoEscolar a = new NuevoAnoEscolar(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		mntmNuevoAoEscolar.setFont(new Font("Dialog", Font.PLAIN, 22));
		mnAdministracion.add(mntmNuevoAoEscolar);

		JMenuItem mntmTestaction = new JMenuItem("TestAction");
		mntmTestaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final BuscarEmpleado2 a = new BuscarEmpleado2(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();

			}
		});
		mnAdministracion.add(mntmTestaction);

		final JMenu mnHelp = new JMenu("Ayuda");
		mnHelp.setFont(new Font("Dialog", Font.PLAIN, 22));
		menuBar.add(mnHelp);

		final JMenuItem mntmInformacion = new JMenuItem("Informacion");
		mntmInformacion.setFont(new Font("Dialog", Font.PLAIN, 22));
		mntmInformacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Creado por Carlos Jose Cobian \n Producto de Iconix Group \n Distribucion 2");
			}
		});
		mnHelp.add(mntmInformacion);
		mntmEstudiante_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final BuscarEstudiante a = new BuscarEstudiante(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		final GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1892, Short.MAX_VALUE));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_contentPane.createSequentialGroup()
								.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1084, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		desktopPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		desktopPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 38, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final BuscarEmpleado2 a = new BuscarEmpleado2(d);
				a.setVisible(true);
				desktopPane.add(a);
				a.toFront();
				a.requestFocus();
			}
		});
		button_1.setIcon(new ImageIcon(RootFrameBroiler.class.getResource("/broiler/img/2r6D.gif")));
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 0;
		panel.add(button_1, gbc_button_1);
		contentPane.setLayout(gl_contentPane);
	}

}
