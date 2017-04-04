package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import data.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RoverGUI extends JFrame {
	private Rover rover;
	private JPanel contentPane;
	private JTextField txtFieldLocalizacao;
	private JTextField txtFieldSetX;
	private JTextField txtFieldSetY;
	private JButton btnDefinirPosicao;
	private JTextField txtFieldLinhaDeComando;
	private JTextField txtFieldVirarPara;
	private JButton btnVirarPara;
	private JLabel lblViradoPara;
	private JTextField txtFieldViradoPara;

	public RoverGUI(Plateu planeta) {
		setBounds(100, 100, 501, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		JButton btnCriarRover = new JButton("Criar Rover");
		btnCriarRover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(planeta != null){
					rover = new Rover(planeta);
					JOptionPane.showMessageDialog(null, "Rover Criado");
					txtFieldLocalizacao.setText(rover.getXY());
					txtFieldViradoPara.setText(rover.getViradoPara());
				}
				else JOptionPane.showMessageDialog(null, "Crie o planeta primeiro");

			}
		});

		JLabel lblCurrentLocation = new JLabel("Localizacao Atual:");

		txtFieldLocalizacao = new JTextField();
		txtFieldLocalizacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldLocalizacao.setForeground(Color.BLACK);
		txtFieldLocalizacao.setBackground(Color.WHITE);
		txtFieldLocalizacao.setEnabled(false);
		txtFieldLocalizacao.setEditable(false);
		txtFieldLocalizacao.setColumns(10);

		txtFieldSetX = new JTextField();
		txtFieldSetX.setColumns(10);

		JLabel lblX = new JLabel("X");

		txtFieldSetY = new JTextField();
		txtFieldSetY.setColumns(10);

		JLabel lblY = new JLabel("Y");

		btnDefinirPosicao = new JButton("Definir Posicao");
		btnDefinirPosicao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int x = Integer.parseInt(txtFieldSetX.getText());
					int y = Integer.parseInt(txtFieldSetY.getText());
					if(rover.setXY(x, y)){
						txtFieldLocalizacao.setText(rover.getXY());						
						JOptionPane.showMessageDialog(null, "Posicao alterada!");	
						
					}
					else{
						JOptionPane.showMessageDialog(null, "O valor de X ou Y é invalido");	
					}
					txtFieldSetX.setText("");
					txtFieldSetY.setText("");

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Verifique os dados informados");	
				}
			}
		});

		txtFieldLinhaDeComando = new JTextField();
		txtFieldLinhaDeComando.setColumns(10);

		JButton btnMover = new JButton("Mover");
		btnMover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					if(rover.moverPorComando(txtFieldLinhaDeComando.getText())){

						JOptionPane.showMessageDialog(null, "Rover movimentado");
						txtFieldLocalizacao.setText(rover.getXY());
						txtFieldViradoPara.setText(rover.getViradoPara());
					}else{
						JOptionPane.showMessageDialog(null, "Verifique o comando informado");
					}
					txtFieldLinhaDeComando.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Verifique os dados informados");	
				}
			}
		});		

		txtFieldVirarPara = new JTextField();
		txtFieldVirarPara.setColumns(10);

		btnVirarPara = new JButton("Virar Para");
		btnVirarPara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					rover.setViradoPara(txtFieldVirarPara.getText());
					txtFieldViradoPara.setText(rover.getViradoPara());
					txtFieldVirarPara.setText("");
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Verifique os dados informados");	
				}
			}

		});

		lblViradoPara = new JLabel("Virado para:");

		txtFieldViradoPara = new JTextField();
		txtFieldViradoPara.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldViradoPara.setForeground(Color.BLACK);
		txtFieldViradoPara.setBackground(Color.WHITE);
		txtFieldViradoPara.setEnabled(false);
		txtFieldViradoPara.setEditable(false);
		txtFieldViradoPara.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(378, Short.MAX_VALUE)
						.addComponent(btnCriarRover)
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(txtFieldSetX, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(txtFieldSetY, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(10)
														.addComponent(lblX)
														.addGap(43)
														.addComponent(lblY))))
								.addComponent(btnDefinirPosicao))
						.addGap(53)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnMover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtFieldLinhaDeComando, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
						.addGap(44)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnVirarPara, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtFieldVirarPara))
						.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(90)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblViradoPara)
								.addComponent(lblCurrentLocation))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFieldLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFieldViradoPara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(179, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnCriarRover)
										.addGap(90)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblX)
												.addComponent(lblY))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtFieldSetX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtFieldSetY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblCurrentLocation)
												.addComponent(txtFieldLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblViradoPara)
												.addComponent(txtFieldViradoPara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(41)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtFieldLinhaDeComando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtFieldVirarPara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDefinirPosicao)
								.addComponent(btnMover)
								.addComponent(btnVirarPara))
						.addContainerGap(24, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
