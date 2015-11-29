
val list = List(1,2,3,4,5)

list map ( _ + 2)

val x = List((1,'a'),(12,'e'),(3,'d'),(2,'v'))

x map ( _._1)

val more: Stream[(Int, List[Char])] = List((1,List('a')), (2,List('v')), (3,List('c'))).toStream
val sl: List[Int] = more.map(_._1).toList

