package MultiFileReader;

import java.io.*;
import java.nio.file.Path;

public class MultiFileReader {
    private FileReader currentReader;
    private File[] files;
    private int currentIndex;

    public MultiFileReader(File[] files) throws FileNotFoundException {
        this.files = files;
        currentIndex = 0;
        currentReader = new FileReader(files[currentIndex]);
    }

    public int read(char[] cbuf, int n) throws IOException {
        int totalRead = 0;
        while (totalRead < n) {
            int read = currentReader.read();
            if (read == -1) {
                System.out.println("Switching to new file");
                // 如果当前文件已经读完，则关闭当前文件的reader
                currentReader.close();
                currentIndex++;
                if (currentIndex >= files.length) {
                    // 所有文件都已经读完，结束
                    System.out.println("n is " + n + " TotalRead is " + totalRead + " Reading chars for " + new String(cbuf));
                    return totalRead;
                } else {
                    // 开始读取下一个文件
                    currentReader = new FileReader(files[currentIndex]);
                }
            } else {
                cbuf[totalRead++] = (char)read;

            }
        }
        System.out.println("n is " + n + " TotalRead is " + totalRead + " Reading chars for " + new String(cbuf));
        return totalRead;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zichengliu/interviews/snowflake/src/MultiFileReader/text1.txt");
        File file2 = new File("/Users/zichengliu/interviews/snowflake/src/MultiFileReader/text2.txt");
        File[] files = new File[2];
        files[0] = file;
        files[1] = file2;
        MultiFileReader reader = new MultiFileReader(files);

        while (reader.currentReader.ready()) {
            int n = 3;
            char[] cbuf = new char[3];
            reader.read(cbuf, n);
        }
    }
}