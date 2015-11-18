import forcomp.Anagrams._
object Experiment {
  val a = 1+2

  def decreaseCount(p: (Char, Int)): List[Occurrences] = {
    if (p._2 == 0) List()
    else List(p)::decreaseCount(p._1,p._2-1)
  }
  decreaseCount(('a', 3))
  def combinations(occurrences: Occurrences): List[Occurrences] = {
    if (occurrences.isEmpty) List(Nil)
    else
      decreaseCount(occurrences.head):::combinations(occurrences.tail)
  }
  combinations(List(('a',2),('b',1)))
  type Oc = Occurrences
  def comb(oc: Oc): List[Oc] = {
    if (oc.isEmpty) List(List())
    else
      for {
        os <- combinations(oc.tail)
        o <- decreaseCount(oc.head)
      } yield (o:::os)
  }
  val o = comb(List(('a',2),('b',2)))
  def alex(oc: Occurrences): List[Occurrences] = {
    for {
      o <- oc
    } yield decreaseCount(o).flatten
  }
  alex(List(('a',2),('b',1)))
}