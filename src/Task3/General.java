package Task3;

import java.io.*;

public class General {
    static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Введите путь к файлу:");
        String path = reader();
        System.out.println("Введите искомое слово:");
        byte[] word = reader().getBytes();
        solution(getTextFromFile(path), getWord(word));
    }

    public static String reader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String returned;
        try {
            returned = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return returned;
    }

    private static void solution(String[] text, String word) {
        for (String s : text) {
            if (s.equals(word)) {
                counter++;
            }
        }
        System.out.println(counter + " слова");
    }

    public static String[] getTextFromFile(String path) {
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
        for (byte b : fileText) {
            fileTextString.append((char) b);
        }
        return String.valueOf(fileTextString).split(" ");
    }

    public static String getWord(byte[] word) {
        StringBuilder wordStringBuilder = new StringBuilder();
        for (byte b : word) {
            wordStringBuilder.append((char) b);
        }
        return String.valueOf(wordStringBuilder);
    }
}
