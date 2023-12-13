package Labs7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Lozinki {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Hashtable<String,String> hash = new Hashtable<>();

        for(int i=1;i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            hash.put(pom[0],pom[1]);
        }

        while(true){
            String line = br.readLine();
            String[] parts = line.split(" ");

            if(line.equals("KRAJ")){
                break;
            }

            if(hash.containsKey(parts[0]) && hash.get(parts[0]).equals(parts[1])){
                System.out.println("Najaven");
                break;
            } else {
                System.out.println("Nenajaven");
            }
        }
    }
}