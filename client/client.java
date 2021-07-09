import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.util.zip.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import com.sun.nio.sctp.MessageInfo;
import com.sun.nio.sctp.SctpChannel;
import com.sun.nio.sctp.*;
import com.sun.nio.sctp.SctpServerChannel;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;
import java.util.*;  
import java.io.*;
import java.lang.Object.*;
import java.lang.*;
import com.sun.nio.sctp.*;

public class client
{
JFrame f,f1,f2,f3,f4,f7,f8;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l21,l22,l23,l24,l25,l31,l32,l33,l44,l45,l46,l47,l48,l49,l50,l51,l52,l53,l54,l55,l56,l57,l58,l59,l60;
JTextField t,t1,t2,t3,t4,t5,t21,t22,t23,t24,t25,t31,t32,t33,t34,t35,t36,t37,t38;
JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32;
JPasswordField val;
JComboBox cb;  
Socket s;
String str,sk1,sk2,sk3;
String word;
String send;
String c1;
String c2;
String c3;
String c4;
int s2;
int s1;
DatagramSocket ds;
DatagramSocket ds1;
DataOutputStream dout;
DataInputStream din;
String country[]={"Australia","France","U.S.A","Japanese"}; 
    static int SERVER_PORT = 3456;
    static int US_STREAM = 0;
    static int FR_STREAM = 1;
    static int NR_STREAM = 2;
    static int JR_STREAM = 3;
    static int AR_STREAM = 4;
public void cli()
{

f7=new JFrame("TRANSPORT LAYER PROTOCOLS");
l50=new JLabel("Username:");  l50.setBounds(40,100,100,30);
l51=new JLabel("Password:");  l51.setBounds(40,140,100,30);
t34=new JTextField();   t34.setBounds(210,100,200,30);
val=new JPasswordField();   val.setBounds(210,140,200,30);
b23=new JButton("Login");  b23.setBounds(150,200,100,30);



l1=new JLabel("SCTP");  l1.setBounds(10,10,300,30);
l52=new JLabel("user");  l52.setBounds(400,10,200,30);
l2=new JLabel("Enter the Port Number");  l2.setBounds(10,40,200,30);
t=new JTextField();   t.setBounds(10,80,200,30);
b3=new JButton("Connect");  b3.setBounds(250,80,100,30);
cb=new JComboBox(country); cb.setBounds(380,80,100,30);
l3=new JLabel("TIME 1 (INDIA)");  l3.setBounds(20,120,600,30);
l7=new JLabel("TIME 2");  l7.setBounds(20,160,600,30);
l9=new JLabel("TCP");  l9.setBounds(10,200,300,30);
l8=new JLabel("Enter the Port Number");  l8.setBounds(10,240,200,30);
t1=new JTextField();   t1.setBounds(10,280,200,30);
b4=new JButton("Connect");  b4.setBounds(250,280,100,30);
b16=new JButton("Aptitude");  b16.setBounds(220,200,100,30);
b17=new JButton("Online-Test");  b17.setBounds(50,270,200,30);
l4=new JLabel("STATUS");  l4.setBounds(200,320,500,30);
l44=new JLabel("STATUS");  l44.setBounds(200,280,500,30);
t3=new JTextField();   t3.setBounds(10,320,200,30);
t37=new JTextField();   t37.setBounds(10,320,200,30);
t38=new JTextField();   t38.setBounds(10,360,200,30);
b6=new JButton("Send");  b6.setBounds(250,320,100,30);
b31=new JButton("Send");  b31.setBounds(250,320,100,30);
b10=new JButton("Exit");  b10.setBounds(400,320,100,30);

b32=new JButton("Exit");  b32.setBounds(400,320,100,30);
l10=new JLabel("UDP");  l10.setBounds(10,400,300,30);
l5=new JLabel("Enter the Port Numbers:");  l5.setBounds(10,440,200,30);
t2=new JTextField();   t2.setBounds(200,480,200,30);
t4=new JTextField();   t4.setBounds(200,520,200,30);
l12=new JLabel("Current Port:");  l12.setBounds(10,480,300,30);
l13=new JLabel("Send Port:");  l13.setBounds(10,520,300,30);
l6=new JLabel("Give Your Feedback");  l6.setBounds(200,560,500,30);
b5=new JButton("FORM");  b5.setBounds(200,600,100,30);
b24=new JButton("Logout");  b24.setBounds(400,600,100,30);
l21=new JLabel("Name");  l21.setBounds(10,10,300,30);
l22=new JLabel("Date");  l22.setBounds(10,50,300,30);
l23=new JLabel("Experience");  l23.setBounds(10,90,300,30);
l24=new JLabel("Sugestion");  l24.setBounds(10,130,300,30);
l25=new JLabel("Rating - out of 5");  l25.setBounds(10,170,300,30);
t21=new JTextField();   t21.setBounds(350,10,200,30);
t22=new JTextField();   t22.setBounds(350,50,200,30);
t23=new JTextField();   t23.setBounds(350,90,200,30);
t24=new JTextField();   t24.setBounds(350,130,200,30);
t25=new JTextField();   t25.setBounds(350,170,200,30);
b15=new JButton("Submit");  b15.setBounds(200,210,100,30);
l31=new JLabel("ques1");  l31.setBounds(150,10,300,30);
l32=new JLabel("ques2");  l32.setBounds(150,90,300,30);
l33=new JLabel("ques3");  l33.setBounds(150,170,300,30);
t31=new JTextField();   t31.setBounds(220,50,200,30);
t32=new JTextField();   t32.setBounds(220,130,200,30);
t33=new JTextField();   t33.setBounds(220,210,200,30);
b18=new JButton("Submit");  b18.setBounds(200,300,100,30);
b19=new JButton("Start Test");  b19.setBounds(170,360,200,30);
b20=new JButton("Back");  b20.setBounds(200,320,200,30);
l45=new JLabel("STATUS");  l45.setBounds(100,150,300,30);
b21=new JButton("Back");  b21.setBounds(10,20,100,30);
b22=new JButton("Connect Again");  b22.setBounds(200,250,170,30);
l46=new JLabel("WELCOME AND READY TO ATTEND THE TEST");  l46.setBounds(100,90,300,30);
l47=new JLabel("Ans: ");  l47.setBounds(150,50,50,30);
l48=new JLabel("Ans: ");  l48.setBounds(150,130,50,30);
l49=new JLabel("Ans: ");  l49.setBounds(150,210,50,30);
l53=new JLabel("Level-1: EASY");  l53.setBounds(200,30,200,30);
l54=new JLabel("Level-2: MEDIUM");  l54.setBounds(200,90,200,30);
l55=new JLabel("Level-3: HARD");  l55.setBounds(200,150,200,30);
b25=new JButton("Level-2");  b25.setBounds(250,400,100,30);
b28=new JButton("Offline-Test");  b28.setBounds(300,270,200,30);

l56=new JLabel("ques1");  l56.setBounds(180,10,300,30);
l57=new JLabel("ques2");  l57.setBounds(180,90,300,30);
l58=new JLabel("ques3");  l58.setBounds(180,170,300,30);
l59=new JLabel("STATUS");  l59.setBounds(240,220,300,30);
l60=new JLabel("FileName :");  l60.setBounds(30,270,200,30);
t36=new JTextField();   t36.setBounds(180,270,200,30);
b29=new JButton("Upload");  b29.setBounds(180,320,200,30);
b30=new JButton("Back");  b30.setBounds(180,360,200,30);

          
f=new JFrame("SAMARITAN APP");
//l52.setText(user);
b3.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{
         try{
            InetSocketAddress serverAddr = new InetSocketAddress("localhost", 
                                                             Integer.parseInt(t.getText()));
        ByteBuffer buf = ByteBuffer.allocateDirect(60);
        Charset charset = Charset.forName("ISO-8859-1");
        CharsetDecoder decoder = charset.newDecoder();

        SctpChannel sc = SctpChannel.open(serverAddr, 0, 0);

        /* handler to keep track of association setup and termination */
        AssociationHandler assocHandler = new AssociationHandler();

         /* expect two messages and two notifications */
        MessageInfo messageInfo = null;
        do {
            messageInfo = sc.receive(buf, System.out, assocHandler);
            buf.flip();

            if (buf.remaining() > 0 &&
                messageInfo.streamNumber() == US_STREAM) {

                l3.setText("(IN) " + decoder.decode(buf).toString());
            } else if (buf.remaining() > 0 && 
                       messageInfo.streamNumber() == FR_STREAM) {

                c1="(FR) " +  decoder.decode(buf).toString();
            }
               else if(buf.remaining()>0 && messageInfo.streamNumber() == NR_STREAM ){
                     c2="(USA) " +  decoder.decode(buf).toString();
             }
               else if(buf.remaining()>0 && messageInfo.streamNumber() == JR_STREAM ){
                     c3="(JP) " +  decoder.decode(buf).toString();
             }
               else if(buf.remaining()>0 && messageInfo.streamNumber() == AR_STREAM ){
                     c4="(AUS) " +  decoder.decode(buf).toString();
                     l7.setText(c4);
             }
            buf.clear();
        } while (messageInfo != null);

        sc.close();
             
             cb.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
               String str=String.valueOf(cb.getSelectedItem());
                 if(str.equals("Australia")){
                       l7.setText(c4);
}
                        if(str.equals("France")){
                        l7.setText(c1);

}
                 if(str.equals("U.S.A")){
                    l7.setText(c2);

}
                 if(str.equals("Japanese")){
                     l7.setText(c3);

}            


}});
            

         }


		catch(Exception E)
		{
			JOptionPane.showMessageDialog(f,"Not Connected Enter Port Properly");
		}


}});

