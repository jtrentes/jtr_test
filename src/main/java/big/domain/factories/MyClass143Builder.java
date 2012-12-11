package big.domain.factories;

import big.domain.MyClass143;



public class MyClass143Builder
{

	
	
	private MyClass143 myclass143;
    

	
	public MyClass143 build () 
	{
		return myclass143;	
	}

	
	public MyClass143Builder id (Long id) 
	{
		myclass143.setId (id);
		return this;	
	}

	
	public MyClass143Builder initMyClass143 () 
	{
		myclass143 = new MyClass143();
		return this;	
	}


}
