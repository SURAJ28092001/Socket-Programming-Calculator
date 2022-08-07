    import java.net.*;
import java.io.*;
public class client
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("============Client======================");
        Socket s = new Socket("127.0.0.1",10000);
        System.out.println("Connected to the Server");
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        // dout.writeUTF("Hello Server");
        DataInputStream din = new DataInputStream(s.getInputStream());
        // String str = (String)din.readUTF();   
        // System.out.println("Server : "+str);
        String str = "";
        int c = -1;
        int a = 0,b = 0,ans = 0;
        while(c != 0)
        {
            str = (String)din.readUTF();
            System.out.println("Server : ");
            System.out.println(str);
            c = Integer.parseInt(br.readLine());
            dout.writeUTF(Integer.toString(c));
            if(c == 0)
                break;
            if(c > 4)
            {
                System.out.println("Server : "+ din.readUTF());
                continue;
            }
            System.out.print("Server : ");
            System.out.println(din.readUTF());
            a = Integer.parseInt(br.readLine());
            dout.writeUTF(Integer.toString(a));
            System.out.print("Server : ");
            System.out.println(din.readUTF());
            b = Integer.parseInt(br.readLine());
            dout.writeUTF(Integer.toString(b));
            System.out.println("Server : "+din.readUTF());
        }
        
        
        
        
        
        
        s.close();
    }
}