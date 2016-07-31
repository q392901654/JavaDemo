import java.util.*;
class Random47{
	public static void main(String[] args){
		Random rand = new Random(47);
		for(int i = 1; i < 10; i++)
		System.out.println(rand.nextInt(100));
	}
}
