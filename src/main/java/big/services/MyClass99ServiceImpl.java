package big.services;

import big.repositories.criteria.MyClass99Criteria;
import big.domain.MyClass99;
import java.util.List;
import big.repositories.MyClass99Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass99Service")
@Transactional(readOnly = true)
public class MyClass99ServiceImpl implements MyClass99Service
{

	
	@Autowired
	private MyClass99Repository myClass99Repository;
    

	
	public List<MyClass99> findAll () 
	{
		return this.myClass99Repository.findAll();	
	}

	
	public List<MyClass99> findByCriteria (MyClass99Criteria criteria) 
	{
		return this.myClass99Repository.findByCriteria (criteria);	
	}

	
	public MyClass99 findById (Long id) 
	{
		return this.myClass99Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass99 save (MyClass99 myclass99) 
	{
		return this.myClass99Repository.save (myclass99);	
	}


}
