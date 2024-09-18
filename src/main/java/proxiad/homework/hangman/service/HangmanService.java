package proxiad.homework.hangman.service;

import org.springframework.stereotype.Service;
import proxiad.homework.hangman.DTO.HangmanSessionDto;
import proxiad.homework.hangman.repository.WordsRepository;
import proxiad.homework.hangman.util.GameStatus;

import java.util.Arrays;

@Service
public class HangmanService {

    private static final int MAX_ATTEMPTS = 7;
    private WordsRepository wordsRepository;
    private String word;
    private StringBuilder mask;
    private int attempts;
    private GameStatus gameStatus;

    public HangmanService(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    public HangmanSessionDto gameStart() {
        fetchWord();
        generateMask();
        attempts = MAX_ATTEMPTS;
        gameStatus = GameStatus.ONGOING;
        return new HangmanSessionDto(mask.toString(), gameStatus);
    }

    public HangmanSessionDto guessLetter(char letter) {
        int beginIndex = 0;
        if(word.indexOf(letter, beginIndex) > -1) {
            updateGameStatus();
            return new HangmanSessionDto(getUpdatedMask(letter), gameStatus);
        }
        attempts--;
        updateGameStatus();
        return new HangmanSessionDto(mask.toString(), gameStatus);
    }

    private void updateGameStatus() {
        if (mask.indexOf("_") == -1) {
            gameStatus = GameStatus.WIN;
            return;
        }
        if (attempts < 1) {
            gameStatus = GameStatus.LOSS;
            return;
        }
    }

    private String getUpdatedMask(char letter) {
        return mask.toString().replace('_', letter);
    }
    private void fetchWord() {
        word = wordsRepository.fetchRandomWord();
    }

    private void generateMask() {
        char[] filler = new char[word.length()];
        Arrays.fill(filler, '_');
        mask.append(filler);
    }
}
