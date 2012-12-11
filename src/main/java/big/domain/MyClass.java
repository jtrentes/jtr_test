package big.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToOne;


@Entity
public class MyClass
{

	
	@Column(name = "ATTRIBUTECOLUMN")
	private String attribute;
	
	
	private String attribute2;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@OneToOne(optional = true)
	private MyClass2 myclass2;
    

	
	public String getAttribute () 
	{
		return this.attribute;	
	}

	
	public String getAttribute2 () 
	{
		return this.attribute2;	
	}

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass2 getMyclass2 () 
	{
		return this.myclass2;	
	}

	
	public void operation () 
	{
		// TODO : to implement
			
	}

	
	public void operation2 () 
	{
		// TODO : to implement
			
	}

	
	public void operation3 () 
	{
		// TODO : to implement
			
	}

	
	public void setAttribute (String myAttribute) 
	{
		this.attribute = myAttribute;	
	}

	
	public void setAttribute2 (String myAttribute2) 
	{
		this.attribute2 = myAttribute2;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass2 (MyClass2 myMyclass2) 
	{
		if (this.myclass2 != myMyclass2) {
			MyClass2 oldmyclass2 = this.myclass2;
			this.myclass2 = myMyclass2;
			if (oldmyclass2 != null)
				oldmyclass2.unsetMyclass ();
			if (myMyclass2 != null)
				myMyclass2.setMyclass (this);
		}	
	}

	
	public void unsetAttribute () 
	{
		this.attribute = null;	
	}

	
	public void unsetAttribute2 () 
	{
		this.attribute2 = null;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass2 () 
	{
		if (this.myclass2 == null)
			return;
		MyClass2 oldmyclass2 = this.myclass2;
		this.myclass2 = null;
		oldmyclass2.unsetMyclass ();	
	}


}
