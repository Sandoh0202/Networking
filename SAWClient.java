import java.net.*;
import java.io.*;
class SAWClient
{
	public static void main(String args[])throws IOException
	{
		Socket s = new Socket("localhost",1410);
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		int wsize,frames,i;String str;
		System.out.print("Enter no of frames: ");
		frames = Integer.parseInt(in.readLine());
		System.out.print("Enter window size: ");
		wsize = Integer.parseInt(in.readLine());
		pw.println(wsize);
		for(i=0;i<wsize;i++)
		{
			str = in.readLine();
			pw.println(str);
			str = br.readLine();
			System.out.println(str+" Recieved!");
		}
	}
}