b4.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{
		try{
		s=new Socket("localhost",Integer.parseInt(t1.getText()));
		dout= new DataOutputStream(s.getOutputStream());
		din=new DataInputStream(s.getInputStream());
                l4.setText("Connection Established");  
                b19.setVisible(true);    

                    }
                  catch(Exception E)

                    {
                       JOptionPane.showMessageDialog(f,"Not Connected Enter Port Properly");
                      }


b19.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{
                
                      f2=new JFrame("TEST MODES");

 b16.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{                    

                       f3=new JFrame("APTITUDE TEST");
                        try{
                        dout.writeUTF("p");
			String strrecived=din.readUTF();
			String msg = strrecived;
			l44.setText(msg);    
                   }                  
                    catch(Exception E)

                    {
                       System.out.println("error");
                      }
                           
                            
b6.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
				    try{
	               String sout = t3.getText();
			   	   dout.writeUTF(sout);
                         
                         String total = din.readUTF();
                        l44.setText(total);
                         t3.setText("");
                            if(total.contains("Congrates!"))
                                {
                                   l45.setText(total);
                                   s.close();
                                   din.close();
                                   dout.close();
                                   t3.setVisible(false);
                                   b6.setVisible(false);
                                   b10.setVisible(false);  
                                   b20.setVisible(true);                                   
                                   b25.setVisible(true);

                                   l46.setText("Conect Again To Start Next Or New Game"); 
                                 }
					}
					catch(Exception E)
					{
						System.out.println("error1");
					}

                                       }});
 b10.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
				    try{
			   	   dout.writeUTF("Exit");
                                    s.close();
                                   din.close();
                                   dout.close();
                                   l44.setText("You Exited, Connect and Start New!");
                                   t3.setVisible(false);
                                   b6.setVisible(false);
                                   b10.setVisible(false);  
                                   b20.setVisible(true);
                                   l46.setText("Connect Again To Start Next Or New Game"); 
					}
					catch(Exception E)
					{
						System.out.println("error1");
					}

                                       }});
