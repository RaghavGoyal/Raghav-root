object ass1{
	
	def main(Args:Array[String]){
		println("please select the option you want to perform: ");
		println("1 for Addition");
		println("2 for Subtraction");
		println("3 for Multiplication");
		println("4 for Division");

		val choice = scala.io.StdIn.readInt();

		println("enter first operand: ");
		val num1 = scala.io.StdIn.readInt();
		println("enter second operand: ");
		val num2 = scala.io.StdIn.readInt()

		choice match{
			case 1=> add(num1,num2);
			case 2=> sub(num1,num2);
			case 3=> mul(num1, num2);
			case 4=> div(num1,num2);
			case _=> println("wrong operation");

		}
	}

	def add(num1:Int, num2:Int){
		println("the addition is: "+(num1+num2))
	}

	def sub(num1:Int, num2:Int){
		println("the subtraction is: "+(num1-num2))
	}

	def mul(num1:Int, num2:Int){
		println("the multiplication is: "+(num1*num2))
	}

	def div(num1:Int, num2:Int){
		require(num2!=0, "can not divide by zero!")
		println("the division is: "+(num1/num2))
	}
}