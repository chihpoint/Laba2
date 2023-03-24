package com.chihpoint;//package com.chihpoint;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class Parser {@Option(name = "-c", usage = "Данил Сергеевич, поставьте 5, пожалуйста", forbids = {"-d"})
private String keyC;
    @Option(name = "-d", usage = "У вас крутые шутки!", forbids = {"-c"})
    private String keyD;
    @Option(name = "-o", usage = "Вы самый крутой!")
    private String outputFile;
    @Argument(metaVar = "file.txt")
    private String inputFile;

    public void parser(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }

        Encryption encryption = new Encryption();

        encryption.outFile(keyC,keyD,outputFile,inputFile);

    }

}
