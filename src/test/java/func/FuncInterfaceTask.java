package func;

import static org.junit.Assert.assertEquals;

/**
 * Implement interface Summator and Printer by using:
 * - lambda expression
 * - static method reference
 * - non-static method reference
 */
public class FuncInterfaceTask {

	interface Summator {
		int getSum(int a, int b);
	}
	
	interface Printer {
		void printSum(int a);
	}
	
	interface Info {
		String get();
	}
	
	static class MyInfo implements Info {
		String name;
		public MyInfo() {
		}
		public MyInfo(String name) {
			this.name = name;
		}
		public String get() {
			return "Hello, I'm MyInfo.get()";
		}
		public String info() {
			return "Hello, I'm MyInfo.info()";
		}
	}
	
	public static void main(String[] args) {
		Summator f = null; 
		assertEquals(f.getSum(1,2), 3);
		
		Printer p = null;
		p.printSum(f.getSum(5, 5));
		
		// Use MyInfo to create an instance of Info
		//Info info = makeInfo(MyInfo::new);
		
		// Create a method printAll() which will iterate over all infos 
		// and print its contents using either get() or info() method of MyInfo 
		Info[] infos = {new MyInfo("first"), new MyInfo("second")};
		//printAll(infos, MyInfo::get);
		//printAll(infos, MyInfo::info);
	}
	
}
