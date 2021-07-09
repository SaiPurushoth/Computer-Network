import java.net.*;
import java.io.*;
import java.util.*;
import java.util.zip.*;
public class UDPServer{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds=new DatagramSocket(7777);
                 FileWriter obj = new FileWriter("/home/sai/udpserver/feedback.txt",true);
		byte[] buff=new byte[1024];
		while(true){
			DatagramPacket dpreceive=new DatagramPacket(buff,buff.length);
			ds.receive(dpreceive);
			String str=new String(dpreceive.getData(),0,dpreceive.getLength());
			if(str.equals("bye"))
			{
				System.out.println("Server Is Exiting .... BYE");
				break;
			}
                        System.out.println("Client feedback:");
                        System.out.println(str);
                        obj.write(str);
                        obj.close();
                         byte buffer[] = str.getBytes();
                         ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
                        CheckedInputStream cis = new CheckedInputStream(bais, new Adler32());
                         byte readbuff[]= new byte[1024];
                         while(cis.read(readbuff)>=0){
                            long val = cis.getChecksum().getValue();
			System.out.println("Checksum ="+val);
                           }
			buff=new byte[1024];
			String str1="Thank you for your feedback";
			InetAddress ip=InetAddress.getByName("localhost");
			DatagramPacket dp=new DatagramPacket(str1.getBytes(),str1.length(),ip,6000);
			ds.send(dp);
		}
		
	}
}
