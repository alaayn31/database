package leernombre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author dii
 */
public class LeerNombre {

    static void leerDirectorio(String directorio) throws IOException {
        Queue<String> archivo = new LinkedList<>();
        boolean file = true;
        int a = 0;

        Stack<String> path = new Stack<>();
        File f = new File(directorio);

        if (file = f.exists()) {
            File[] files = f.listFiles();
            for (File i : files) {
                if (i.isFile()) {

                    leerArchivo(i.getAbsolutePath());
                } else {
                    path.add(i.getAbsolutePath());
                    leerDirectorio(path.get(a));
                    a++;
                }

            }
        }

    }

    static void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        File arc = new File(archivo);
        String cadena;
        int palabras = 0;
        String ar[];
        int c = 0;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(cadena, "\n");
            int nDatos = tokens.countTokens();
            ar = new String [nDatos];
            int i = 0;
            while (tokens.hasMoreTokens()) {
                String str = tokens.nextToken();
                ar[i] = String.valueOf(str);
                System.out.println(ar[i]);
                i++;
            }

            

        }

        System.out.println(c + " " + palabras + " " + arc.getName());
        b.close();
    }

    public static void main(String[] args) throws IOException {
        //  p();

    }

    public static void p(String texto[]) {
        String palabras[] = texto;
        ArrayList datos = new ArrayList<>();
        for (String palabra : palabras) {
            String minus = palabra.toLowerCase();
            int contador = 0;
            if (!datos.contains(minus)) {
                for (String demas : palabras) {
                    if (demas.toLowerCase().equals(minus)) {
                        contador++;
                    }
                }
                datos.add(minus);
                datos.add(contador);
                System.out.println(minus + ": " + contador + ((contador == 1) ? " vez" : " veces"));
            }
        }
    }

}
