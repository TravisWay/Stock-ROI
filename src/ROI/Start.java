package ROI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Vector;
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
public class Start extends JFrame{

	private JFrame frame;
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 391, 191);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create New Portfolio");
		btnNewButton.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {frame.dispose();
		    InputnewPortfolio Portfolio = new InputnewPortfolio();
		    Portfolio.NewScreen();
		      
		    }

			
			
		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 61, 162, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Open Existing Portfolio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(203, 61, 162, 42);
		frame.getContentPane().add(btnNewButton_1);
	}

		
	}

