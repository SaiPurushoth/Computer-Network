import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Server{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss=new ServerSocket(1234);
                      
                        
		while(true)
		{

           
			Socket s=ss.accept();
			System.out.println("A new client is connected via "+s);
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                        String check = dis.readUTF();
                        if(check.equals("p"))
                         {
			System.out.println("Assigning a new thread to the client");
			Thread t1=new ClientHandler(s,dis,dout);
			 t1.start();
                         }
                          
                         else if(check.equals("s")){
			System.out.println("Assigning a new thread to the client");
			Thread t2=new TestHandler(s,dis,dout);
			 t2.start();
                                 
                             }
                         else if(check.equals("k")){

			System.out.println("Assigning a new thread to the client");
			Thread t3=new TestHandler1(s,dis,dout);
			t3.start();
                         }
                         else{
			System.out.println("Assigning a new thread to the client");
			Thread t4=new ClientHandler1(s,dis,dout);
			t4.start();
                           }

		}
	}
}
class ClientHandler extends Thread{
	Socket s;
	DataInputStream dis;
	DataOutputStream dout;
	String strrecieved="",strsent="";
       
	ClientHandler(Socket s,DataInputStream dis,DataOutputStream dout)
	{
		this.s=s;
		this.dis=dis;
		this.dout=dout;
                
	}
    private String[] WORDS_DATABASE;
	public void run() 
	{
		try
		{
                  String  line;
                   BufferedReader abc = new BufferedReader(new FileReader("word.txt"));
                   List<String> lines = new ArrayList<String>();
                   while((line=abc.readLine())!=null){
                          lines.add(line);
                           }
                     abc.close();
                     WORDS_DATABASE = lines.toArray(new String[]{});                 

                       int numberOfGuesses = 0;
                       String original = selectRandomWord();
                       String shuffled = getShuffledWord(original);
                       boolean gameOn = true;
                       dout.writeUTF("shuffeled word is "+shuffled);
			while(gameOn)
			{
                                numberOfGuesses++;
                                 String userGuess = dis.readUTF();
                                System.out.println("Client response: "+userGuess);
                                  if(original.equalsIgnoreCase(userGuess)) {
                                              dout.writeUTF("Congrates! ur "+numberOfGuesses+" guesses");
                                                        gameOn = false;
                                         }
                                    else if(userGuess.equals("Exit")){
                                       System.out.println("Client "+this.s+" EXITED");
					this.s.close();
					this.dis.close();
					this.dout.close();
					break;
                                         }


                                                   else {
                                                     dout.writeUTF("Wrong answer for "+ shuffled +" try again or enter 'Exit'");
                                                }
			}
                                      System.out.println("aptitude test done");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

public String selectRandomWord() {
        int rPos = ThreadLocalRandom.current().nextInt(0, WORDS_DATABASE.length);
        return WORDS_DATABASE[rPos];
    }

public String getShuffledWord(String original) {
        String shuffledWord = original;
        int wordSize = original.length();
        int shuffleCount = 10; 
        for(int i=0;i<shuffleCount;i++) {
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord,position1,position2);
        }
        return shuffledWord;
    }



private String swapCharacters(String shuffledWord, int position1, int position2) {
        char[] charArray = shuffledWord.toCharArray();
        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;
        return new String(charArray);
    }
      
}

class ClientHandler1 extends Thread{
	Socket s;
	DataInputStream dis;
	DataOutputStream dout;
	String strrecieved="",strsent="";
       
	ClientHandler1(Socket s,DataInputStream dis,DataOutputStream dout)
	{
		this.s=s;
		this.dis=dis;
		this.dout=dout;
                
	}
    private String[] WORDS_DATABASE;
	public void run() 
	{
		try
		{
                  String  line;
                   BufferedReader abc = new BufferedReader(new FileReader("word.txt"));
                   List<String> lines = new ArrayList<String>();
                   while((line=abc.readLine())!=null){
                          lines.add(line);
                           }
                     abc.close();
                     WORDS_DATABASE = lines.toArray(new String[]{});                 

                       int numberOfGuesses = 0;
                       String original = selectRandomWord();
                       String shuffled = getShuffledWord(original);
                       String original1 = selectRandomWord();
                       String shuffled1 = getShuffledWord(original1);

                       while(original.equals(original1)){
                        original1 = selectRandomWord();
                        shuffled1 = getShuffledWord(original1);
                        }
                       boolean gameOn = true;
                       dout.writeUTF("shuffeled word is "+shuffled+shuffled1);
			while(gameOn)
			{
                                numberOfGuesses++;
                                 String userGuess = dis.readUTF();
                                 String userGuess1 = dis.readUTF();
                                System.out.println("Client response: "+userGuess);
                                System.out.println("Client response: "+userGuess1);
                                  if(original.equalsIgnoreCase(userGuess) && original1.equalsIgnoreCase(userGuess1)) {
                                              dout.writeUTF("Congrates! ur "+numberOfGuesses+" guesses");
                                                        gameOn = false;
                                         }
                                    else if(userGuess.equals("Exit") && userGuess1.equals("Exit") ){
                                       System.out.println("Client "+this.s+" EXITED");
					this.s.close();
					this.dis.close();
					this.dout.close();
					break;
                                         }


                                                   else {
                                                     dout.writeUTF("Wrong answer for "+ shuffled+shuffled1+" try again or enter 'Exit'");
                                                }
			}
                                      System.out.println("aptitude test done");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

public String selectRandomWord() {
        int rPos = ThreadLocalRandom.current().nextInt(0, WORDS_DATABASE.length);
        return WORDS_DATABASE[rPos];
    }

public String getShuffledWord(String original) {
        String shuffledWord = original;
        int wordSize = original.length();
        int shuffleCount = 10; 
        for(int i=0;i<shuffleCount;i++) {
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord,position1,position2);
        }
        return shuffledWord;
    }



private String swapCharacters(String shuffledWord, int position1, int position2) {
        char[] charArray = shuffledWord.toCharArray();
        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;
        return new String(charArray);
    }
      
}




class TestHandler extends Thread{
	Socket s;
        int rPos;
	DataInputStream dis;
	DataOutputStream dout;
	String strrecieved="",strsent="";
       
