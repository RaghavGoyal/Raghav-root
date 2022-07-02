object p6{
	def main(args:Array[String]){
		val list1:List[Int]=List(1,2,3,2,1)
		val list2:List[Int]=list1.reverse
		if(list1==list2)
			println("palindrome")
		else
			println("non palindrome")
	}
}