# Peeveli 😈

**Peeveli** is a devilishly clever word-guessing game written in Scala, inspired by Hangman — but with a twist: the computer doesn't play fair. Instead of selecting a word in advance, it adapts its strategy throughout the game to keep as many words as possible in play.

The name "Peeveli" is an old Finnish word for "devil," which fits the game’s deceptive behavior perfectly.

---

## Game Concept

In **Peeveli**, you (the human) try to guess a hidden word letter by letter — but the computer (the riddler) is cheating:

- It doesn't choose a single word.
- Instead, it keeps a list of all possible valid words.
- With each guess, it selects the most "advantageous" interpretation, often revealing the **least** helpful information.

This makes the game surprisingly hard to beat!

---

### Requirements

- Scala
- SBT (Scala Build Tool)

### Run the game

```bash
git clone https://github.com/Mustafa0Alalawi/peeveli-game.git
cd peeveli-game
sbt run
```

---

## How to Play

- Run the game to launch the GUI.
- Enter letter guesses to uncover the hidden word.
- Be careful — the computer tries to mislead you as long as it can!

Missed guesses are tracked using red letters (not a hanging figure).

---


## Demo
<img width="636" alt="Screenshot 2025-05-13 at 19 05 46" src="https://github.com/user-attachments/assets/d2d7aa5e-378b-405f-96aa-b7999f95e716" />

<img width="636" alt="Screenshot 2025-05-13 at 19 06 02" src="https://github.com/user-attachments/assets/d574964c-2c1b-4780-a938-49165636a3a1" />

