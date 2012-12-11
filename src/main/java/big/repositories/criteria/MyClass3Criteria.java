package big.repositories.criteria;

import big.domain.MyClass2;



public class MyClass3Criteria
{

	
	
	private Long id;
	
	
	private MyClass2 myclass2;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass2 getMyclass2 () 
	{
		return this.myclass2;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass2 (MyClass2 myMyclass2) 
	{
		this.myclass2 = myMyclass2;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass2 () 
	{
		this.myclass2 = null;	
	}


}