b20.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
f3.setVisible(false);
f2.setVisible(true);
b16.setVisible(false);
b17.setVisible(false);
b28.setVisible(false);
b22.setVisible(true);
}});
b25.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){


try{
                s=new Socket("localhost",Integer.parseInt(t1.getText()));
		dout= new DataOutputStream(s.getOutputStream());
		din=new DataInputStream(s.getInputStream());
               t37.setVisible(true);
               t38.setVisible(true);
                b31.setVisible(true);
                 b32.setVisible(true);
                 b20.setVisible(false);
                 b25.setVisible(false);

                        dout.writeUTF("l");
			String strrecived=din.readUTF();
			String msg = strrecived;
			l44.setText(msg);  


b31.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){

try{
                         String sout = t37.getText();
                         String sout1 = t38.getText();
			 dout.writeUTF(sout);
			 dout.writeUTF(sout1);                         
                         String total = din.readUTF();
                        l44.setText(total);
                         t37.setText("");
                          t38.setText("");
                            if(total.contains("Congrates!"))
                                {
                                   l45.setText(total);
                                   s.close();
                                   din.close();
                                   dout.close();
               t37.setVisible(false);
               t38.setVisible(false);
                b31.setVisible(false);
                 b32.setVisible(false);
                 b20.setVisible(true);

                                   l46.setText("Conect Again To Start Next Or New Game"); 
                                 }
}
catch(Exception E){

System.out.println("error1");
}
                   
}});               
b32.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
try{
 dout.writeUTF("Exit");
dout.writeUTF("Exit");
                                    s.close();
                                   din.close();
                                   dout.close();
                                   l44.setText("You Exited, Connect And Start New!");
                t37.setVisible(false);
               t38.setVisible(false);
                b31.setVisible(false);
                 b32.setVisible(false);
                                   b20.setVisible(true);
                                   l46.setText("Connect Again To Start Next Or New Game");
}
catch(Exception E){

System.out.println("error1");
}

                   
}});  

}
catch(Exception E){

System.out.println("error1");
}


}});

