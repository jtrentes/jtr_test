package big.domain.factories;

import big.domain.MyClass87;



public class MyClass87Builder
{

	
	
	private MyClass87 myclass87;
    

	
	public MyClass87 build () 
	{
		return myclass87;	
	}

	
	public MyClass87Builder id (Long id) 
	{
		myclass87.setId (id);
		return this;	
	}

	
	public MyClass87Builder initMyClass87 () 
	{
		myclass87 = new MyClass87();
		return this;	
	}


}
