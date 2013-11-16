package sample;

public class Main {
	public static void main(String... args) throws InterruptedException {
		System.out.println("First Ever line of output");
		
		final Thread t = new Thread(new Runnable() {
			public void run() {
				while(Thread.currentThread().isInterrupted() == false) {
					System.out.println("I am alive");
				}
			}
		});
		
		t.start();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				System.out.println("Going to interrupt the rogue thread");
				t.interrupt();
			}
		});
		
		t1.start();
		
		System.out.println("Done");
		
	}
}