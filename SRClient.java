import java.net.*;
import java.io.*;
class SRClient
{
	public static void main(String args[])throws IOException
	{
		Socket s = new Socket("localhost",1410);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		System.out.print("Enter no. of frames: ");
		int frames = Integer.parseInt(in.readLine());
		System.out.print("\nEnter window size: ");
		String str=in.readLine();
		int wsize = Integer.parseInt(str),i=0,a;
		pw.println(str);
		while(true)
		{
			if(i>=wsize)
				break;
			System.out.print("\nEnter Data"+(i+1)+":");
			str=in.readLine();
			pw.println(str);
			a=Integer.parseInt(br.readLine());
			if(a==1)
				i++;
			else
				System.out.println("Request recieved to resend frame "+(i+1));
		}
	}
}