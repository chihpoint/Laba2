import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.*;

public class Encryption {

    public void fileReader(String pathFrom) throws FileNotFoundException {
            FileReader reader = new FileReader(pathFrom);
    }

    public byte[] encrypt(String text, String keyWord){
        byte[] textByte = text.getBytes();
        byte[] keyByte = keyWord.getBytes();
        byte[] result = new byte[textByte.length];
        for (int i = 0; i < textByte.length; i++)
        {
            result[i] = (byte) (textByte[i] ^ keyByte[i % keyByte.length]); // ^ - Бинарный оператор XOR копирует бит, если он установлен в одном операнде, но не в обоих.
        }
        return result;
    }

    public static byte[] decrypt(String bytes, String keyWord)
    {
        byte[] text = bytes.getBytes();
        byte[] result  = new byte[text.length];
        byte[] keyByte = keyWord.getBytes();
        for(int i = 0; i < text.length; i++)
        {
            result[i] = (byte) (text[i] ^ keyByte[i % keyByte.length]);
        }
        return result;
    }

    public void outFile(String keyC, String keyD, String outputFile, String inputFile) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        String answer;
        if (keyC != null){
            fileOutputStream.write(encrypt(inputFile, keyC));
        }
        else {
            fileOutputStream.write(decrypt(inputFile, keyD));
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}

