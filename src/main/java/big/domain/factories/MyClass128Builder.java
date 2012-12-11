package big.domain.factories;

import big.domain.MyClass128;



public class MyClass128Builder
{

	
	
	private MyClass128 myclass128;
    

	
	public MyClass128 build () 
	{
		return myclass128;	
	}

	
	public MyClass128Builder id (Long id) 
	{
		myclass128.setId (id);
		return this;	
	}

	
	public MyClass128Builder initMyClass128 () 
	{
		myclass128 = new MyClass128();
		return this;	
	}


}
