# Coding Dojo

- Coding is done in pairs - driver and copilot
- Some mechanism for regular switching of the driver and copilot is chosen (eg TimeBox, PingPong, MicroPairing, NTests, ShoutLouder)
- Two people step up to the keyboard and begin solving the Kata in hand
- Start from scratch
- Use TDD? and BabySteps
- Remember to switch the pair at the keyboard according to the mechanism chosen
- Everyone present is expected to follow what is going on, and make helpful suggestions.
- The pair at the keyboard should explain what they are doing so everyone can follow.
- The audience should give advice/suggest refactorings primarily on a [GreenBar (@c2)]. At other times the pair at the keyboard may ask not to be interrupted. 

This description is from [codingdojo.org][1].

# Tennis Score Kata

## Introduction

Tennis score is a short and fun kata. In a dojo, it can quickly lead to some
discussion about design (e.g. internal representation of the game state).

The original kata is from [codingdojo.org][2]. See [Wikipedia][3] for more
details on tennis rules.

## Kata

Your task is to implement a display for tennis scores. It will be used during
a live television broadcast of the next championship. No pressure!

Scoring rules in tennis are as follows:

1. Players can have either of these points during a game: 0 (or “Love”), 15,
   30, 40. Players cannot have more than 40 points.
2. If a player has 40 points and scores while her opponent has less than 40,
   she wins the game.
3. If both players have 40 points, the score is "deuce".
4. If the score is "deuce" and a player scores, that player holds "advantage".
5. If a player holds advantage and scores again, she wins the game.
6. If a player holds advantage and loses the ball, she loses the advantage and
   the game score returns to "deuce".

Your score display should track the game and show the names of the players,
their points in the current game and indicate which player holds advantage.

Suggestion for an initial interface, just to get started:

```java
@Test
public void displayScoreWithFifteenForPlayerA() {
    ScoreBoard scoreBoard = new ScoreBoard("Nadal", "Federer");
    scoreBoard.scorePointPlayerA();
    assertThat(scoreBoard.getDisplayedScore(), is("Nadal 15 : 0 Federer"));
}
```

## Challenges

* Extend your implementation to track and give an overview of the currently
  played set. A set is a sequence of games. Typically a player wins a set when
  she has won at least two games more than her opponent after at least six
  games have been played.
* Extend your implementation even more, so that one can track an entire match
  using your display software. A match is a sequence of sets and is usually
  decided through either a best of three or a best of five sets system.


[1]: http://www.codingdojo.org/cgi-bin/index.pl?RandoriKata
[2]: http://www.codingdojo.org/cgi-bin/index.pl?KataTennis
[3]: http://en.wikipedia.org/wiki/Tennis#Scoring

