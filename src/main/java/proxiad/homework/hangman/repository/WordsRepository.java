package proxiad.homework.hangman.repository;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@Repository
public class WordsRepository {

    private final Random random = new Random();
    public String fetchRandomWord (){
        List<String> words;
        try {
            String wordsFilePath = "src/main/resources/static/words.txt";
            words = Files.readAllLines(Path.of(wordsFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Reading from file failed. Reason: " + e.getMessage());
        }
        return words.get(random.nextInt(words.size()));
    }
}
