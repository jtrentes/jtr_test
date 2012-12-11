package big.services;

import big.domain.MyClass66;
import java.util.List;
import big.repositories.criteria.MyClass66Criteria;
import big.repositories.MyClass66Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass66Service")
@Transactional(readOnly = true)
public class MyClass66ServiceImpl implements MyClass66Service
{

	
	@Autowired
	private MyClass66Repository myClass66Repository;
    

	
	public List<MyClass66> findAll () 
	{
		return this.myClass66Repository.findAll();	
	}

	
	public List<MyClass66> findByCriteria (MyClass66Criteria criteria) 
	{
		return this.myClass66Repository.findByCriteria (criteria);	
	}

	
	public MyClass66 findById (Long id) 
	{
		return this.myClass66Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass66 save (MyClass66 myclass66) 
	{
		return this.myClass66Repository.save (myclass66);	
	}


}
