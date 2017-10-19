/**
 * Sohan Kabiraj (sk5gb) 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.RowFilter;

public class GUICalc extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICalc frame = new GUICalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUICalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblGpa = new JLabel("G.P.A.");
		
		JLabel lblCreditHours = new JLabel("Credit Hours*:");
		
		JLabel lblGpa_1 = new JLabel("G.P.A.*: ");
		
		JLabel lblCourseName = new JLabel("Course Name: ");
		
		JLabel lblTargetGpa = new JLabel("Target G.P.A.:");
		
		JButton btnAddButton = new JButton("Add");
		
		JButton btnAddBlank = new JButton("Add 15 Blank");
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		
		JButton btnRemoveAll = new JButton("Remove All ");
		
		JLabel lblNewLabel = new JLabel("Current G.P.A.:");
		
		JLabel lblRequiredGpa = new JLabel("Required G.P.A.:");
		
		JTextArea textCreditHours = new JTextArea();
		
		JTextArea textGPA = new JTextArea();
		
		JTextArea textCourseName = new JTextArea();
		
		JTextArea textTargetGPA = new JTextArea();
		
		JTextArea textCurrentGPA = new JTextArea();
		
		JTextArea textRequiredGPA = new JTextArea();
		
		JLabel lblGrade = new JLabel("Grade Letter: ");
		
		JTextArea textGrade = new JTextArea();
		
		JButton btnCalculate = new JButton("Calculate");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(56)
												.addComponent(lblGpa))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblCreditHours))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblGpa_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textCreditHours, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
											.addComponent(textGPA, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
											.addComponent(textTargetGPA, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
											.addComponent(textCourseName, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnAddButton)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnAddBlank, GroupLayout.PREFERRED_SIZE, 122, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED, 17, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblTargetGpa, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblGrade, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textGrade, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblCourseName, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnRemoveSelected, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnCalculate)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRemoveAll, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textCurrentGPA, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRequiredGpa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textRequiredGPA, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblGpa)
									.addGap(31)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCreditHours)
										.addComponent(textCreditHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(13)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblGpa_1)
										.addComponent(textGPA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblGrade)
										.addComponent(textGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCourseName)
										.addComponent(textCourseName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTargetGpa)
										.addComponent(textTargetGPA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAddButton)
										.addComponent(btnAddBlank))
									.addGap(20)
									.addComponent(btnRemoveSelected)
									.addGap(15)
									.addComponent(btnRemoveAll)
									.addGap(51)))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textCurrentGPA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textRequiredGPA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRequiredGpa))
							.addGap(108))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCalculate)
							.addGap(183))))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
		Object[] columns = {"Credit Hours", "G.P.A", "Grade", "Course Name"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		Object[] row = new Object[4];
		ArrayList<Integer> creditHours = new ArrayList<Integer>();
		ArrayList<Float> gpas = new ArrayList<Float>(); 		
		btnAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				if (textGrade.getText().equals("A+")) {
					textGPA.setText(String.valueOf(4.000));
				}
				if (textGrade.getText().equals("A")) {
					textGPA.setText(String.valueOf(4.000));
				}
				if (textGrade.getText().equals("A-")) {
					textGPA.setText(String.valueOf(3.700));
				}
				if (textGrade.getText().equals("B+")) {
					textGPA.setText(String.valueOf(3.300));
				}
				if (textGrade.getText().equals("B")) {
					textGPA.setText(String.valueOf(3.000));
				}
				if (textGrade.getText().equals("B-")) {
					textGPA.setText(String.valueOf(2.700));
				}
				if (textGrade.getText().equals("C+")) {
					textGPA.setText(String.valueOf(2.300));
				}
				if (textGrade.getText().equals("C")) {
					textGPA.setText(String.valueOf(2.000));
				}
				if (textGrade.getText().equals("C-")) {
					textGPA.setText(String.valueOf(1.700));
				}
				if (textGrade.getText().equals("D+")) {
					textGPA.setText(String.valueOf(1.300));
				}
				if (textGrade.getText().equals("D")) {
					textGPA.setText(String.valueOf(1.000));
				}
				if (textGrade.getText().equals("D-")) {
					textGPA.setText(String.valueOf(0.700));
				}
				if (textGrade.getText().equals("F")) {
					textGPA.setText(String.valueOf(0.000));
				}
				

				row[0] = textCreditHours.getText();
				row[1] = textGPA.getText();
				row[2] = textGrade.getText();
				row[3] = textCourseName.getText();
				
				model.addRow(row);
				
				int getCredit = Integer.parseInt(textCreditHours.getText());
				creditHours.add(getCredit);
				float getGPA = Float.parseFloat(textGPA.getText());
				gpas.add(getGPA);
				
				System.out.print(Arrays.toString(creditHours.toArray()));
				System.out.println(Arrays.toString(gpas.toArray()));
			}
		});
		
		btnRemoveSelected.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
					creditHours.remove(i);
					gpas.remove(i);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Nothing selected to remove!");
				}
			}
		});
		
		btnRemoveAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
					creditHours.remove(i);
					gpas.remove(i);
				}
			}
		});
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				textCreditHours.setText(model.getValueAt(i, 0).toString());
				textGPA.setText(model.getValueAt(i, 1).toString());
				textGrade.setText(model.getValueAt(i, 2).toString());
				textCourseName.setText(model.getValueAt(i, 3).toString());

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCalculate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	public static void getData() {
		
	}
}
