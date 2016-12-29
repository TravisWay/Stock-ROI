package ROI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class PortfolioROI extends JFrame{

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	 
	private String[] columnNames =
		{"Date", "Share", "Buy or Sell", "# of Shares", "Price per share", "Amount", "Position nr"};

	
	private Object[][] data;
	   
	    private DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
	    
	     
	    private JFileChooser myJFileChooser = new JFileChooser(new File("."));
	
	    
	     
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
		                table.getModel().getValueAt(1, 1);
		    	                
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
					PortfolioROI window = new PortfolioROI();
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
	public PortfolioROI() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 11, 835, 279);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
				"Date", "Share", "Buy or Sell", "# of Shares", "Price per share", "Amount", "Position nr", "ROI in Curr", "ROI in %"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Double.class, Double.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 316, 182, 43);
		frame.getContentPane().add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Date", "Share Name"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_2);
		
		JButton btnNewButton = new JButton("New Entry");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InputforShare Shares = new InputforShare();
				Shares.NewScreen();
				
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(756, 368, 104, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(756, 402, 104, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Price");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UpdatePrice Shares = new UpdatePrice();
				Shares.NewScreen();
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(756, 436, 104, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(299, 316, 275, 43);
		frame.getContentPane().add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"# of Shares", "Recent Price", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(663, 316, 197, 43);
		frame.getContentPane().add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"ROI in Curr", "ROI in %"
			}
		) {
			Class[] columnTypes = new Class[] {
				Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_3.setViewportView(table_3);

	}
}
