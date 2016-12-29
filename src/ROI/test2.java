package ROI;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class test2{
	JTable table;
	public static void main(String[] args) {
		new test2();
	}

	public test2(){
		JFrame frame = new JFrame("Getting Cell Values in JTable");
		JPanel panel = new JPanel();
		String data[][] = {{"1","2","3"}};
		String col[] = {"Name","Course","Subject"};		
		DefaultTableModel model = new DefaultTableModel(data, col);
		table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.yellow);
		JScrollPane pane = new JScrollPane(table);
		Object obj1 = GetData(table, 2, 2);
		System.out.println("Cell value of 3 column and 3 row :" + obj1);
		Object obj2 = GetData(table, 2, 1);
		System.out.println("Cell value of 2 column and 3 row :" + obj2);
		panel.add(pane);
		frame.add(panel);
		frame.setSize(500,150);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Object GetData(JTable table, int row_index, int col_index){
		return table.getModel().getValueAt(row_index, col_index);
	}	
}