package big.services;

import big.repositories.criteria.MyClass77Criteria;
import big.repositories.MyClass77Repository;
import big.domain.MyClass77;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass77Service")
@Transactional(readOnly = true)
public class MyClass77ServiceImpl implements MyClass77Service
{

	
	@Autowired
	private MyClass77Repository myClass77Repository;
    

	
	public List<MyClass77> findAll () 
	{
		return this.myClass77Repository.findAll();	
	}

	
	public List<MyClass77> findByCriteria (MyClass77Criteria criteria) 
	{
		return this.myClass77Repository.findByCriteria (criteria);	
	}

	
	public MyClass77 findById (Long id) 
	{
		return this.myClass77Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass77 save (MyClass77 myclass77) 
	{
		return this.myClass77Repository.save (myclass77);	
	}


}
