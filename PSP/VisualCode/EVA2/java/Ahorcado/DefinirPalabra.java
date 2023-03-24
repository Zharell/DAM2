package EVA2.java.Ahorcado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DefinirPalabra {
    public static String getPalabra() {
        List<String> words = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\Javier\\ClasesGit\\PSP\\VisualCode\\EVA2\\java\\Ahorcado\\palabraSecreta.txt");
            
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());
        String randomWord = words.get(randomIndex);

        return randomWord;
    }
}
