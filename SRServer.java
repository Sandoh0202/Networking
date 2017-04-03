import java.io.*;
import java.net.*;
class SRServer
{
	public static void main(String args[])throws IOException
	{
		ServerSocket server = new ServerSocket(1410);
		Socket s = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		int wsize = Integer.parseInt(br.readLine());
		int i=0,c;String str;
		while(true)
		{
			str=br.readLine();
			if(str.equals("")==true)
			{
				pw.println(0);
				System.out.println("Negative acknowledgement sent!")
			}	
			else
			{
				System.out.println("Data "+(++i)+" recieved: "+str);
				pw.println(1);
			}
		}
	}
}