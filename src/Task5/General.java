package Task5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class General {
    static int counter = 0;
    public static void main(String[] args) {
        System.out.println("Введите путь к файлу:");
        String path = Task3.General.reader();
        System.out.println("Введите запрещённое слово:");
        byte[] unavailable = Task3.General.reader().getBytes();
        System.out.println("Введите слово для замены:");
        byte[] word = Task3.General.reader().getBytes();
        solution(Task3.General.getTextFromFile(path), Task3.General.getWord(word), Task3.General.getWord(unavailable), path);
    }

    private static void solution(String[] text, String word, String unavailable, String path) {
        for (int i = 0; i < text.length; i++) {
            if (text[i].equals(unavailable)) {
                text[i] = word;
                counter++;
            }
        }
        StringBuilder textString = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            if (i == text.length - 1) {
                textString.append(text[i]);
                break;
            }
            textString.append(text[i]);
            textString.append(" ");
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
        System.out.println("Заменено " + counter + " слова");
    }
}
