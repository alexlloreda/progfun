package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0) 1
    else if (r == 0) 0
    else if (c == r + 1) 1
    else if (c > r) 0
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceNum(chars: List[Char], openPars: Int): Int = {
      if (openPars < 0) -1
      else if (chars.isEmpty) 0
      else balanceNum(chars.tail, countPars(chars.head, openPars))
    }

    def countPars(c: Char, openPars: Int): Int = {
      if (c == '(') openPars + 1
      else if (c == ')') openPars - 1
      else openPars
    }

    balanceNum(chars, 0) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(money: Int, coins: List[Int]): Int = {
      if (money < 0) 0
      else if (money == 0) 1
      else if (coins.isEmpty) 0
      else change(money - coins.head, coins) + change(money, coins.tail)
    }

    change(money, coins.sortWith(_.compareTo(_) < 0))
  }

}
