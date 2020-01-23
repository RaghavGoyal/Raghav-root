trait Furniture

case class chair(name:String, material:String) extends Furniture
case class table (name:String, material:String, topShape:String) extends Furniture
case class sofa(name:String, capacity:Int) extends Furniture

object pmAss{
	def main(args:Array[String]){

		matchFurniture(chair("Rocking","Wooden"));
		matchFurniture(table("Center Table","Glass", "Round"));
		matchFurniture(sofa("Recliner",2));
	}

	def matchFurniture(f:Furniture)=f match{
		case chair(name,material)=>
			println("furniture is: "+name+" and it is made of: "+material)

		case table(name,material,topShape)=>
			println("the furniture is: "+name)
			println("it is made of: "+material)
			println("top shape is: "+topShape)

		case sofa(name,capacity)=>
			println("the furniture is: "+name)
			println("It has capacity of: "+capacity)
	}
}