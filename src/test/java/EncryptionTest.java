
import com.chihpoint.Encryption;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptionTest {

    @Test
    public void encrypt1() throws Exception {
        Encryption.main("-c 7E7 test2 -o outputFile".split(" "));
        FileInputStream file = new FileInputStream("outputFile");
        int c = file.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = file.read();
        }
        assertEquals("@,YC E", answer);
    }

    @Test
    public void decrypt1() throws Exception {
        Encryption.main("-c 7E7 test1dec -o outputFile".split(" "));
        FileInputStream file = new FileInputStream("outputFile");
        int c = file.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = file.read();
        }
        assertEquals("winter", answer);
    }

    @Test
    public void encrypt2() throws Exception {
        Encryption.main("-c 7E7 encrypt2 -o outputFile".split(" "));
        FileInputStream file = new FileInputStream("outputFile");
        int c = file.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = file.read();
        }
        assertEquals("{$UVw", answer);
    }

    @Test
    public void decrypt2() throws Exception {
        Encryption.main("-c 7E7 decrypt2 -o outputFile".split(" "));
        FileInputStream file = new FileInputStream("outputFile");
        int c = file.read();
        String answer = "";
        while (c != -1) {
            answer += (char)c;
            c = file.read();
        }
        assertEquals("Laba2", answer);
    }
}


