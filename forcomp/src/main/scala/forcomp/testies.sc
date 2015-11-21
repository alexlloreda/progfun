import forcomp.Anagrams._
object Experiment {
  def alexAnagrams(sentence: Sentence): List[Sentence] = {
    val so = sentenceOccurrences(sentence)
    def finishSentence(ocs: Occurrences): List[Sentence] = {
      /*
      //println("Build sentences for " + ocs)
      if (ocs.isEmpty) List(Nil)
      else {
        combinations(ocs).withFilter(w => dictionaryByOccurrences.contains(w)).flatMap(cs =>
          dictionaryByOccurrences(cs).flatMap(w => {
            //println(w)
            finishSentence(subtract(ocs, cs)).map(sentence => {
              println("Sentence: " + w + " " + sentence)
              w :: sentence
            })
          }
          )
        )
      }
*/
      if (ocs.isEmpty) {
        println("Empty occurrences")
        List(Nil)
      }
      else {
        combinations(ocs).withFilter(w => dictionaryByOccurrences.contains(w)).flatMap(cs =>
          dictionaryByOccurrences(cs).flatMap(w => {
            //println(w)
            finishSentence(subtract(ocs, cs)).map(sentence => {
              if (sentence.isEmpty) println("Received empty sentence")
              else println("Sentence: " + w + " " + sentence)
              w :: sentence
            })
          }
          )
        )
      }
    }

    finishSentence(so)
  }
  //val sentence = List("Hello", "world")
  //val a = alexAnagrams(sentence)
  dictionary.contains("hello")
  dictionary.contains("world")

  wordAnagrams("Hello")
  wordAnagrams("cloud")
  val combos = combinations(wordOccurrences("Hello"))
  val safeDic = dictionaryByOccurrences withDefaultValue Nil
  def allAnagrams(ocs: List[Occurrences]): List[Word] = {
    if (ocs.isEmpty) Nil
    else safeDic(ocs.head) ::: allAnagrams(ocs.tail)
  }

  val all = allAnagrams(combos)
}

