import java.net.*;
import java.io.*;
class SAWServer
{
	public static void main(String args[])throws IOException
	{
		ServerSocket server = new ServerSocket(1410);
		Socket s = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		int wsize = Integer.parseInt(br.readLine());
		String str;
		for(int i=0;i<wsize;i++)
		{
			str = br.readLine();
			System.out.println("Data Recieved: "+str);
			pw.println("Acknowledgement");
		}
	}
}