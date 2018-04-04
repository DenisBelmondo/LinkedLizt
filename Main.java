public class Main
{
	public static void main(String args[])
	{
		LinkedLizt<String> lizt = new LinkedLizt<String>();
		lizt.add("Hello");
		lizt.add("My");
		lizt.add("Name");
		lizt.add("Is");
		lizt.add("Bob.");
		
		System.out.println(
			lizt.get(0)
			+ " "
			+ lizt.get(1)
			+ " "
			+ lizt.get(2)
			+ " "
			+ lizt.get(3)
			+ " "
			+ lizt.get(4)
		);
		
		System.out.println(lizt.length());
		
		return;
	}
}
