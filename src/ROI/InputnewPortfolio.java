package ROI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
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


public class InputnewPortfolio extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	
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

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputnewPortfolio window = new InputnewPortfolio();
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
	public InputnewPortfolio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 369, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Portfolio Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(48, 25, 111, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Owner");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(48, 77, 111, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(189, 32, 124, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 84, 124, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveTable();
				frame.dispose();
				InputforShare Shares = new InputforShare();
				Shares.NewScreen();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(224, 133, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
