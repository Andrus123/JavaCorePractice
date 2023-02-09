package singletonPattern;

public class DemoSingleThread {

	public static void main(String[] args) {
		System.out.println("If you see the same value, then singleton was reused (yay!)"+"\n"+
					"If you see defferent values, then 2 singletons were created(boo!)"+"\n\n"+
					"RESULT:"+"\n");
		Singleton singleton = Singleton.getInstance("Foo");
		Singleton anotherSingleton = Singleton.getInstance("Bar");
		System.out.println(singleton.value);
		System.out.println(anotherSingleton.value);
	}
}
