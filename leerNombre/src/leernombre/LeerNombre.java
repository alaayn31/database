/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leernombre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        int c = 0;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            c++;
            StringTokenizer st = new StringTokenizer(cadena);
            palabras += st.countTokens();

        }

        System.out.println(c + " " + palabras + " " + arc.getName());
        b.close();
    }

    public static void main(String[] args) throws IOException {
        leerDirectorio(args[0]);

    }

}
