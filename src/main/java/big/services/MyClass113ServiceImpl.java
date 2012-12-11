package big.services;

import big.domain.MyClass113;
import java.util.List;
import big.repositories.criteria.MyClass113Criteria;
import big.repositories.MyClass113Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass113Service")
@Transactional(readOnly = true)
public class MyClass113ServiceImpl implements MyClass113Service
{

	
	@Autowired
	private MyClass113Repository myClass113Repository;
    

	
	public List<MyClass113> findAll () 
	{
		return this.myClass113Repository.findAll();	
	}

	
	public List<MyClass113> findByCriteria (MyClass113Criteria criteria) 
	{
		return this.myClass113Repository.findByCriteria (criteria);	
	}

	
	public MyClass113 findById (Long id) 
	{
		return this.myClass113Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass113 save (MyClass113 myclass113) 
	{
		return this.myClass113Repository.save (myclass113);	
	}


}
