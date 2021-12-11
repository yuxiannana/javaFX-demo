package sample.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class cmdrun {



    public static String runCmd(String cmdpath, String cmd) {
//

        String result = "";
        File dir = new File(cmdpath);
        try {
            double xxy=System.currentTimeMillis();
            Process ps = Runtime.getRuntime().exec(cmd, null, dir);
            InputStreamReader iput=new InputStreamReader(ps.getInputStream(), Charset.forName("GBK"));
            BufferedReader br = new BufferedReader(iput);

            String line = null;
            while ((line = br.readLine()) != null) {
                result =result.concat(line);

            }

            br.close();
            iput.close();
//            System.out.println("close ... ");

            ps.waitFor();
//            System.out.println("wait over ...");

//
            return result;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("child thread donn");

        return null;
    }

}


