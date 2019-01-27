package func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FuncInterfaceTutor {

	interface Func {
		void test();
	}
	
	interface Func2 {
		int exec(String a);
	}
	
	public static void testImplStatic() {
		System.out.println("I'm a static test method inside FuncInterfaceTutor");
	}
	
	public void testImpl() {
		System.out.println("I'm not static test method inside FuncInterfaceTutor");
	}
	
	public int getLength(String s) {
		return s.length();
	}
	
	public void printLength(String s, Func2 f) {
		System.out.println(f.exec(s));
	}
	
	interface Info {
		String get();
		String random();
		Info info();
	}
	
	static class MyInfo implements Info {
		@Override
		public String get() {
			return "I'm MyInfo object, created and alive!";
		}
		@Override
		public String random() {
			return "hello "+Math.random();
		}
		@Override
		public Info info() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public static String getInfo(Info info, Function<Info, String> s) {
		return "This is information from info: "+s.apply(info);
	}
	
	public static void printAll(Info[] infos, Function<Info, String> s) {
		Arrays.stream(infos).forEach(i->System.out.println(s.apply(i)));
	}
	
	public Info createInfo(Supplier<Info> s) {
		Info info = s.get();
		// do some operations on info
		System.out.println(info.get());
		
		return info;
	}
	
	public static void main(String[] args) {
		Func f = ()->{ System.out.println("Hi");};
		f.test();
		
		Func2 f2 = (a)->{ System.out.println("Hello"); return Integer.valueOf(a); };
		System.out.println(f2.exec("1"));
		
		// use static method reference
		Func f3 = FuncInterfaceTutor::testImplStatic;
		f3.test();
		
		// use non-static method reference
		FuncInterfaceTutor tutor = new FuncInterfaceTutor();
		Func f4 = tutor::testImpl;
		f4.test();
		
		// use arbitary object method reference
		tutor.printLength("Hello", (s)->s.length());
		tutor.printLength("Hi", String::length);
		
		// use constructor method reference
		tutor.createInfo(MyInfo::new);
		
		// use arbitary object method reference for info object
		System.out.println(getInfo(new MyInfo(), Info::get));
		System.out.println(getInfo(new MyInfo(), Info::random));
		Info[] infos = {new MyInfo(), new MyInfo()};
		printAll(infos, Info::random);
	}
	
}
