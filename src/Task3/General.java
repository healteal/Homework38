package Task3;

import java.io.*;

public class General {
    public static void main(String[] args) {
        int counter = 0;
        System.out.println("Введите путь к файлу:");
        String path = reader();
        System.out.println("Введите искомое слово:");
        byte[] word = reader().getBytes();
        File file = new File(path);
        FileInputStream fileInputStream;
        byte[] fileText = new byte[(int) file.length()];
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuilder fileTextString = new StringBuilder();
        StringBuilder wordString = new StringBuilder();
        for (byte b : fileText) {
            fileTextString.append(b);
        }
        String[] splitText = String.valueOf(fileTextString).split("32");
        for (byte b : word) {
            wordString.append(b);
        }
        for (String s : splitText) {
            if (s.equals(String.valueOf(wordString))) {
                counter++;
            }
        }
        System.out.println(counter + " слова");
    }

    private static String reader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String returned;
        try {
            returned = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return returned;
    }
}
