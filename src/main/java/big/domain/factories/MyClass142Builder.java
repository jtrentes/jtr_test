package big.domain.factories;

import big.domain.MyClass142;



public class MyClass142Builder
{

	
	
	private MyClass142 myclass142;
    

	
	public MyClass142 build () 
	{
		return myclass142;	
	}

	
	public MyClass142Builder id (Long id) 
	{
		myclass142.setId (id);
		return this;	
	}

	
	public MyClass142Builder initMyClass142 () 
	{
		myclass142 = new MyClass142();
		return this;	
	}


}
