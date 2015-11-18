import forcomp.Anagrams._
object Experiment {
  type Oc = Occurrences
  def combinations(occurrences: Occurrences): List[Occurrences] = {
    if (occurrences.isEmpty) List(Nil)
    else
      decreaseCount(occurrences.head):::combinations(occurrences.tail)
  }
  def decreaseCount(p: (Char, Int)): List[Oc] = {
    if (p._2 == 0) List(Nil)
    else List(p)::decreaseCount(p._1,p._2-1)
  }
  val b = decreaseCount(('a', 3))

  //val a = combinations(List(('a',2),('b',1)))
  def comb(oc: Oc): List[Oc] = {
    if (oc.isEmpty) List(Nil)
    else
      for {
        os <- comb(oc.tail)
        o <- decreaseCount(oc.head)
      } yield (o:::os)
  }
  val o = comb(List(('a',2),('b',1)))
/*
  def alex(oc: Oc): List[Oc] = {
    if (oc.isEmpty) List()
    else {
      decreaseCount(oc.head).flatMap(combinations(oc.tail))
    }
  }

  */
}