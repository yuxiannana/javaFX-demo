package sample.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {

    public static String fileReader(File file) throws IOException {

        String contants;
        FileReader fr =new FileReader(file);
        BufferedReader br =new BufferedReader(fr);
        //
        contants=br.readLine();
        while (br.ready()){
            contants=contants.concat(br.readLine());

        }
        fr.close();
        return contants;
    }

}