f3.add(t37);
f3.add(t38);
f3.add(b31);
f3.add(b32);
t37.setVisible(false);
t38.setVisible(false);
b31.setVisible(false);
b32.setVisible(false);
f3.add(b25);
b25.setVisible(false);
f3.add(l53);
f3.add(l54);
f3.add(l55);
f3.add(b20);
b20.setVisible(false);
f3.add(b10);
f3.add(b6);
f3.add(t3);
f3.add(l44);
f3.setSize(600,500);
f3.setLayout(null);
f3.setVisible(true);
f.setVisible(false);
f2.setVisible(false);
f3.setDefaultCloseOperation(f3.EXIT_ON_CLOSE);
f3.getContentPane().setBackground(new java.awt.Color(241,156,187));

}});

 b17.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{                    

                        f4=new JFrame("ONLINE TEST");

try{
                                    dout.writeUTF("s");
                                    sk1 = din.readUTF();
                                    sk2 = din.readUTF();
                                    sk3 = din.readUTF();
                                    l31.setText(sk1);
                                    l32.setText(sk2);
                                    l33.setText(sk3); 

                                  b18.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){

try{
                                    String ans1=t31.getText();
                                    String ans2=t32.getText();
                                    String ans3=t33.getText(); 
                                     

                                     dout.writeUTF(ans1);
                                     dout.writeUTF(ans2);
                                     dout.writeUTF(ans3);

                                     String tot = din.readUTF();
                                     l45.setText(tot);
                                    l46.setText("Connect Again To Start Next Or New Game"); 
                                    f4.setVisible(false);
                                    f2.setVisible(true);
                                               b16.setVisible(false);
b17.setVisible(false);
b28.setVisible(false);
b22.setVisible(true);
                                    t31.setText("");
                                    t32.setText("");
                                    t33.setText(""); 
                                   s.close();
                                   din.close();
                                   dout.close();




	}
					catch(Exception E)
					{
						System.out.println("error1");
					}


}});


					}
					catch(Exception E)
					{
						System.out.println("error1");
					}






