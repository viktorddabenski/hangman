package proxiad.homework.hangman.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import proxiad.homework.hangman.DTO.HangmanSessionDto;
import proxiad.homework.hangman.service.HangmanService;

@RestController
public class HangmanController {

    private HangmanService hangmanService;

    public HangmanController(HangmanService hangmanService) {
        this.hangmanService = hangmanService;
    }

    @GetMapping(value = "/start")
    public ResponseEntity<HangmanSessionDto> gameStart() {
        HangmanSessionDto hangmanSessionDto = hangmanService.gameStart();
        return new ResponseEntity<>(hangmanSessionDto, HttpStatus.OK);
    }

    @GetMapping(value = "/guess")
    public ResponseEntity<HangmanSessionDto> guessLetter(@RequestParam("letter") char letter) {
        HangmanSessionDto hangmanSessionDto = hangmanService.guessLetter(letter);
        return new ResponseEntity<>(hangmanSessionDto, HttpStatus.OK);
    }
}
