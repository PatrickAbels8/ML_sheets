package sheet01;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {
    /**
     * A really simple parser with nearly NO sanity checks! Have fin beeing insane!
     * @param is - Luckily not the Islamic State.
     * @return Maybe a sane ARFF File Represented as POJOs.
     */

    public static ARFFfile parseARFF(InputStream is) {
        if (is == null)
            return null;
        ARFFfile result = null;

        Scanner scanner = new Scanner(new BufferedInputStream(is));


        boolean data = false;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (data) {
                if (result != null) {
                    result.getData().addRow(line.split(","));
                } else System.err.println("no ARFF File");
                continue;
            }


            if (line.startsWith("%"))
                continue;

            if (line.startsWith("@relation")) {
                result = new ARFFfile(line.split(" ")[1]);
                System.out.println(result);
            } else if (line.startsWith("@attribute")) {
                String[] spl = line.split(" ");
                String name = spl[1];
                NominalAttribute att = new NominalAttribute(name);
                if (result != null) {
                    result.addAttribute(att);
                }

                for (int i = 2; i < spl.length; i++) {
                    String value = spl[i].replace(",", "").replace("{", "").replace("}", "");
                    System.out.println(value);
                    att.addValue(value);
                }
            }

            else if (line.startsWith("@data")) {
                data = true;
            }

            else {
                System.out.println(line);
            }

        }

        scanner.close();


        /*StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(new BufferedInputStream(is)));
        streamTokenizer.commentChar('%');
        //streamTokenizer.ordinaryChar('@');
        /*while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {

            if(streamTokenizer.ttype==StreamTokenizer.TT_WORD)  {
                System.out.print(" "+streamTokenizer.sval);
            } if(streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println("EOL");
            }
        }
        streamTokenizer.close();
        */


        return result;
    }
}