f4.add(t33);
f4.add(t32);
f4.add(t31);
f4.add(l33);
f4.add(l32);
f4.add(l31);
f4.add(l47);
f4.add(l48);
f4.add(l49);
f4.add(b18);
f4.setSize(600,500);
f4.setLayout(null);
f4.setVisible(true);
f2.setVisible(false);
f4.setDefaultCloseOperation(f4.EXIT_ON_CLOSE);

f4.getContentPane().setBackground(new java.awt.Color(241,156,187));
}});

 b21.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{     
        try{
        t1.setText("");
           f2.setVisible(false);
           f.setVisible(true);
        l4.setText("Thank You For Attending!!!"); 
      
                                    s.close();
                                   din.close();
                                   dout.close();
       b19.setVisible(false);
}
               catch(Exception E){
                     System.out.println("error1");
                 }

}});

 b22.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{     try{
                s=new Socket("localhost",Integer.parseInt(t1.getText()));
		dout= new DataOutputStream(s.getOutputStream());
		din=new DataInputStream(s.getInputStream());
                l46.setText("Connected, You Can Start Now");
                l45.setText("Status");
                                   t3.setVisible(true);
                                   b6.setVisible(true);
                                   b10.setVisible(true);  
                                   b20.setVisible(false);
                                   b16.setVisible(true);
                                   b17.setVisible(true);
                                   b28.setVisible(true);
                                   b22.setVisible(false);

                   }
               catch(Exception E){
                     System.out.println("error1");
                 }


}});


 b28.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{     try{
                     f8=new JFrame("OFFLINE TEST");
                      dout.writeUTF("k");
                      String s1 = din.readUTF();
                      String s2 = din.readUTF();
                      String s3 = din.readUTF();                          
                      l56.setText(s1);
                      l57.setText(s2);
                      l58.setText(s3);

                   b29.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{     try{
                   String path=t36.getText();
                  File fn = new File(path);
if(fn.exists())
{
 dout.writeUTF(path);
byte arr[] = new byte[(int)fn.length()];
FileInputStream fi = new FileInputStream(fn);
fi.read(arr,0,arr.length);
dout.write(arr,0,arr.length);
dout.write(-1);
dout.flush();
fi.close();
l59.setText("File Uploaded Succesfully");
t36.setVisible(false);
b29.setVisible(false);
b30.setVisible(true);
                                   s.close();
                                   din.close();
                                   dout.close();
}
else{
 l59.setText("file not found");
}
}
catch(Exception E){
                     System.out.println("error1");
                 }
                
}});

 b30.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	{     
f8.setVisible(false);
f2.setVisible(true);
l45.setText("status");
b28.setVisible(false);
b16.setVisible(false);
b17.setVisible(false);
b28.setVisible(false);
b22.setVisible(true);
try{
                                    s.close();
                                   din.close();
                                   dout.close();
}
 catch(Exception E){
                     System.out.println("error1");
                 }
l46.setText("Connect Again To Start Next Or New Game"); 
}});
                   }
               catch(Exception E){
                     System.out.println("error1");
                 }
f8.add(l60);
f8.add(l59);
f8.add(l56);
f8.add(l57);
f8.add(l58);
f8.add(t36);
f8.add(b29);
f8.add(b30);
b30.setVisible(false);
f8.setSize(600,500);
f8.setLayout(null);
f8.setVisible(true);
f2.setVisible(false);
f8.setDefaultCloseOperation(f8.EXIT_ON_CLOSE);
f8.getContentPane().setBackground(new java.awt.Color(241,156,187));


}});

