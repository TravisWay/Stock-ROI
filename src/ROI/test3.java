package ROI;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test3 {

	private JFrame frame;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnNewButton_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test3 window = new test3();
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
	
	
	
	public test3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 240);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
	               try{
	                //the file path
	               File file = new File("C:\\Text.txt");
	               //if the file not exist create one
	               if(!file.exists()){
	                   file.createNewFile();
	               }
	               
	               FileWriter fw = new FileWriter(file.getAbsoluteFile());
	               BufferedWriter bw = new BufferedWriter(fw);
	               
	               //loop for jtable rows
	               for(int i = 0; i < table.getRowCount(); i++){
	                   //loop for jtable column
	                   for(int j = 0; j < table.getColumnCount(); j++){
	                       bw.write(table.getModel().getValueAt(i, j)+" ");
	                   }
	                   //break line at the begin 
	                   //break line at the end 
	                   bw.write("\n_________\n");
	               }
	               //close BufferedWriter
	               bw.close();
	               //close FileWriter 
	               fw.close();
	               JOptionPane.showMessageDialog(null, "Data Exported");
	               
	               }catch(Exception ex){
	                   ex.printStackTrace();
	               }
	           }
	        });
		btnNewButton.setBounds(334, 262, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("load");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("C:\\Text.txt");
				String line;
				BufferedReader reader;
				    try{       
				        reader = new BufferedReader(new FileReader(file));
				        while((line = reader.readLine()) != null) 
				        {
				           model.addRow(line.split(" ")); 
				        }
				        reader.close();
				     }
				    catch(IOException e1){
				        JOptionPane.showMessageDialog(null, "Error");
				e1.printStackTrace();

				    }
			}
		});
		btnNewButton_1.setBounds(334, 296, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	
	}
	
	public Object[][] getTableData (JTable table) {
	    DefaultTableModel dtm = (DefaultTableModel) table.getModel();
	    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
	    Object[][] tableData = new Object[nRow][nCol];
	    for (int i = 0 ; i < nRow ; i++)
	        for (int j = 0 ; j < nCol ; j++)
	            tableData[i][j] = dtm.getValueAt(i,j);
	    return tableData;
	}

//	public void writeToFile()
//    {
//    try{
//    FileWriter fstream = new FileWriter("out.txt");
//    BufferedWriter out = new BufferedWriter(fstream);
//    
//	for(int i=0;i<array.length;i++){
//          out.write(array[i].getBytes());
//    }
//    out.close();
//    }catch (Exception e){
//    System.err.println("Error: " + e.getMessage());
//    }
//

   // }
	}
