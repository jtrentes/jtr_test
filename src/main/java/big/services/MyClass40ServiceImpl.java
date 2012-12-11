package big.services;

import java.util.List;
import big.repositories.MyClass40Repository;
import big.repositories.criteria.MyClass40Criteria;
import big.domain.MyClass40;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass40Service")
@Transactional(readOnly = true)
public class MyClass40ServiceImpl implements MyClass40Service
{

	
	@Autowired
	private MyClass40Repository myClass40Repository;
    

	
	public List<MyClass40> findAll () 
	{
		return this.myClass40Repository.findAll();	
	}

	
	public List<MyClass40> findByCriteria (MyClass40Criteria criteria) 
	{
		return this.myClass40Repository.findByCriteria (criteria);	
	}

	
	public MyClass40 findById (Long id) 
	{
		return this.myClass40Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass40 save (MyClass40 myclass40) 
	{
		return this.myClass40Repository.save (myclass40);	
	}


}
