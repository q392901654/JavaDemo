import java.util.*;
class Apple{
	private String name;
	private double weight;
	private String color;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public double getWeight(){
		return this.weight;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	public String getColor(){
		return this.color;
	}
	public void setColor(String color){
		this.color=color;
	}
	public int  hashCode(){
		return this.name.hashCode()*31;
	}
	public boolean equals(Object obj){
		Apple app=(Apple)obj;
		if(this.name==app.getName()&&this.weight==app.getWeight()&&this.color==app.getColor()){
			return true;
		}else{
			return false;
		}
	}
	
}

public class  appleTest{
	public static void main(String[] args){
		HashSet set = new HashSet();
		Apple ap1 = new Apple();
		ap1.setName("大苹果") ;
		ap1.setWeight(20);
		ap1.setColor("红");
		Apple ap2 = new Apple();
		ap2.setName ("小苹果");
		ap2.setWeight(20);
		ap2.setColor("绿");
		Apple ap3 = new Apple();
		ap3.setName("大苹果");
		ap3.setWeight(20);
		ap3.setColor("红");
		set.add(ap1);
		set.add(ap2);
		set.add(ap3);
		Iterator it = set.iterator();
		while(it.hasNext()){
			Apple app =(Apple)it.next();
			System.out.println("Name:"+app.getName()+" Weight:"+app.getWeight()+" Color:"+app.getColor());
		}
	}
}

