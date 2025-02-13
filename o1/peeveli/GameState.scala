package o1.peeveli

import o1.peeveli.GameState.Unrevealed

class GameState(val missesAllowed: Int, val previousGuesses: String, val visibleWord: String, val viableSolutions: Vector[String]):

  def this(missesAllowed: Int, length: Int, vocabulary: Vector[String]) =
    this(missesAllowed, "", "_" * length, vocabulary.filter(_.length == length).map(_.toUpperCase))

  def wordLength: Int = visibleWord.length

  def numberOfSolutions: Int = viableSolutions.size

  def isLost: Boolean = missesAllowed < 0

  def isWon: Boolean = !visibleWord.contains('_')

  private def reveal(guess: String): String =
    def revealPart(int: Int) =
      if guess(int) == Unrevealed then
        this.visibleWord(int)
      else guess(int)
    this.visibleWord.indices.map(revealPart).mkString

  def guessLetter(guess: Char): GameState =
    def leftGroup(string: String) = string.map(x=> if x == guess.toUpper then x else Unrevealed)
    var group = this.viableSolutions.groupBy(leftGroup)
    val choseenGroup = group.maxBy(_._2.size)._1
    val left = group.maxBy(_._2.size)._2
    var newVisibleWord = this.reveal(choseenGroup)
    val actguess = if newVisibleWord == visibleWord then 1 else 0

    GameState(this.missesAllowed - actguess, this.previousGuesses + guess.toUpper, newVisibleWord, left)

  override def toString: String =
    s"$visibleWord, missed guesses allowed: $missesAllowed, guesses made: ${if previousGuesses.isEmpty then "none" else previousGuesses}, solutions left: $numberOfSolutions"

object GameState:
  val Unrevealed: Char = '_'
