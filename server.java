import java.net.*;
import java.io.*;
public class server
{
    public static void main(String args[]) throws IOException
    {
        System.out.println("============Server======================");
        ServerSocket ss = new ServerSocket(10000);
        System.out.println("Server is Setup");
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        // String str = (String)din.readUTF();
        // System.out.println("Client : "+str);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        // dout.writeUTF("Hello Client");
        String str = "";
        int c = -1;
        int a = 0,b = 0,ans = 0;
        while(c != 0)
        {
            str = "===========Calculator Menu==============\nPress 1 for Addition : \nPress 2 for Subtraction : \nPress 3 for Multiplication : \nPress 4 for Division : \nPress 0 to Exit\n";
            System.out.println(str);
            dout.writeUTF(str);
            c = Integer.parseInt(din.readUTF());
            System.out.println("Client : "+c);
            switch(c)
            {
                case 0:
                    {
                        dout.writeUTF("Exited");
                        ss.close();
                        break;
                    }
                case 1:
                    {
                        dout.writeUTF("Enter a for a+b expression : ");
                        System.out.println("Enter a for a+b expression : ");
                        a = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+a);
                        System.out.println("Enter b for a+b expression : ");
                        dout.writeUTF("Enter b for a+b expression : ");
                        b = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+b);
                        ans = a + b;
                        System.out.println(ans);
                        dout.writeUTF(Integer.toString(ans));
                        break;
                    }
                case 2:
                    {
                        dout.writeUTF("Enter a for a-b expression : ");
                        System.out.println("Enter a for a-b expression : ");
                        a = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+a);
                        System.out.println("Enter b for a-b expression : ");
                        dout.writeUTF("Enter b for a-b expression : ");
                        b = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+b);
                        ans = a - b;
                        System.out.println(ans);
                        dout.writeUTF(Integer.toString(ans));
                        break;
                    }
                case 3:
                    {
                        dout.writeUTF("Enter a for a*b expression : ");
                        System.out.println("Enter a for a*b expression : ");
                        a = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+a);
                        System.out.println("Enter b for a*b expression : ");
                        dout.writeUTF("Enter b for a*b expression : ");
                        b = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+b);
                        ans = a * b;
                        System.out.println(ans);
                        dout.writeUTF(Integer.toString(ans));
                        break;
                    }
                case 4:
                    {
                        dout.writeUTF("Enter a for a/b expression : ");
                        System.out.println("Enter a for a/b expression : ");
                        a = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+a);
                        System.out.println("Enter b for a/b expression : ");
                        dout.writeUTF("Enter b for a/b expression : ");
                        b = Integer.parseInt(din.readUTF());
                        System.out.println("Client : "+b);
                        if(b == 0)
                        {
                            dout.writeUTF("Invalid Operand b which is 0.");
                            continue;
                        }
                        double ans1 = a / b;
                        System.out.println(ans1);
                        dout.writeUTF(Double.toString(ans1));
                        break;
                    }
                default:
                    {
                        System.out.println("Invalid Choice Please Try Again.");
                        dout.writeUTF("Invalid Choice Please Try Again.");
                        break;
                    }
            }
        }
        
    }
}