/**
*购物系统
*功能：展示商品，添加购物车（add），购物车操作（删除商品，修改商品数量，），提交订单，取消操作退出系统。
*
*/

import java.util.*;
public class Shopping{
	
	public static Scanner sc = new Scanner(System.in);
	//存放book的集合
	private static ArrayList<Book> list = new ArrayList();
	//定义购物车
	private static HashMap<Book,Integer> map = new HashMap();
	//初始化书籍信息
	static{
		list.add(new Book(1,"疯狂Java讲义",50,"李刚","电子工业出版社",100,0));
		list.add(new Book(2,"疯狂Ios讲义",80,"李刚","电子工业出版社",10,0));
		list.add(new Book(3,"疯狂XML讲义",90,"李刚","电子工业出版社",20,0));
		list.add(new Book(4,"疯狂Android讲义",100,"李刚","电子工业出版社",50,0));
	}
	public static void main(String[] args){
		showMenu();
		select();
	}
	//欢迎菜单
	public static void showMenu(){
		System.out.println("====================================购物系统=======================================");
		System.out.println("编号\t"+"书名\t\t\t"+"价格\t"+"作者\t"+"出版社\t\t\t"+"库存");
		for(Book book : list){
			System.out.println(book.getId()+"\t"+book.getName()+"\t\t"+book.getPrice()+"\t"+book.getAuthor()+"\t"+book.getPublishing()+"\t\t"+book.getStock());
		}
		System.out.println("======================================V1.0=========================================");
	}
	//操作提示
	public static void select(){
		System.out.println("功能选项:购物(gw),进入购物车(gwc),提交订单(tj),退出系统(exit)");
		String se = sc.next();
		switch(se){
			//购物功能
			case "gw":
				gw();
				break;
			//进入购物车
			case "gwc":
				gwc();
				break;
			//提交订单
			case "tj":
				tj();
				break;
			//退出系统
			case "exit":
				System.exit(0);
			default:
				System.out.println("未能识别的指令请重新输入");
				select();
		}		
	}
	//购物车
	public static void gwc(){
		showGwc();
		
	
	}
	//展示购物车
	public static void showGwc(){
		System.out.println("====================================购物车=======================================");
			System.out.println("编号\t"+"书名\t\t\t"+"价格\t"+"作者\t"+"出版社\t\t\t"+"购买数量");
		for(Book book : map.keySet()){	
			System.out.println(book.getId()+"\t"+book.getName()+"\t\t"+book.getPrice()+"\t"+book.getAuthor()+"\t"+book.getPublishing()+"\t\t"+map.get(book));
		}

		System.out.println("=================================================================================");
		gwcMenu();
	}
	//购物车菜单
	public static void gwcMenu(){
		System.out.println("功能选项：删除商品(del),修改所购商品数量(updata),退出购物车(out)");
		
		switch(sc.next()){
			case "del":del();break;
			case "updata":updata();
				break;
			case "out":select();break;
			default :System.out.println("未能识别的指令请重新输入"); 
		}
	}
	//删除商品
	public static void del(){
		System.out.println("请输入要删除的商品的编号");
		int delid = sc.nextInt();
		for(Book book : map.keySet()){
			if(book.getId() ==delid){
				System.out.println("成功移除"+book.getName());
				map.remove(book);
				showGwc();return;
			}
		}
		System.out.println("购物车无此商品");
		gwcMenu();	

	}
	//修改所购商品数量
	public static void updata(){
		System.out.println("请输入需要修改的商品的编号");
		int up = sc.nextInt();
		for(Book book : map.keySet()){
			if(book.getId() == up){
				System.out.println("请输入需要修改的数量");
				int sl = sc.nextInt();
				if(sl <= book.getTempbuy()){
					System.out.println("修改成功");
					showGwc();return;
				}else{
					System.out.println("库存不足修改失败");
					gwcMenu();
					return;
				}
			}
		}
		System.out.println("购物车无此商品");
		gwcMenu();
	}
	//提交订单
	public static void tj(){
		for(Book book : map.keySet()){
			book.setStock(book.getStock()-book.getTempbuy());
			
		}
		System.out.println("已成功提交订单");
		showMenu();
		select();
	}
	//购物功能(gw)
	public static void gw(){
		System.out.println("请输入需要添加到购物车的书本编号:(输入-1退出购物)");
		int bookid = sc.nextInt();
		//判断是否退出
		if(bookid == -1)select();
		//寻找是否存在此书
		for(Book book : list){
			if(book.getId() == bookid){
				System.out.println("请输入需要购买的数量");
				int quantity = sc.nextInt();
				//判断书本已添加数量和现添加数量总和是否大于库存
				if(quantity+book.getTempbuy() <= book.getStock()){
					book.setTempbuy(quantity+book.getTempbuy());
					map.put(book,book.getTempbuy());
					System.out.println(book.getName()+"已添加"+book.getTempbuy()+"本进购物车^_^");
					select();return;
				}else{
					System.out.println("库存不足,返回菜单");
					select();
					return;
				}

			}
		}
		
		System.out.println("此书不存在,请重新输入");
		gw();	
		
			
		


		
	}
}
//定义书本类
class Book{
	private int id;
	private String name;
	private double price;
	private String author;
	private String publishing;
	private int stock;
	private int tempbuy;
	public int getTempbuy(){
		return tempbuy;
	}
	public void setTempbuy(int tempbuy){
		this.tempbuy = tempbuy;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", publishing="
				+ publishing + ", stock=" + stock + "]";
	}
	public Book(int id, String name, double price, String author, String publishing, int stock, int tempbuy) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.publishing = publishing;
		this.stock = stock;
		this.tempbuy = tempbuy;
		}
	
}	
