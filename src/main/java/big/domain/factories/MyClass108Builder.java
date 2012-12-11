package big.domain.factories;

import big.domain.MyClass108;



public class MyClass108Builder
{

	
	
	private MyClass108 myclass108;
    

	
	public MyClass108 build () 
	{
		return myclass108;	
	}

	
	public MyClass108Builder id (Long id) 
	{
		myclass108.setId (id);
		return this;	
	}

	
	public MyClass108Builder initMyClass108 () 
	{
		myclass108 = new MyClass108();
		return this;	
	}


}
