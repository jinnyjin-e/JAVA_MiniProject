import java.util.Scanner;

class ElevatorTest{
	public static void main(String [] args) throws Exception{
		Scanner ms = new Scanner(System.in);
		Elevator el1 = new Elevator();
		Elevator el2 = new Elevator();
			
		int perpose;
		
		while(true){
		System.out.print("�������� �����? ");
		perpose = ms.nextInt();
		Thread.sleep(1000);
		el1.move(perpose);
		Thread.sleep(500);
		
		System.out.print("�������� �����? ");
		perpose = ms.nextInt();
		Thread.sleep(1000);
		el2.move(perpose);
		Thread.sleep(500);
		
		}
		
	}
}

class Elevator{
	static int floor=0; //���� ����
	static boolean door = true;
	int perpose; //������ �ϴ� ����

	boolean openClose(boolean door) throws Exception{
		if(door == true){
			System.out.println("���� �����ϴ�.");
			Thread.sleep(1000);
			return this.door =false;
		}
		else{
			System.out.println("���� �����ϴ�.");
			Thread.sleep(1000);
			return this.door = true;	
		}
	}
	
	void move(int perpose) throws Exception{
		if(perpose>10 || perpose <-2){
			System.out.println("[��ȿ���� ���� �����Դϴ�.]");
			return;
		}
		if(perpose == this.floor){
			System.out.println("[���� ��ġ�ϰ� �ִ� �����Դϴ�.]");
			return;
		}
		
		openClose(door);
		
		if(perpose<0) System.out.printf("����%d������ �̵��մϴ�.\n",-perpose);
		else if(perpose == 0) System.out.println("�κ�� �̵��մϴ�.");
		else System.out.printf("%d������ �̵��մϴ�.\n",perpose);
		Thread.sleep(1000);

		report(floor,perpose);
		this.floor = perpose;
		
		if(perpose<0 ) System.out.printf("����%d���Դϴ�. \n",-perpose);
		else if(perpose == 0) System.out.println("�κ��Դϴ�.");
		else System.out.printf("%d���Դϴ�.\n",perpose);
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