package UnitGUI;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class UnitGUI implements ActionListener 
{

	JFrame f;

	JTextField t1, t2, t3, t4, t5, t6;

	JButton bcm, bin, bli, bga, bce, bfa, bkg, blb, bdel, bresult, breset;

	// result = a+b

	UnitGUI() 
	{
		f = new JFrame("Unit Converter");
		t1 = new JTextField("Welcome to unit converter");
		t1.setBounds(0, 0, 400, 50);
		t1.setEditable(false);
		t1.setFont(new Font("times new roman", Font.ITALIC, 20));
		t1.setHorizontalAlignment(SwingConstants.CENTER);

		t2 = new JTextField("Enter your vlaue");
		t2.setBounds(110, 50, 140, 50);
		t2.setEditable(false);
		t2.setHorizontalAlignment(SwingConstants.CENTER);

		t3 = new JTextField(); // input
		t3.setBounds(110, 100, 140, 50);
		t3.setHorizontalAlignment(SwingConstants.CENTER);

		t4 = new JTextField(); // result
		t4.setBounds(0, 340, 400, 50);

		t5 = new JTextField("unit");
		t5.setBounds(250, 50, 40, 50);
		t5.setEditable(false);
		t5.setHorizontalAlignment(SwingConstants.CENTER);

		t6 = new JTextField(); // unit
		t6.setBounds(250, 100, 40, 50);
		t6.setEditable(false);
		t6.setHorizontalAlignment(SwingConstants.CENTER);

		bcm = new JButton("centimeter");
		bcm.setBounds(0, 150, 100, 50);
		bcm.setToolTipText("cm to in");

		bin = new JButton("inch");
		bin.setBounds(100, 150, 100, 50);
		bin.setToolTipText("in to cm");

		bli = new JButton("liter");
		bli.setBounds(200, 150, 100, 50);
		bli.setToolTipText("งค to gal");

		bga = new JButton("gallon");
		bga.setBounds(300, 150, 100, 50);
		bga.setToolTipText("gal to งค");

		bce = new JButton("celcius");
		bce.setBounds(0, 200, 100, 50);
		bce.setToolTipText("กษ to ขต");

		bfa = new JButton("fahrenheit");
		bfa.setBounds(100, 200, 100, 50);
		bfa.setToolTipText("ขต to กษ");

		bkg = new JButton("killogram");
		bkg.setBounds(200, 200, 100, 50);
		bkg.setToolTipText("kg to lb");

		blb = new JButton("pound");
		blb.setBounds(300, 200, 100, 50);
		blb.setToolTipText("lb to kg");

		bresult = new JButton("Convert");
		bresult.setBounds(250, 280, 100, 50);
		
		breset = new JButton("reset");
		breset.setBounds(50,280,100,50);

		// add the components to the frame
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(t6);
		f.add(bcm);
		f.add(bin);
		f.add(bli);
		f.add(bga);
		f.add(bce);
		f.add(bfa);
		f.add(bkg);
		f.add(blb);
		f.add(bresult);
		f.add(breset);
		f.setLayout(null);		
		f.setVisible(true);
		f.setSize(410, 450);		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

		bcm.addActionListener(this);
		bin.addActionListener(this);
		bli.addActionListener(this);
		bga.addActionListener(this);
		bce.addActionListener(this);
		bfa.addActionListener(this);
		bkg.addActionListener(this);
		blb.addActionListener(this);
		bresult.addActionListener(this);
		breset.addActionListener(this);
	}

	// set to perform action
	// set the selection to concatenate the number for the button
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String s = e.getActionCommand();
		System.out.println(s);
		DB db = new DB(t1, t2, t3, t4, t5, t6);
		db.result(s, t3);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new UnitGUI();
	}
}