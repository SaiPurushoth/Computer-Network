import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import com.sun.nio.sctp.MessageInfo;
import com.sun.nio.sctp.SctpChannel;
import com.sun.nio.sctp.SctpServerChannel;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.*;  
import java.net.*;
import java.io.*;

public class DaytimeServer {
    static int SERVER_PORT = 3456;
    static int US_STREAM = 0;
    static int FR_STREAM = 1;
    static int NR_STREAM = 2;
    static int JR_STREAM = 3;
    static int AR_STREAM = 4;

    static SimpleDateFormat USformatter = new SimpleDateFormat(
                                "h:mm:ss a EEE d MMM yy, zzzz", Locale.US);
    static SimpleDateFormat FRformatter = new SimpleDateFormat(
                                "h:mm:ss a EEE d MMM yy, zzzz", Locale.FRENCH);
    static SimpleDateFormat JRformatter = new SimpleDateFormat(
                                "h:mm:ss a EEE d MMM yy, zzzz", Locale.JAPANESE);

    public static void main(String[] args) throws Exception {
        SctpServerChannel ssc = SctpServerChannel.open();
        InetSocketAddress serverAddr = new InetSocketAddress(SERVER_PORT);
        ssc.bind(serverAddr);

        ByteBuffer buf = ByteBuffer.allocateDirect(130);
        CharBuffer cbuf = CharBuffer.allocate(130);
        Charset charset = Charset.forName("ISO-8859-1");
        CharsetEncoder encoder = charset.newEncoder();
            System.out.println("5 stream has created");
        while (true) {
            SctpChannel sc = ssc.accept();
            
             Thread t1 = new Clienthandler(sc,buf,cbuf,charset,encoder);
              t1.start();
          
             }


    }
}


class Clienthandler extends Thread{
SctpChannel sc;
ByteBuffer buf;
CharBuffer cbuf;
Charset charset;
CharsetEncoder encoder;
Clienthandler(SctpChannel sc,ByteBuffer buf,CharBuffer cbuf,Charset charset,CharsetEncoder encoder)
{
this.sc=sc;
this.buf=buf;
this.cbuf=cbuf;
this.charset=charset;
this.encoder=encoder;
}



public void run()
{
try
{
   
            Date today = new Date();
            System.out.println(today);
            DaytimeServer.USformatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));   
            cbuf.put(DaytimeServer.USformatter.format(today)).flip();
            encoder.encode(cbuf, buf, true);
            buf.flip();

            /* send the message on the US stream */
            MessageInfo messageInfo = MessageInfo.createOutgoing(null,
                                                                 DaytimeServer.US_STREAM);

            sc.send(buf, messageInfo);
            System.out.println("time 1 has sent in "+this.sc+" msg-details:"+messageInfo);

            cbuf.clear();

             DaytimeServer.FRformatter.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));  
            cbuf.put(DaytimeServer.FRformatter.format(today)).flip();
            buf.clear();
            encoder.encode(cbuf, buf, true);
            buf.flip();

            /* send the message on the French stream */
            messageInfo.streamNumber(DaytimeServer.FR_STREAM);
            sc.send(buf, messageInfo);
            System.out.println("time 2 has sent in "+this.sc+" msg-details:"+messageInfo);
            cbuf.clear();

 
            DaytimeServer.USformatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));  
            cbuf.put(DaytimeServer.USformatter.format(today)).flip();
            buf.clear();
            encoder.encode(cbuf, buf, true);
            buf.flip();
            
            messageInfo.streamNumber(DaytimeServer.NR_STREAM);
            sc.send(buf, messageInfo);
            System.out.println("time 3 has sent in "+this.sc+" msg-details:"+messageInfo);
            cbuf.clear();

            DaytimeServer.JRformatter.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  
            cbuf.put(DaytimeServer.JRformatter.format(today)).flip();
            buf.clear();
            encoder.encode(cbuf, buf, true);
            buf.flip();
            
            messageInfo.streamNumber(DaytimeServer.JR_STREAM);
            sc.send(buf, messageInfo);
            System.out.println("time 4 has sent in "+this.sc+" msg-details:"+messageInfo);
             cbuf.clear();
            
            DaytimeServer.USformatter.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));  
            cbuf.put(DaytimeServer.USformatter.format(today)).flip();
            buf.clear();
            encoder.encode(cbuf, buf, true);
            buf.flip();
            
            messageInfo.streamNumber(DaytimeServer.AR_STREAM);
            sc.send(buf, messageInfo);
            System.out.println("time 5 has sent in "+this.sc+" msg-details:"+messageInfo);
            cbuf.clear();



         buf.clear();
         sc.close();
}
catch(Exception e)
{
   System.out.println(e);
}


}
}       
