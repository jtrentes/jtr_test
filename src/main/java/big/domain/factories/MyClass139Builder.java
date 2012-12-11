package big.domain.factories;

import big.domain.MyClass139;



public class MyClass139Builder
{

	
	
	private MyClass139 myclass139;
    

	
	public MyClass139 build () 
	{
		return myclass139;	
	}

	
	public MyClass139Builder id (Long id) 
	{
		myclass139.setId (id);
		return this;	
	}

	
	public MyClass139Builder initMyClass139 () 
	{
		myclass139 = new MyClass139();
		return this;	
	}


}
