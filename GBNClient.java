import java.io.*;
import java.net.*;
class GBNClient
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
		int wsize = Integer.parseInt(str);
		int ack=0,i;
		pw.println(str);
		for(i=0;i<wsize;i++)				//Sending first round
		{
			System.out.print("\nEnter Data"+(i+1)+":");
			str=in.readLine();
			pw.println(str);
		}
		ack = Integer.parseInt(br.readLine());	//Recieveing acknowledgement
		for(i=0;i<wsize;i++)				//Sending second round
		{
			System.out.print("\nEnter Data "+(i+1)+" : ");
			str=in.readLine();
			pw.println(str);
		}
		ack = Integer.parseInt(br.readLine());
		System.out.println("Last acknowledgement recieved: "+ack);
		for(i=ack;i<wsize;i++)				//Resending rejected frames
		{
			System.out.print("\nEnter Data"+(i+1)+":");
			str=in.readLine();
			pw.println(str);
		}
		ack = Integer.parseInt(br.readLine());	//Recieveing final acknowledgement
		System.out.println("Acknowledgemt "+ack+" recieved!\nSuccessful!");
	}
}