import forcomp.Anagrams._
object Experiment {
  val a = 1+2
  val d = List("abba", "baab", "bbaa", "aabb")
  wordOccurrences("test")
  val list = for (w <- d) yield (wordOccurrences(w), w)
  //val d2 = list.groupBy(p: (Occurrences, Word) => p._2)
  //val something = list.groupBy(_._1)
  val m = d.groupBy(wordOccurrences)
}