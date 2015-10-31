package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times can count frequencies") {
    //println(times(string2Chars("hello world")))
    //assert(string2Chars(""))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("CreateCodeTree can build simple trees") {
    val chars = List('b', 'a')
    assert(createCodeTree(chars) === Fork(Leaf('a', 1), Leaf('b', 1), List('a', 'b'), 2))
  }

  test("CreateCodeTree can build complex trees") {
    val chars = List('a', 'b', 'c')
    assert(createCodeTree(chars) === Fork(Fork(Leaf('c', 1), Leaf('b', 1), List('c', 'b'), 2), Leaf('a', 1), List('c', 'b', 'a'), 3))
  }

  test("DecodeSecret") {
    println(decodedSecret)
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("decode and encode a short text should be identity") {
    new TestTrees {
      assert(decode(t2, encode(t2)("abddbaaabbdd".toList)) === "abddbaaabbdd".toList)
    }
  }

  test("Convert is very strange") {
    new TestTrees {
      println(convert(t2))
      println(convert(frenchCode))
    }
  }

  test("Quick encode and decode a short text shoudl be identity") {
    new TestTrees {
      assert(decode(t2, quickEncode(t2)("abddbaaabbdd".toList)) === "abddbaaabbdd".toList)
    }
  }
}
