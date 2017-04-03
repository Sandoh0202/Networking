import java.io.*;
import java.net.*;
class GBNServer
{
	public static void main(String args[])throws IOException
	{
		ServerSocket server = new ServerSocket(1410);
		Socket s = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		int wsize = Integer.parseInt(br.readLine());
		String str;int k=0, i;
		for(i=0;i<wsize;i++)							//Loop to recieve the window
			System.out.println("Data Recieved "+(i+1)+": "+br.readLine());
		pw.println(i);									//Sending acknowledgement
		for(i=0;i<wsize;i++)							//Loop to recieve second round
		{
			str=br.readLine();
			if(str.equals("")==true)
				k=i;
			if(k==0)
				System.out.println("Data Recieved "+(i+1)+": "+str);
		}
		pw.println(k);								//Sending acknowledgement for last
		for(i=k;i<wsize;i++)								//Re-recieveing all rejected frames
			System.out.println("Data Recieved "+(i+1)+": "+br.readLine());
		pw.println(i);								//Recieveing final acknowledgements
	}
}