package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import data.Planet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Planeta extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldMaxY;
	private JTextField txtFieldMaxX;
	private JTextField txtFieldNome;


	public Planeta(ArrayList<Planet> planetas) {
		setResizable(false);
		setTitle("Definir Planeta");
		setBounds(100, 100, 153, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAddPlaneta = new JButton("Definir");
		btnAddPlaneta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					int x = Integer.parseInt(txtFieldMaxX.getText());
					int y = Integer.parseInt(txtFieldMaxY.getText());

					planetas.add(new Planet(x, y, txtFieldNome.getText()));
					txtFieldMaxX.setText("");
					txtFieldMaxY.setText("");
					txtFieldNome.setText("");
					JOptionPane.showMessageDialog(null, "Planeta cadastrado!");
					
				}catch(Exception e){					
					txtFieldMaxX.setText("");
					txtFieldMaxY.setText("");
					txtFieldNome.setText("");
					JOptionPane.showMessageDialog(null, "Verifique os dados informados");			

				}
			}
		});

		txtFieldMaxY = new JTextField();
		txtFieldMaxY.setToolTipText("Y maximo");
		txtFieldMaxY.setColumns(10);

		JLabel lblMaxy = new JLabel("MaxY:");

		txtFieldMaxX = new JTextField();
		txtFieldMaxX.setToolTipText("X maximo");
		txtFieldMaxX.setColumns(10);

		JLabel lblMax = new JLabel("MaxX:");

		txtFieldNome = new JTextField();
		txtFieldNome.setToolTipText("Nome do Planeta");
		txtFieldNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(35)
						.addComponent(btnAddPlaneta)
						.addContainerGap(39, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(48, Short.MAX_VALUE)
						.addComponent(txtFieldMaxY, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addGap(51))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(52, Short.MAX_VALUE)
						.addComponent(lblMaxy)
						.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(49)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFieldMaxX, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(5)
										.addComponent(lblMax, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 1, Short.MAX_VALUE)))
						.addGap(52))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(txtFieldNome, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(53)
						.addComponent(lblNome)
						.addContainerGap(53, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(20, Short.MAX_VALUE)
						.addComponent(lblNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblMax)
						.addGap(4)
						.addComponent(txtFieldMaxX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblMaxy)
						.addGap(2)
						.addComponent(txtFieldMaxY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(16)
						.addComponent(btnAddPlaneta)
						.addGap(24))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
