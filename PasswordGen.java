import java.util.*;
import java.io.*;
public class PasswordGen{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the text file name");
        String TF = s.next();
        TF = TF + ".txt";
        System.out.println("Enter number of passwords to be generated");
        int num = s.nextInt();
        System.out.println("Enter the length of each password");
        int len = s.nextInt();
        s.close();
        TextWriter(num,len,TF);

    }

    public static void TextWriter(int b, int a, String Text){
        String[] arr = new String[b];
        for (int j =0; j<b; j++){
            arr[j] = MakePass(a);
        }
        try{
            FileWriter fw = new FileWriter(Text);
            for (int k =0; k<b; k++){
                fw.write(arr[k]+"\n");

            }
            fw.close();
        }
        catch(IOException ex){
            System.out.println("error occurred");
        }
    }


    public static String MakePass(int a){
        String str = " ";
        for (int i =0; i<a; i++){

            if (i!= 0 && i%4 ==0){
                str = str + "-";
            }
            str = str + RandChar();
        }
        return str;
    }

    public static char RandChar(){
        char c = ' ';
        Random r = new Random();
        boolean fla = false;
        while (fla == false) {
            int i = r.nextInt(123); 
            if (i< 123 && i>=97){
                fla = true;
                c = (char)(i);
            }
            if (i<91 && i>=65){
                fla = true;
                c = (char)(i);

            }

            if (i<58 && i>=48){
                fla = true;
                c = (char)(i);
            }


        }
        return c;
    }



}