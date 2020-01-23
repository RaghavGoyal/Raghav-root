object Input{
	def main(args:Array[String]){
		println("enter any number");
		val a=scala.io.StdIn.readLine();
		println("hey! did you enter "+a);

		val b="1010"

		val decimalValue = Integer.parseInt(b, 2);
		println("the decimal equivallent of "+b+" is: "+decimalValue);
	}
}
