package big.domain.factories;

import big.domain.MyClass20;



public class MyClass20Builder
{

	
	
	private MyClass20 myclass20;
    

	
	public MyClass20 build () 
	{
		return myclass20;	
	}

	
	public MyClass20Builder id (Long id) 
	{
		myclass20.setId (id);
		return this;	
	}

	
	public MyClass20Builder initMyClass20 () 
	{
		myclass20 = new MyClass20();
		return this;	
	}


}
