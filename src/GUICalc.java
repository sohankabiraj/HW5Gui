/**
 * Sohan Kabiraj (sk5gb) 
 * Sources: https://kodejava.org/how-do-i-move-focus-from-jtextarea-using-tab-key/, https://www.youtube.com/watch?v=22MBsRYuM4Q
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GUICalc extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private float average; 

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
	 * Create the frame. This also created all the buttons and such that I need. I made separate buttons for each function. 
	 * I assumed that everything will have its own buttons so if the user wants to calculate something then the user can press the specified button
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
		
		JButton btnAddCredits = new JButton("Add 15 Credits");
		
		JButton btnRemoveSelected = new JButton("Remove Selected");
		
		JButton btnRemoveAll = new JButton("Remove All ");
		
		JLabel lblNewLabel = new JLabel("Current G.P.A.:");
		
		JLabel lblRequiredGpa = new JLabel("Required G.P.A.:");
		
		JTextArea textCreditHours = new JTextArea();
		
		JTextArea textGPA = new JTextArea();
		
		JTextArea textCourseName = new JTextArea();
		
		JTextArea textTargetGPA = new JTextArea();
		
		JLabel lblGrade = new JLabel("Grade Letter: ");
		
		JTextArea textGrade = new JTextArea();
		
		JButton btnCalculate = new JButton("Calculate Current G.P.A. ");
		
		JLabel lblCurrentGPA = new JLabel("");
		
		JButton btnCalculateRequiredGpa = new JButton("Calculate Required G.P.A. ");
		
		JLabel lblRequiredGPA = new JLabel("");
		
/**
 * This is self made code from Eclipse that groups everything onto the pane. 
 */
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
																.addComponent(lblCreditHours)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addComponent(textCreditHours, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
															.addComponent(textTargetGPA, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
															.addComponent(textCourseName, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnAddButton)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(btnAddCredits, GroupLayout.PREFERRED_SIZE, 123, Short.MAX_VALUE)))
												.addPreferredGap(ComponentPlacement.RELATED, 16, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblTargetGpa, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblGpa_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textGPA, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblCourseName, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblGrade, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textGrade, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
											.addGap(25)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnRemoveSelected, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRemoveAll, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnCalculate)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCalculateRequiredGpa, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(lblCurrentGPA))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRequiredGpa)
							.addGap(18)
							.addComponent(lblRequiredGPA)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblGpa)
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCreditHours)
								.addComponent(textCreditHours, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGrade)
								.addComponent(textGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textGPA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGpa_1))
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
								.addComponent(btnAddCredits))
							.addGap(7)
							.addComponent(btnRemoveSelected)
							.addGap(3)
							.addComponent(btnRemoveAll)
							.addGap(5)
							.addComponent(btnCalculate)
							.addGap(7)
							.addComponent(btnCalculateRequiredGpa)
							.addGap(6)))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblCurrentGPA))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRequiredGpa)
						.addComponent(lblRequiredGPA))
					.addGap(14))
		);
		/**
		 * I decided to use a JTable because it is aesthetically pleasing and more user friendly. 
		 */
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		table.setBackground(Color.yellow);
		
		/**
		 * This creates the data model for the JTable so it separates everything by column. 
		 */
		Object[] columns = {"Credit Hours", "G.P.A", "Grade", "Course Name"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		/**
		 * This creates the rows and all the arraylists needed in order to do the calculations 
		 */
		Object[] row = new Object[4];
		ArrayList<Float> creditHours = new ArrayList<Float>();
		ArrayList<Float> gpas = new ArrayList<Float>(); 		
		ArrayList<Float> totalBlank = new ArrayList<Float>(); 
		ArrayList<Float> totalTaken = new ArrayList<Float>();
		/**
		 * This button is for when the Add button is pressed. If a letter grade is entered, then it sets the GPA to the corresponding 
		 * GPA. It tests for if the gpa entered is empty and makes it null so that we can skip the calculation at a later time. 
		 * Parsing all of the textaarea inputs and adding them to arraylists. 
		 */
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

				if (textCreditHours.getText().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane, "You must have credit hours entered.");
				}
				else {
					row[0] = textCreditHours.getText();
					row[1] = textGPA.getText();
					row[2] = textGrade.getText();
					row[3] = textCourseName.getText();
					
					model.addRow(row);
				}
				
				
				if(textGPA.getText().isEmpty()) {
					float getBlankCredits = Float.parseFloat(textCreditHours.getText());
					totalBlank.add(getBlankCredits);
					gpas.add(null);
				}
				else {
					float getTaken = Float.parseFloat(textCreditHours.getText());
					totalTaken.add(getTaken); 
				}
				
				
				float getCredit = Float.parseFloat(textCreditHours.getText());
				creditHours.add(getCredit);
				if(textGPA.getText().isEmpty()) {
					
				}
				else {
					float getGPA = Float.parseFloat(textGPA.getText());
					gpas.add(getGPA);
				}
				
				
				textCourseName.setText("");
				textCreditHours.setText("");
				textGPA.setText("");
				textGrade.setText("");
			}
		});
		/**
		 * Allows you to select a row in the actual JTable and then press Remove Selected to delete that specific element. 
		 */
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
		/**
		 * Removes everything from the JTable and from all the arraylists 
		 */
		btnRemoveAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int thecount = model.getRowCount(); 
				for(int i = 0; i < thecount; i++) {
					model.removeRow(0);
					creditHours.remove(0);
					gpas.remove(0);
				}
			}
		});
		/**
		 * This is the mouse listener to allow the user to select the row in order to remove it 
		 */
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				

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
		
		/**
		 * When the Calculate button is pressed, it calculates the current GPA. I separated current GPA and required GPA. 
		 * This skips empty gpa indexes. Sets the text label to the GPA value 
		 */
		btnCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float totalSum = 0;
				float finalSum = 0; 
				for (int i = 0; i < creditHours.size(); i++) {
					if(gpas.get(i) == null) {
	
					}
					else {
						totalSum += creditHours.get(i) * gpas.get(i);
						finalSum += creditHours.get(i);	
					}
					
				}
				average = (totalSum / finalSum); 
				lblCurrentGPA.setText(String.valueOf(average));
			}
		});
		/**
		 * All of these key listeners add the functionality to use the tab key to go to the next textarea. 
		 * I mainly made this because each time you press tab it inserts a tab in the given textarea which throws an error when you want to calculate 
		 */
		textCreditHours.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                        textCreditHours.transferFocusBackward();

                    } else {
                        textCreditHours.transferFocus();
                    }
                    e.consume();
                }
            }
        });
		
		textGPA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    		textGPA.transferFocusBackward();

                    } else {
                    		textGPA.transferFocus();
                    }
                    e.consume();
                }
            }
        });
		
		textCourseName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    		textCourseName.transferFocusBackward();

                    } else {
                    		textCourseName.transferFocus();
                    }
                    e.consume();
                }
            }
        });
		
		textGrade.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    		textGrade.transferFocusBackward();

                    } else {
                    		textGrade.transferFocus();
                    }
                    e.consume();
                }
            }
        });
		
		textTargetGPA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    		textTargetGPA.transferFocusBackward();

                    } else {
                    		textTargetGPA.transferFocus();
                    }
                    e.consume();
                }
            }
        });
		/**
		 * This calculates the required GPA when a blank row is added. Messages boxes are shown for over 4.0 gpa which isnt possible 
		 * and under 2.0 which means the student can take it easy 
		 */
		btnCalculateRequiredGpa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				float creditSum = 0; 
				float blankSum = 0; 
				float takenSum = 0; 
				float targetInput = Float.parseFloat(textTargetGPA.getText());
				for (float item : creditHours) {
					creditSum += item;
				}
				for (float items : totalBlank) {
					blankSum += items;
				}
				for (float i : totalTaken) {
					takenSum += i; 
				}
				float theTarget = (float) (targetInput * (takenSum + blankSum) - average*takenSum) / blankSum;
				lblRequiredGPA.setText(String.valueOf(theTarget));
				
				if (theTarget > 4.0) {
					JOptionPane.showMessageDialog(contentPane, "This isn't possible! Try adding more credits.");
				}
				if (theTarget < 2.0) {
					JOptionPane.showMessageDialog(contentPane, "You should take fewer credits if you wish.");
				}
			}
		});
		/**
		 * This adds 15 blank credits. I assumed that the instructions didn't mean 15 single blocks with 1 credits so I made it 
		 * more practical and added 5 blocks that are each 3 credit courses. 
		 */
		
		btnAddCredits.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 5; i++) {
					row[0] = 3;
					row[1] = ""; 
					row[2] = ""; 
					model.addRow(row);
					creditHours.add((float) 3);
					gpas.add(null);
					totalBlank.add((float)3);
				}
			}
		});
	}
}
