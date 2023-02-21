package MultiFileReader;

import java.io.*;

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
        while (totalRead < n && currentReader.ready()) {
            int numRead = currentReader.read(cbuf, totalRead, n - totalRead);
            if (!currentReader.ready()) {
                // 如果当前文件已经读完，则关闭当前文件的reader
                currentReader.close();
                currentIndex++;
                if (currentIndex >= files.length) {
                    // 所有文件都已经读完，结束
                    totalRead += numRead;
                    System.out.println("n is " + n + " TotalRead is " + totalRead + " Reading chars for " + new String(cbuf));
                    return totalRead;
                } else {
                    // 开始读取下一个文件
                    System.out.println("Switching to new file");
                    currentReader = new FileReader(files[currentIndex]);
                }
            }
            totalRead += numRead;

        }
        System.out.println("n is " + n + " TotalRead is " + totalRead + " Reading chars for " + new String(cbuf));
        return totalRead;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zichengliu/workspace/interviews/snowflake/src/MultiFileReader/text1.txt");
        File file2 = new File("/Users/zichengliu/workspace/interviews/snowflake/src/MultiFileReader/text2.txt");
        File[] files = new File[2];
        files[0] = file;
        files[1] = file2;
        MultiFileReader reader = new MultiFileReader(files);

        while (reader.currentReader.ready()) {
            int n = 15;
            char[] cbuf = new char[15];
            reader.read(cbuf, n);
        }
    }
}