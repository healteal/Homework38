package Task7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class General {
    static int counter = 0;
    public static void main(String[] args) {
        System.out.println("Введите путь к файлу:");
        String path = Task3.General.reader();
        System.out.println("Введите количество запрещённых слов:");
        int count = Integer.parseInt(Task3.General.reader());
        String[] words = new String[count];
        for (int i = 0; i < words.length; i++) {
            System.out.println("Введите запрещённое слово, осталось " + (count - i) + ":");
            words[i] = Task3.General.reader();
        }
        solution(Task3.General.getTextFromFile(path), words, path);
    }

    private static void solution (String[] text, String[] unavailable, String path) {
        for (String s : unavailable) {
            for (int j = 0; j < text.length; j++) {
                if (Objects.equals(s, text[j])) {
                    text[j] = null;
                    counter++;
                }
            }
        }
        StringBuilder textString = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null && i == text.length - 1) {
                textString.append(text[i]);
                break;
            }
            if (text[i] != null) {
                textString.append(text[i]);
                textString.append(" ");
            }
        }
        byte[] textToFile = String.valueOf(textString).getBytes();
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.write(textToFile, 0, textToFile.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(textString);
        System.out.println("Заменено " + counter + " слова");
    }
}
