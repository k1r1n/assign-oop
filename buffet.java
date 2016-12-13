import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
public class buffet implements ActionListener {
	private JButton btntable, btnorder, btncustomer, btnemp, btnprint, btnreport;
	private JButton beef, pork, egg, thEgg, beer, ice, soda, water;
  private JButton printBill, combine;
	private String[] tableCover = new String[10];
	public static String getTableNumber = "";
  public static String getDiscount = "";
	public static ArrayList<ArrayList<String>> orderList = new ArrayList<ArrayList<String>>();
	public static ArrayList<String> customerList = new ArrayList<String>();
	public static ArrayList<ArrayList<String>> empList = new ArrayList<ArrayList<String>>();
	public buffet() { // Constructor function

	}

	public static void main(String[] args) {
		buffet b = new buffet();
		b.gui(); // call funtion gui first
	}
	public void gui(){
		JFrame frame = new JFrame("BUFFET");
		JPanel panel = new JPanel();

		btntable = new JButton("TABLE");
		btntable.addActionListener(this);
		panel.add(btntable);

		btnorder = new JButton("ORDER");
		btnorder.addActionListener(this);
		panel.add(btnorder);

		btncustomer = new JButton("CUSTOMER");
		btncustomer.addActionListener(this);
		panel.add(btncustomer);

		btnemp = new JButton("EMPLOYEE");
		btnemp.addActionListener(this);
		panel.add(btnemp);

		btnprint = new JButton("PRINT");
		btnprint.addActionListener(this);
		panel.add(btnprint);

		btnreport = new JButton("REPORT");
		btnreport.addActionListener(this);
		panel.add(btnreport);

		panel.setLayout(new GridLayout(3, 2));

		frame.add(panel);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void customer(){

	}
	public void order(){
		JFrame orderFrame = new JFrame("ORDER ITEM");
		JPanel panel = new JPanel();


		beef = new JButton(new ImageIcon(((new ImageIcon("img/beef.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		beef.addActionListener(this);
		beef.setPreferredSize(new Dimension(250,100));

		panel.add(beef);

		pork = new JButton(new ImageIcon(((new ImageIcon("img/pork.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		pork.addActionListener(this);
		pork.setPreferredSize(new Dimension(100,100));
		panel.add(pork);

		egg = new JButton(new ImageIcon(((new ImageIcon("img/egg.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		egg.addActionListener(this);
		egg.setPreferredSize(new Dimension(100,100));
		panel.add(egg);


		thEgg = new JButton(new ImageIcon(((new ImageIcon("img/thEgg.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		thEgg.addActionListener(this);
		thEgg.setPreferredSize(new Dimension(100,100));
		panel.add(thEgg);

		beer = new JButton(new ImageIcon(((new ImageIcon("img/beer.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		beer.addActionListener(this);
		beer.setPreferredSize(new Dimension(100,100));
		panel.add(beer);


		ice = new JButton(new ImageIcon(((new ImageIcon("img/ice.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		ice.addActionListener(this);
		ice.setPreferredSize(new Dimension(100,100));
		panel.add(ice);

		soda = new JButton(new ImageIcon(((new ImageIcon("img/soda.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		soda.addActionListener(this);
		soda.setPreferredSize(new Dimension(100,100));
		panel.add(soda);


		water = new JButton(new ImageIcon(((new ImageIcon("img/water.jpg")).getImage()).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		water.addActionListener(this);
		water.setPreferredSize(new Dimension(100,100));
		panel.add(water);

		panel.setLayout(new GridLayout(2, 4));

		orderFrame.add(panel);
		orderFrame.setSize(400, 200);
		orderFrame.setLocationRelativeTo(null);
		orderFrame.dispatchEvent(new WindowEvent(orderFrame, WindowEvent.WINDOW_CLOSING));
		orderFrame.setVisible(true);

	}
  public void printIt(){
    JFrame print = new JFrame("ORDER ITEM");
    JPanel panel = new JPanel();


    printBill = new JButton("Print Bill");
    printBill.addActionListener(this);
    printBill.setPreferredSize(new Dimension(250,100));
    panel.add(printBill);

    combine = new JButton("Combine Table");
    combine.addActionListener(this);
    combine.setPreferredSize(new Dimension(250,100));
    panel.add(combine);


    panel.setLayout(new GridLayout(1, 4));

    print.add(panel);
    print.setSize(400, 200);
    print.setLocationRelativeTo(null);
    print.dispatchEvent(new WindowEvent(print, WindowEvent.WINDOW_CLOSING));
    print.setVisible(true);

  }
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btntable) {
			String tableNumber;
			do{
				tableNumber = JOptionPane.showInputDialog("Please input a table number(1-10).");
			}while(Integer.parseInt(tableNumber)>tableCover.length || Integer.parseInt(tableNumber)<=0);

			String cover = JOptionPane.showInputDialog("Please input a cover.");
			tableCover[Integer.parseInt(tableNumber)-1] = cover; // add cover in table

			for(int i=0;i<tableCover.length;i++){ // result
				System.out.println("table : " + (i+1) + " , cover : " + tableCover[i]);
			}
		}
		if (e.getSource() == btnorder) {
			do{
				getTableNumber = JOptionPane.showInputDialog("Please input a table number(1-10).");
			}while(Integer.parseInt(getTableNumber)>tableCover.length || Integer.parseInt(getTableNumber)<=0);

			buffet b = new buffet();
			b.order(); // call order
		}
		if (e.getSource() == btncustomer) {
			String input = JOptionPane.showInputDialog("Please input Name (Exit 0)");
			customerList.add(input);
			System.out.println(customerList);
		}
		if (e.getSource() == btnemp) {
			String name = JOptionPane.showInputDialog("Please input Name.");
			String salary = JOptionPane.showInputDialog("Please input salary for "+ name);
			ArrayList<String> list = new ArrayList<String>();
			list.add(name);
			list.add(salary);
			empList.add(list);
			System.out.println(empList);
		}
		if (e.getSource() == btnprint) {
      buffet b = new buffet();
			b.printIt(); // call printIt
		}
		if (e.getSource() == btnreport) {

		}

    // print
    if(e.getSource() == printBill){
			String tableNumber = JOptionPane.showInputDialog("Please input table number.");
      if (JOptionPane.showConfirmDialog(null, "Have a discount 10%?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
          getDiscount = "10";
      } else {
          getDiscount = "0";
      }

      float totalPrice = 0.0f;
      String display = "Table [" + tableNumber + "]\n";
      display += "[ Qty ] [ Order Name ] [ Price ]\n";
      for(int i=0;i<orderList.size();i++){
        String table = orderList.get(i).get(0);
        String orderName = orderList.get(i).get(1);
        String amount = orderList.get(i).get(2);
        String price = orderList.get(i).get(3);
        if(Integer.parseInt(table) == Integer.parseInt(tableNumber)){
            display += "[ " +amount+" ]\t[ "+orderName+" ]\t[ "+price+" ]\n";
            totalPrice += Integer.parseInt(price);
          }
			}
      DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
      display += "Net : "+totalPrice+" thb.\n";
      display += "Vat(7%) : "+df2.format((totalPrice*0.07))+" thb.\n";
      display += "Disount : "+df2.format( (totalPrice*Integer.parseInt(getDiscount))/100 )+" thb.\n";
      display += "Total : "+df2.format( ( totalPrice + (totalPrice*0.07) )- ( (totalPrice*Integer.parseInt(getDiscount))/100 ) )+" thb.\n";

      JOptionPane.showMessageDialog(null,new JTextArea(display));
    }
    if(e.getSource() == combine){
      String combineFrom = JOptionPane.showInputDialog("Combine Table : ");
      String combineWith = JOptionPane.showInputDialog("With : ");
      String combineTo = JOptionPane.showInputDialog("To : ");
    }
		// order
		if (e.getSource() == beef) {
			String amount;
			int price = 100;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("beef");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
		if (e.getSource() == pork) {
			String amount;
			int price = 0;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("pork");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
		if (e.getSource() == egg) {
			String amount;
			int price = 0;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("egg");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
		if (e.getSource() == thEgg) {
			String amount;
			int price = 0;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("thEgg");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
		if (e.getSource() == beer) {
			String amount;
			int price = 100;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("beer");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
		if (e.getSource() == ice) {
			String amount;
			int price = 20;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("ice");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
		if (e.getSource() == soda) {
			String amount;
			int price = 35;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("soda");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
		if (e.getSource() == water) {
			String amount;
			int price = 10;
			do{
				amount = JOptionPane.showInputDialog("Please input amount.");
			}while(Integer.parseInt(amount)<=0);

			ArrayList<String> list = new ArrayList<String>();
			list.add(getTableNumber);
			list.add("water");
			list.add(amount);
			list.add(String.valueOf(Integer.parseInt(amount)*price));
			orderList.add(list);

			System.out.println(orderList);
		}
	}

}
