package DataStructures.Tree

import java.util
import scala.annotation.tailrec

object Tree extends App {

  // leaf children
  val child11 = Node("child3")
  val child12 = Node("child4")
  val child21 = Node("child5")

  // L1 children
  val childR1 = Node("child1", List(child11, child12))
  val childR2 = Node("child2", List(child21))

  // root
  val root = Node("root", List(childR1, childR2))

  // recursively get the number of nodes having more than 1 child:
  val numberOfNodesRec = testM1(root)

  def testM1(root: Node[String]): Int = {
    if(root.children.length > 1)
      1 + root.children.map(innerNode => testM1(innerNode)).sum
    else
      root.children.map(innerNode => testM1(innerNode)).sum
  }
  println("Recursive count is: "+ numberOfNodesRec)

  // Non-Recursively:
  import java.util
  def myCount(node: Node[String]): Int ={
    var count = 0
    if(node == null) return count
    val queue = new util.LinkedList[Node[String]]()
    queue.add(node)
    while(!queue.isEmpty){
      var queSize = queue.size()
      while(queSize > 0){
        val x = queue.peek()
        queue.remove
        if(x.children.length > 1) count = count + 1
        for(child <- x.children){
          queue.add(child)
        }
        queSize = queSize - 1
      }
    }
    count
  }
  println(myCount(root))



}
