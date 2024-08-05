package class01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {

    public static void main(String[] args) {
        String sourceFilePath = "C:\\AHN-WorkSpace\\day020\\src\\class01\\AHN.png";
        String destinationFilePath = "C:\\AHN-WorkSpace\\day020\\src\\class01\\AHN2.png";

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            System.out.println("파일 복사가 완료되었습니다!");
            fos.close();

        } catch (IOException e) {
            System.out.println("파일 복사 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}

