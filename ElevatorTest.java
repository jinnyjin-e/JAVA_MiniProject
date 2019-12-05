import java.util.Scanner;

class ElevatorTest{
	public static void main(String [] args) throws Exception{
		Scanner ms = new Scanner(System.in);
		Elevator el1 = new Elevator();
		Elevator el2 = new Elevator();
			
		int perpose;
		
		while(true){
		System.out.print("몇층으로 갈까요? ");
		perpose = ms.nextInt();
		Thread.sleep(1000);
		el1.move(perpose);
		Thread.sleep(500);
		
		System.out.print("몇층으로 갈까요? ");
		perpose = ms.nextInt();
		Thread.sleep(1000);
		el2.move(perpose);
		Thread.sleep(500);
		
		}
		
	}
}

class Elevator{
	static int floor=0; //현재 층수
	static boolean door = true;
	int perpose; //가고자 하는 층수

	boolean openClose(boolean door) throws Exception{
		if(door == true){
			System.out.println("문이 닫힙니다.");
			Thread.sleep(1000);
			return this.door =false;
		}
		else{
			System.out.println("문이 열립니다.");
			Thread.sleep(1000);
			return this.door = true;	
		}
	}
	
	void move(int perpose) throws Exception{
		if(perpose>10 || perpose <-2){
			System.out.println("[유효하지 않은 층수입니다.]");
			return;
		}
		if(perpose == this.floor){
			System.out.println("[현재 위치하고 있는 층수입니다.]");
			return;
		}
		
		openClose(door);
		
		if(perpose<0) System.out.printf("지하%d층으로 이동합니다.\n",-perpose);
		else if(perpose == 0) System.out.println("로비로 이동합니다.");
		else System.out.printf("%d층으로 이동합니다.\n",perpose);
		Thread.sleep(1000);

		report(floor,perpose);
		this.floor = perpose;
		
		if(perpose<0 ) System.out.printf("지하%d층입니다. \n",-perpose);
		else if(perpose == 0) System.out.println("로비입니다.");
		else System.out.printf("%d층입니다.\n",perpose);
		Thread.sleep(1000);

		openClose(door);

	}
	
	void report(int floor, int perpose) throws Exception{
		if(floor > perpose){
			for(int i = floor ; i>=perpose ; i--){
				if(i==perpose) Thread.sleep(500);
				if(i>0) System.out.printf("%d ",i);
				else if(i==0) System.out.print("L ");
				else System.out.printf("B%d ",-i);
				Thread.sleep(1000);
				}
			}
		else {
			for(int i = floor; i<=perpose;i++){
				if(i==perpose) Thread.sleep(500);
				if(i>0) System.out.printf("%d ",i);
				else if(i==0) System.out.print("L ");
				else System.out.printf("B%d ",-i);
				Thread.sleep(1000);
				}
				
			}
		System.out.println("");
	}
	
	Elevator(){}

}