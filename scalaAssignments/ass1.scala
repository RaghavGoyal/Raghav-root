object ass{
	val count=0;
	
	def main(args:Array[String]){

		println("enter any number:")
		var number=scala.io.StdIn.readInt()

		val countResult=calculateSteps(number,count);
		println(countResult)

	}

	def calculateSteps(number:Int,count:Int):Int={
		if(number!=0){
			if(number%2==0){
				calculateSteps(number/2, count+1)
			}
			else
			{
				calculateSteps(number-1,count+1)
			}
		}
		else
			count
	}
}