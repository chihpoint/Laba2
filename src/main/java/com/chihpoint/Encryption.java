package com.chihpoint;


import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.*;

public class Encryption {
    @Option(name = "-c", usage = "Данил Сергеевич, поставьте 5, пожалуйста", forbids = {"-d"})
    private String keyC;
    @Option(name = "-d", usage = "У вас крутые шутки!", forbids = {"-c"})
    private String keyD;
    @Option(name = "-o", usage = "Вы самый крутой!")
    private String outputFile;
    @Argument(metaVar = "file.txt")
    private String inputFile;

    public void parser(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        Encryption encryption = new Encryption();
        try {
            parser.parseArgument(args);
            if (args.length != 0) {
                encryption.outFile(keyC, keyD, outputFile, inputFile);
            } else {
                System.out.println("Args doesn't exists");
            }
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }
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
        String text = "";
        try {
            File file = new File(inputFile);
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = input.readLine();
            while (line != null) {
                text += line;
                line = input.readLine();
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        if (keyC != null){
            fileOutputStream.write(encrypt(text, keyC));
        }
        else if (keyD != null){
            fileOutputStream.write(decrypt(text, keyD));
        }
        else {
            System.out.println("nulls");
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }
    public static void main(String[] args) throws IOException {
        Encryption enc = new Encryption();
        enc.parser(args);
    }
}
