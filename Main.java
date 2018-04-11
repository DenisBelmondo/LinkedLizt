public class Main
{
	public static void main(String args[])
	{
		LinkedLizt<String> lizt = new LinkedLizt<String>();
		lizt.add("Hello");
		lizt.add(null);
		lizt.add("My");
		lizt.add("Name");
		lizt.add("Is");
		lizt.add("Bob.");
		lizt.add(1, "Idiot");
		
		System.out.println("Printing out list wholesale: " + lizt);
		System.out.println("List length: " + lizt.length());
		
		lizt.clear();
		System.out.println("After clearing: " + lizt);
		
		return;
	}
}
