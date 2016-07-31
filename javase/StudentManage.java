import java.util.*;
import java.util.Scanner;
public class StudentManage{
	public static void main(String[] args){
		HashSet set = new HashSet();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("==========学生管理系统==========");
			System.out.println("1.添加学生\n"+"2.删除学生\n"+"3.浏览学生\n"+"4.离开系统");
			int m = sc.nextInt();
			if(m == 1){
				System.out.println("请输入学生学号，姓名，性别(boy or girl):");
				set.add(new Student(sc.nextInt(),sc.next(),sc.next()));
				System.out.println("添加成功");
			}else if(m == 2){
				System.out.println("请输入学生学号:");
				int id = sc.nextInt();
				Iterator iter = set.iterator();
				while(iter.hasNext()){
					Student stu  = (Student)iter.next();
					if(stu.getId() == id){
						set.remove(stu);
						System.out.println("删除成功");
						break;	
					}else{System.out.println("找不到该学生");}
				}
			}else if(m == 3){
				Iterator iter = set.iterator();
				while(iter.hasNext()){
					System.out.println(iter.next());
				}
			}else if(m == 4) {
				System.out.println("退出系统");
				break;
			}else{
				System.out.println("不能识别的指令请重新输入");	
			}			
				
			

		}
	}

}

class Student{
	private int id;
	private String name;
	private String sex;
	public Student(int id, String name, String sex){
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id ;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name ;
	}
	public String getSex(){
		return this.sex;
	}
	public void setSex(String sex){
		this.sex = sex ;
	}
	@Override
	public int  hashCode(){
		return this.name.hashCode()*31;
	}
	@Override
	public boolean equals(Object obj){
		Student stu=(Student)obj;
		if(this.name==stu.getName()&&this.id==stu.getId()&&this.sex==stu.getSex()){
			return true;
		}else{
			System.out.println(this.name+"已存在");
			return false;
			
		}
	}
	@Override	
	public String toString(){
		return "ID:"+this.id+"   Name:"+this.name+"   sex:"+this.sex;
	}

}
