package big.services;

import big.repositories.criteria.MyClass69Criteria;
import java.util.List;
import big.domain.MyClass69;
import big.repositories.MyClass69Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass69Service")
@Transactional(readOnly = true)
public class MyClass69ServiceImpl implements MyClass69Service
{

	
	@Autowired
	private MyClass69Repository myClass69Repository;
    

	
	public List<MyClass69> findAll () 
	{
		return this.myClass69Repository.findAll();	
	}

	
	public List<MyClass69> findByCriteria (MyClass69Criteria criteria) 
	{
		return this.myClass69Repository.findByCriteria (criteria);	
	}

	
	public MyClass69 findById (Long id) 
	{
		return this.myClass69Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass69 save (MyClass69 myclass69) 
	{
		return this.myClass69Repository.save (myclass69);	
	}


}
