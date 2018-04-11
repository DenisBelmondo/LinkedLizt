public class Main
{
	public static void main(String args[])
	{
		LinkedLizt<String> lizt = new LinkedLizt<String>();
		
		lizt.add("Hello");
		lizt.add("name");
		lizt.add(1, "my");
		lizt.addLast("Jorge.");
		lizt.add(3, "is");
		lizt.add(lizt.length(), "Goodbye.");
		
		System.out.println("Printing out list wholesale: " + lizt);
		System.out.println("List length: " + lizt.length());
		
		System.out.println("Printing out the list one-by-one: ");
		for(int i = 0; i < lizt.length(); ++i)
		{
			System.out.print(lizt.get(i)
								+ (i < lizt.length() - 1 ? ", " : "") );
		} System.out.printf("\n");
		
		lizt.clear();
		System.out.println("After clearing: " + lizt);
		
		return;
	}
}
