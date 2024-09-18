package proxiad.homework.hangman.DTO;

import proxiad.homework.hangman.util.GameStatus;

public class HangmanSessionDto {

    private String mask;
    private GameStatus gameStatus;

    public HangmanSessionDto(String mask, GameStatus gameStatus) {
        this.mask = mask;
        this.gameStatus = gameStatus;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
