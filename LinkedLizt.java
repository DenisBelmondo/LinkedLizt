import java.io.Serializable;

/*
	This is going to get messy.
*/

public class LinkedLizt<T> implements Serializable
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
		FUNCTIONS
		
		NOTE: i'm aware that there's a lot of boilerplate code here.
			  i would love to refactor this at some point but i simply
			  don't have time
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
	
	public T getFirst()
	{
		return this.head.getData();
	}
	
	public T getLast()
	{
		return get(length() - 1);
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
	
	public void addFirst(T data)
	{
		add(0, data);
		return;
	}
	
	public void addLast(T data)
	{
		add(length(), data);
		return;
	}
	
	public void set(int index, T data)
	{
		if (this.head == null)
		{
			add(data);
		}
		else
		{
			Knode<T> curNode = this.head;
			
			for(int i = 0; i < index; ++i) {
				curNode = curNode.getNext();
			}
			
			curNode.setData(data);
		}
		
		return;
	}
	
	public void remove(int index)
	{
		if (index < 0 || index > length()) {
			throw new IndexOutOfBoundsException();
		}
		
		if (this.head == null)
		{
			// this will happen regardless but i'm adding the clause so
			// that i may add something to it later if i please
			
			throw new NullPointerException();
		}
		else
		{
			if (index == 0)
			{
				Knode<T> curNode = this.head.getNext();
				
			}
			else
			{
				Knode<T> curNode = this.head;
				
				for(int i = 0; i < index; ++i) {
					curNode = i == 0 ? curNode : curNode.getNext();
				}
					
				Knode<T> nextNode = curNode.getNext();
				
				curNode.setNext(nextNode.getNext());
				
				nextNode.setData(null);
				nextNode.setNext(null);
			}
		}
		
		return;
	}
	
	public void removeLast()
	{
		remove(length() - 1);
		
		return;
	}
	
	public boolean contains(T data)
	{
		Knode<T> curNode = this.head;
		
		for(int i = 0; i < length(); ++i)
		{	
			if ( data.equals(curNode.getData()) )
				return true;
			else
				curNode = curNode.getNext();
		}
		
		return false;
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
	
	@Override
	public String toString()
	{
		String str = "[";
		
		for(int i = 0; i < length(); ++i) {
			str += get(i).toString() + (i == length() - 1 ? "]" : "-> ");
		}
		
		return str;
	}
}
