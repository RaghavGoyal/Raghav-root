object p3{
	def main(args:Array[String]){
		val list=List(1,2,3,4,5,6,7,8,9,10)
		println("enter the index you want to print: ")
		var index:Int=scala.io.StdIn.readInt()
		 println(list(index))
	}

}