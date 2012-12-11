package big.services;

import big.repositories.criteria.MyClass51Criteria;
import big.repositories.MyClass51Repository;
import java.util.List;
import big.domain.MyClass51;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass51Service")
@Transactional(readOnly = true)
public class MyClass51ServiceImpl implements MyClass51Service
{

	
	@Autowired
	private MyClass51Repository myClass51Repository;
    

	
	public List<MyClass51> findAll () 
	{
		return this.myClass51Repository.findAll();	
	}

	
	public List<MyClass51> findByCriteria (MyClass51Criteria criteria) 
	{
		return this.myClass51Repository.findByCriteria (criteria);	
	}

	
	public MyClass51 findById (Long id) 
	{
		return this.myClass51Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass51 save (MyClass51 myclass51) 
	{
		return this.myClass51Repository.save (myclass51);	
	}


}
