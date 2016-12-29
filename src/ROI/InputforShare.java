package ROI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class InputforShare extends JFrame{

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	private String[] columnNames =
		{"Date", "Share", "Buy or Sell", "# of Shares", "Price per share", "Amount", "Position nr"};

	
	private Object[][] data;
	   
	    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
	    
	     
	    private JFileChooser myJFileChooser = new JFileChooser(new File("."));
	     
	    private void saveTable() {
	        if (myJFileChooser.showSaveDialog(this) ==
	                JFileChooser.APPROVE_OPTION ) {
	            saveTable(myJFileChooser.getSelectedFile());
	        }
	    }
	     
	    private void saveTable(File file) {
	        try {
	            ObjectOutputStream out = new ObjectOutputStream(
	                    new FileOutputStream(file));
	                out.writeObject(tableModel.getDataVector());
	                out.close();
	            }
	            catch (Exception ex) {
	                ex.printStackTrace();
	            }
	    }
	    private void loadTable() {
	        if (myJFileChooser.showOpenDialog(this) ==
	                JFileChooser.APPROVE_OPTION )
	            loadTable(myJFileChooser.getSelectedFile());
	    }
	     
	    private void loadTable(File file) {
	        try {
	            ObjectInputStream in = new ObjectInputStream(
	            new FileInputStream(file));
	            Vector rowData = (Vector)in.readObject();
	            Iterator itr = rowData.iterator();
	            while(itr.hasNext()) {
	                tableModel.addRow((Vector) itr.next());
	                
	            }
	            in.close();
	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	
	
	
	
	
	public static void NewScreen(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputforShare window = new InputforShare();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InputforShare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 682, 238);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(133, 68, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 40, 594, 43);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Date", "Share Name", "Buy or Sell", "# of shares", "Price per Share", "Amount", "Position Num"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			saveTable();
			}
		});
		
		
		
		
		btnNewButton.setBounds(451, 93, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Entry");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InputforShare Shares = new InputforShare();
				Shares.NewScreen();
				
			}
		});
		btnNewButton_1.setBounds(451, 121, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Continue");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SearchWindow Shares = new SearchWindow();
				Shares.NewScreen();
				
				
			}
		});
		btnNewButton_2.setBounds(451, 151, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
	}
