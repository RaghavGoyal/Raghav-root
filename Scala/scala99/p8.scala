import scala.collection.mutable._
object p8{
	def main(args:Array[String]){
		val result=List()
		val list= List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
		if(!list.tail.head==list.head){
			result.add(list.head)
		}

		println(result)


}
}