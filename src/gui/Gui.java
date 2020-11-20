package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel panelFondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//new Gui();
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(700,650);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/fondo.gif"));
	    JLabel label = new JLabel(icon);
	    panelFondo = new JPanel();
	    panelFondo.setBounds(12,12,500,600);
	    panelFondo.add(label);
	    contentPane.add(panelFondo);
		
		JPanel panel = new JPanel();
		panel.setBounds(517, 0, 171, 617);
		contentPane.add(panel);
	}
}
