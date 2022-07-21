import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class Quiz implements ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1,t2;
JButton b1,b2,b3,b4;
Quiz()
{
f=new JFrame("ONLINE QUIZ");
f.getContentPane().setBackground(Color.white);
f.setVisible(true);
f.setSize(1500,1500);
//f.setBackground(Color.blue);
f.setLayout(new FlowLayout(FlowLayout.CENTER,2000,5));
JLabel ll=new JLabel(new ImageIcon("mits1.JPEG"));
l1=new JLabel("Graphic era deemed to be university");
b1=new JButton("java quiz");
b2=new JButton("Instructions");
l2=new JLabel("NAME");
t1=new JTextField(10);
l3=new JLabel("ROLL NUM");
t2=new JTextField(10);
b3=new JButton("start");
b4=new JButton("cancel");
l4=new JLabel("1.Each question carry 1 marks.");
l5=new JLabel("3.No negative marks.");
l6=new JLabel("2.You can select only one option from A to D.");
//b1.setForeground(Color.[255,20,147]);
b1.setBackground(Color.yellow);
b3.setBackground(Color.cyan);
b4.setBackground(Color.gray);
l1.setFont(new Font("cooper",Font.BOLD,40));
b1.setFont(new Font("casteller",Font.BOLD,30));
b2.setFont(new Font("cooper",Font.BOLD,25));
b3.setFont(new Font("cooper",Font.BOLD,25));
b4.setFont(new Font("cooper",Font.BOLD,25));
l4.setFont(new Font("casteller",Font.BOLD,30));
l5.setFont(new Font("casteller",Font.BOLD,30));
l6.setFont(new Font("casteller",Font.BOLD,30));
l2.setFont(new Font("casteller",Font.BOLD,30));
l3.setFont(new Font("casteller",Font.BOLD,30));
f.add(ll);
f.add(l1);
f.add(b1);
f.add(b2);
f.add(l4);
//f.add(l5);
f.add(l6);
f.add(l2);
f.add(t1);
f.add(l3);
f.add(t2);
f.add(b3);
f.add(b4);
b3.addActionListener(this);
b4.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource().equals(b3))
{
try
{String s1=t1.getText();
String s2=t2.getText();
if(t1.getText().equals(""))
{JOptionPane.showMessageDialog(null,"Enter candidate name");}
else if(t2.getText().equals(""))
{JOptionPane.showMessageDialog(null,"Enter Roll num");}
else
{f.setVisible(false);
 //new Page1(f,s1,s2);
}
}
finally
{}
}
else
{
f.setVisible(false);
}
}
// public static void main(String...aaa)
// {
// new Quiz();
// }
// }
}


class OnlineTest extends JFrame implements ActionListener
{



	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		//f.setSize(1500,1500);
		l.setBounds(300,400,450,200);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
         if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}

		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;

			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Number of primitive data types in java are?");
			jb[0].setText("6");jb[1].setText("7");jb[2].setText("8");jb[3].setText("9");
		}
		if(current==1)
		{
			l.setText("Que2: What is the size of float and double in java?");
			jb[0].setText("32 and 64");jb[1].setText("32 and 32");jb[2].setText("64 and 64");jb[3].setText("64 and 32");
		}
		if(current==2)
		{
			l.setText("Que3: Automatic type conversion is possible in which of possible cases");
			jb[0].setText("Byte to int");jb[1].setText("int to long");jb[2].setText("Long to int");jb[3].setText("Short to int");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Que5: Array in java are");
			jb[0].setText("object references");jb[1].setText("objects");jb[2].setText("Primitive data type");jb[3].setText("None");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Que8:To which of the following does the class string belong to:");
			jb[0].setText("java.lang");jb[1].setText("java.awt");jb[2].setText("java.applet");jb[3].setText("java.string");
		}
		if(current==8)
		{
			l.setText("Que9: output of Math.floor(3.6)");
			jb[0].setText("3");jb[1].setText("3.6");jb[2].setText("4");jb[3].setText("4.0");
		}
		if(current==9)
		{
			l.setText("Que10: Where does the System stores parameters and local variables whenever a method is invoked");
			jb[0].setText("Heap");jb[1].setText("Stack");jb[2].setText("Array");jb[3].setText("Tree");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[2].isSelected());
		if(current==1)
			return(jb[0].isSelected());
		if(current==2)
			return(jb[1].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[1].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[0].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
        new Quiz();
	}


}