f2.add(b28);
f2.add(b16);
f2.add(b17);
f2.add(l45);
f2.add(b21);
f2.add(b22);
f2.add(l46);
f2.setSize(600,450);
f2.setLayout(null);
f2.setVisible(true);
f.setVisible(false);
f2.setDefaultCloseOperation(f2.EXIT_ON_CLOSE);
f2.getContentPane().setBackground(new java.awt.Color(241,156,187));
}});
   


				  










}});
b5.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	        {
                     try{
                     f1=new JFrame("FEEDBACK FORM");
			s1=(Integer.parseInt(t2.getText()));
		         s2=(Integer.parseInt(t4.getText()));
                        ds=new DatagramSocket();
		        ds1=new DatagramSocket(s1);
                        byte[] buff=new byte[1024];
 b15.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	        {
                       try{


                        String str1 = t21.getText();
                        String str2 = t22.getText();
                        String str3 = t23.getText();
                        String str4 = t24.getText();
                        String str5 = t25.getText();
			
			str=str1+" "+str2+" "+str3+" "+str4+" "+str5;
                         byte buffer[] = str.getBytes();
                         ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
                        CheckedInputStream cis = new CheckedInputStream(bais, new Adler32());
                         byte readbuff[]= new byte[1024];
                         while(cis.read(readbuff)>=0){
                            long val = cis.getChecksum().getValue();
			System.out.println("Checksum ="+val);
                           }
			InetAddress ip=InetAddress.getByName("localhost");
			DatagramPacket dp=new DatagramPacket(str.getBytes(),str.length(),ip,s2);
			ds.send(dp);
			DatagramPacket dpreceive=new DatagramPacket(buff,buff.length);
			ds1.receive(dpreceive);
			String rec=new String(dpreceive.getData(),0,dpreceive.getLength());
			l6.setText(rec);
                        f1.setVisible(false);
                        f.setVisible(true);
                        b5.setVisible(false);
                       }
                  catch(Exception E){
                  JOptionPane.showMessageDialog(f,"Not Connected Enter Port Properly");
}
		         
                      
                             }});


                       }
                  catch(Exception E){
			JOptionPane.showMessageDialog(f,"Not Connected Enter Port Properly");
}
                   
f1.add(t21);
f1.add(t22);
f1.add(t23);
f1.add(t24);
f1.add(t25);
f1.add(l21);
f1.add(l22);
f1.add(l23);
f1.add(l24);
f1.add(l25);
f1.add(b15);
f1.setSize(600,700);
f1.setLayout(null);
f1.setVisible(true);
f.setVisible(false);
f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
f1.getContentPane().setBackground(new java.awt.Color(241,156,187));

     }});


 b24.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e)
	        {
             t34.setText(""); 
             t35.setText("");

            f.setVisible(false);
            f7.setVisible(true);

   }});
f.add(cb);
f.add(b24);
f.add(l52);
f.add(l12);
f.add(l13);
f.add(b19);
b19.setVisible(false);
b22.setVisible(false);
f.add(b5);
f.add(l6);
f.add(t4);
f.add(t2);
f.add(l5);
f.add(l10);
f.add(l9);
f.add(l1);
f.add(l8);
f.add(t1);
f.add(b4);
f.add(l4);
f.add(l2);
f.add(t);
f.add(b3);
f.add(l3);
f.add(l7);
f.setSize(600,700);
f.setLayout(null);
f.setVisible(true);
f7.setVisible(false);
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
f.getContentPane().setBackground(new java.awt.Color(241,156,187));


}





public static void main(String[] args)
{
 client c = new client();
c.cli();
}
static class AssociationHandler
        extends AbstractNotificationHandler<PrintStream>
    {
        public HandlerResult handleNotification(AssociationChangeNotification not,
                                                PrintStream stream) {
            if (not.event().equals(AssociationChangeNotification.AssocChangeEvent.COMM_UP)) {
                int outbound = not.association().maxOutboundStreams();
                int inbound = not.association().maxInboundStreams();
                stream.printf("New association setup with %d outbound streams" +
                              ", and %d inbound streams.\n", outbound, inbound);
            }

            return HandlerResult.CONTINUE;
        }

        public HandlerResult handleNotification(ShutdownNotification not,
                                                PrintStream stream) {
            stream.printf("The association has been shutdown.\n");
            return HandlerResult.RETURN;
        }
    }
}
