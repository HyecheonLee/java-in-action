package ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();

    public static void main(String[] args) throws IOException {
        final String result = processFileLimited();
        System.out.println(result);

        final String oneLine = processFile((BufferedReader b) -> b.readLine());
        System.out.println(oneLine);

        final String twoLines = processFile(bufferedReader -> bufferedReader.readLine() + bufferedReader.read());
        System.out.println(twoLines);
    }

    private static String processFile(BufferedReaderProcessor p) throws IOException {
        try (final BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return p.process(br);
        }
    }

    private static String processFileLimited() throws IOException {
        try (final BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return br.readLine();
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader bufferedReader) throws IOException;
    }
}
