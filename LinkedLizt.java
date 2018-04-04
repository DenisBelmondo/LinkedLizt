public class LinkedLizt<T>
{
	/*
		NODE SUBCLASS START
	*/
	
	private class Knode<T>
	{
		T data;
		Knode<T> next;
		
		public Knode()
		{
			this.data = null;
			this.next = null;
		}
	
		public Knode(T data)
		{
			this.data = data;
			this.next = null;
		}
		
		public Knode getNext()
		{
			return this.next;
		}
		
		public void setNext(Knode next)
		{
			this.next = next;
			return;
		}
		
		public T getData()
		{
			return this.data;
		}
		
		public void setData(T data)
		{
			this.data = data;
			return;
		}
		
	}
	
	/*
		NODE SUBCLASS END
	*/
	
	private Knode<T> head;
	
	public LinkedLizt()
	{
		this.head = null;
	}
	
	public LinkedLizt(T data)
	{
		this.head = new Knode<T>(data);
	}
	
	public int length()
	{
		Knode<T> curNode = head;
		
		if (head != null)
		{
			int i = 1;
			while (curNode.getNext() != null) {
				curNode = curNode.getNext();
				++i;
			}
			
			return i;
		}
		
		return 0;
	}
	
	public T get(int index)
	{
		try
		{
			Knode<T> curNode = head;
			
			for (int i = 0; i < index; ++i) {
				curNode = curNode.getNext();
			}
			
			return curNode.getData();
		}
		catch(NullPointerException e)
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void add(T data)
	{
		Knode<T> curNode = head;
		
		if (head == null)
		{
			head = new Knode<T>(data);
			// System.out.println("Adding head node " + data);
		}
		else
		{
			// System.out.println("Adding subsequent node " + data);
			
			while (curNode.getNext() != null) {
				curNode = curNode.getNext();
			}
			
			curNode.setNext(new Knode<T>(data));
		}
		
		return;
	}
}
