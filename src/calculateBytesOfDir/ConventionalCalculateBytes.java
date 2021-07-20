package calculateBytesOfDir;

import java.io.File;

public class ConventionalCalculateBytes {

    public static long calculation(File file) {
        long size = 0;
    
        if (file.isFile()) {
            size = file.length();
        } else {
            File[] arqs = file.listFiles();

            if (arqs != null) {
                for (File arq : arqs) {
                    size += ConventionalCalculateBytes.calculation(arq);
                }
          }
        }
        return size;
    }
}