	TestHandler(Socket s,DataInputStream dis,DataOutputStream dout)
	{
		this.s=s;
		this.dis=dis;
		this.dout=dout;
                
	}
    private String[] QUES_DATABASE;

        private  String[] ANS_DATABASE;

	public void run() 
	{
		try
		{
                    String  line;
                   BufferedReader abc = new BufferedReader(new FileReader("ques.txt"));
                   List<String> lines = new ArrayList<String>();
                   while((line=abc.readLine())!=null){
                          lines.add(line);
                           }
                     abc.close();
                     QUES_DATABASE = lines.toArray(new String[]{});    

                   String  line1;
                   BufferedReader abc1 = new BufferedReader(new FileReader("ans.txt"));
                   List<String> lines1 = new ArrayList<String>();
                   while((line1=abc1.readLine())!=null){
                          lines1.add(line1);
                           }
                     abc1.close();
                     ANS_DATABASE = lines1.toArray(new String[]{});   

                       String ques1 = selectRandomWord();
                       String ans1 = ANS_DATABASE[rPos]; 
                       String ques2 = selectRandomWord();
                       String ans2 = ANS_DATABASE[rPos];
                       String ques3 = selectRandomWord();
                       String ans3 = ANS_DATABASE[rPos];
                       while(ques1.equals(ques2)){
                          ques2 = selectRandomWord();
                          ans2 = ANS_DATABASE[rPos];
                        }
                       while(ques3.equals(ques1) || ques3.equals(ques2)){
                          ques3 = selectRandomWord();
                          ans3 = ANS_DATABASE[rPos];
                        }
                        
                         dout.writeUTF("Q1. "+ques1);
                         dout.writeUTF("Q2."+ques2);
                         dout.writeUTF("Q3. "+ques3);



                        String giv1=dis.readUTF();
                        String giv2=dis.readUTF();
                        String giv3=dis.readUTF();
                 
                               
                              if(giv1.equals(ans1) && giv2.equals(ans2) && giv3.equals(ans3))
                              {
                                dout.writeUTF("Excellent full mark");
                                System.out.println("Client "+this.s+" EXITED");
					this.s.close();
					this.dis.close();
					this.dout.close();
                               }
                              else if(giv1.equals(ans1) && giv2.equals(ans2) || giv2.equals(ans2) && giv3.equals(ans3) || giv1.equals(ans1) && giv3.equals(ans3) )
                            {
                                   dout.writeUTF("very good half mark");
                                   System.out.println("Client "+this.s+" EXITED");
					this.s.close();
					this.dis.close();
					this.dout.close();

                                  }
                            else
                               {
                                     dout.writeUTF("none try again");
                                    System.out.println("Client "+this.s+" EXITED");
					this.s.close();
					this.dis.close();
					this.dout.close();
                                  }



		}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
public String selectRandomWord() {
        rPos = ThreadLocalRandom.current().nextInt(0, QUES_DATABASE.length);
        return QUES_DATABASE[rPos];
    }

}
class TestHandler1 extends Thread{
	Socket s;
        int rPos;
	DataInputStream dis;
	DataOutputStream dout;
	String strrecieved="",strsent="";
       
	TestHandler1(Socket s,DataInputStream dis,DataOutputStream dout)
	{
		this.s=s;
		this.dis=dis;
		this.dout=dout;
                
	}
    private String[] QUES_DATABASE;

	public void run() 
	{
		try
		{

                    String  line;
                   BufferedReader abc = new BufferedReader(new FileReader("ques.txt"));
                   List<String> lines = new ArrayList<String>();
                   while((line=abc.readLine())!=null){
                          lines.add(line);
                           }
                     abc.close();
                     QUES_DATABASE = lines.toArray(new String[]{});     


                       String ques1 = selectRandomWord();
                       String ques2 = selectRandomWord();
                       String ques3 = selectRandomWord();
                       while(ques1.equals(ques2)){
                          ques2 = selectRandomWord();
                        }
                       while(ques3.equals(ques1) || ques3.equals(ques2)){
                          ques3 = selectRandomWord();
                        }

                         dout.writeUTF("Q1. "+ques1);
                         dout.writeUTF("Q2."+ques2);
                         dout.writeUTF("Q3. "+ques3);


                        String path=dis.readUTF();
                        File fn = new File(path);
                        InputStream in = s.getInputStream();
                        FileOutputStream fo = new FileOutputStream(fn);
                        byte i;
                        while((i=(byte)in.read()) !=-1)
                         {
                           fo.write(i);
                          }  
                 fo.close();
                  System.out.println("Client "+this.s+ "Has uploded a file");
					this.s.close();
					this.dis.close();
					this.dout.close();                         



		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}

public String selectRandomWord() {
        rPos = ThreadLocalRandom.current().nextInt(0, QUES_DATABASE.length);
        return QUES_DATABASE[rPos];
    }

}


