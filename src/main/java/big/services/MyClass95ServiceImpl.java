package big.services;

import big.repositories.MyClass95Repository;
import big.domain.MyClass95;
import java.util.List;
import big.repositories.criteria.MyClass95Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass95Service")
@Transactional(readOnly = true)
public class MyClass95ServiceImpl implements MyClass95Service
{

	
	@Autowired
	private MyClass95Repository myClass95Repository;
    

	
	public List<MyClass95> findAll () 
	{
		return this.myClass95Repository.findAll();	
	}

	
	public List<MyClass95> findByCriteria (MyClass95Criteria criteria) 
	{
		return this.myClass95Repository.findByCriteria (criteria);	
	}

	
	public MyClass95 findById (Long id) 
	{
		return this.myClass95Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass95 save (MyClass95 myclass95) 
	{
		return this.myClass95Repository.save (myclass95);	
	}


}
