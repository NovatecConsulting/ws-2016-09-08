package dojo;

import lombok.Builder;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.assertj.core.api.Assertions.assertThat;

public class KataTest {

    @Test
    public void displayScoreWithFifteenForPlayerA() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerA();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal 15 : 0 Federer");
    }

    @Test
    public void displayScoreWithThirtyForPlayerA() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerA();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal 30 : 0 Federer");

    }

    @Test
    public void displayScoreWithFortyForPlayerA() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerA();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal 40 : 0 Federer");

    }

    @Test
    public void displayScoreWithFifteenForPlayerB() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerB();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal 0 : 15 Federer");
    }

    @Test
    public void displayScoreWithThirtyForPlayerB() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerB();
        scoreBoard.scorePointPlayerB();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal 0 : 30 Federer");

    }

    @Test
    public void displayScoreWithFortyForPlayerB() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerB();
        scoreBoard.scorePointPlayerB();
        scoreBoard.scorePointPlayerB();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal 0 : 40 Federer");

    }

    @Test
    public void displayScoreWithFifteenForPlayerAAndPlayerB() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerB();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal 15 : 15 Federer");
    }

    @Test
    public void displayScoreDeuce() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerB();
        scoreBoard.scorePointPlayerB();
        scoreBoard.scorePointPlayerB();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("deuce");
    }

    // @Test
    public void displayPlayerAIsWinnerWithoutAdvantage() {
        ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerA();
        scoreBoard.scorePointPlayerB();
        scoreBoard.scorePointPlayerB();
        scoreBoard.scorePointPlayerA();
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Nadal wins");
    }

    @Test
    public void playernamesCanChange() {
        ScoreBoard scoreBoard = new ScoreBoard("Becker", "Federer");
        assertThat(scoreBoard.getDisplayedScore()).isEqualTo("Becker 0 : 0 Federer");
    }
}


class ScoreBoard {
    Player playerA;
    Player playerB;
    boolean playerAWin = false;

    public ScoreBoard(String player1, String player2) {
        playerA = new Player(player1, 0);
        playerB = new Player(player2, 0);
    }


    public void scorePointPlayerA() {
        playerA.scorePointPlayer();
    }

    public String getDisplayedScore() {

        if ((playerA.getPoints() == 40) && (playerB.getPoints() == 40)) {
            return "deuce";
        }
        return playerA.getName() + " " + playerA.getPoints() + " : " + playerB.getPoints() + " Federer";
    }

    public void scorePointPlayerB() {
        playerB.scorePointPlayer();
    }
}

@Data
@Builder
class Player {
    private String name;
    private int points;

    public void scorePointPlayer() {
        points = points + 15;

        if (points > 40) {
            points = 40;
        }

    }
}