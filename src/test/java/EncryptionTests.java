import com.chihpoint.Main;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptionTests {

    @Test
    public void encrypt1() throws Exception {
        Main.main("-c 7E7 test1 -o outputFile".split(" "));
        FileInputStream file = new FileInputStream("outputFile");
        int c = file.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = file.read();
        }
        assertEquals("C DCt", answer);
    }
}


