public class Main
{
	public static void main(String args[])
	{
		LinkedLizt<String> lizt = new LinkedLizt<String>();
		lizt.add("Hello");
		lizt.add("My");
		lizt.add("Name");
		lizt.add("Is");
		lizt.add(null);
		lizt.add("Bob.");
		
		System.out.println(
			"Printing out 0, 1, 2, 4: "
			+ "\n"
			+ lizt.get(0)
			+ " "
			+ lizt.get(1)
			+ " "
			+ lizt.get(2)
			+ " "
			+ lizt.get(4)
		);
		
		System.out.println("Printing out list wholesale: " + lizt);
		System.out.println("List length: " + lizt.length());
		
		lizt.clear();
		System.out.println(lizt);
		
		return;
	}
}
