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
		
		public Knode<T> getNext()
		{
			return this.next;
		}
		
		public void setNext(Knode<T> next)
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
		
		if (this.head != null)
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
	
	/*
		FUNCTIONS!!!
	*/
	
	public T get(int index)
	{
		if (index < 0 || index >= length()) {
			throw new IndexOutOfBoundsException();
		}
		
		Knode<T> curNode = head;
		
		for (int i = 0; i < index; ++i) {
			curNode = curNode.getNext();
		}
		
		return curNode.getData();
	}
	
	public void add(T data)
	{
		if (this.head == null)
		{
			this.head = new Knode<T>(data);
		}
		else
		{
			Knode<T> curNode = head;
			
			while (curNode.getNext() != null) {
				curNode = curNode.getNext();
			}
			
			curNode.setNext(new Knode<T>(data));
		}
		
		return;
	}
	
	public void add(int index, T data)
	{
		if (index < 0 || index > length()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (this.head == null)
		{
			add(data);
		}
		else
		{
			Knode<T> curNode = this.head;
			
			if (index == 0)
			{
				Knode<T> newNode = new Knode<T>(data);
				newNode.setNext(curNode);
				
				this.head = newNode;
			}
			else
			{
				for(int i = 0; i < index; ++i) {
					curNode = i == 0 ? curNode : curNode.getNext();
				}

				Knode<T> newNode = new Knode<T>(data);
				newNode.setNext(curNode.getNext());
				curNode.setNext(newNode);
			}
		}
		
		return;
	}
	
	// lol
	public void addLast(T data)
	{
		add(length(), data);
		return;
	}
	
	public void clear()
	{
		Knode<T> curNode = this.head;
		
		for(int i = length(); i >= 0; --i)
		{
			for(int j = 0; j <= i; ++j)
			{
				try {
					curNode.setData(null);
					
					Knode<T> nextNode = curNode.getNext();
					
					curNode.setNext(null);
					curNode = nextNode;
				} catch (NullPointerException e){}
			}
		}
		
		return;
	}
	
	public String toString()
	{
		String str = "[";
		
		for(int i = 0; i < length(); ++i) {
			str += get(i) + (i == length() - 1 ? "]" : "-> ");
		}
		
		return str;
	}
}
