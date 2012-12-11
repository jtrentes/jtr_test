package big.services;

import big.repositories.criteria.MyClass79Criteria;
import java.util.List;
import big.domain.MyClass79;
import big.repositories.MyClass79Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass79Service")
@Transactional(readOnly = true)
public class MyClass79ServiceImpl implements MyClass79Service
{

	
	@Autowired
	private MyClass79Repository myClass79Repository;
    

	
	public List<MyClass79> findAll () 
	{
		return this.myClass79Repository.findAll();	
	}

	
	public List<MyClass79> findByCriteria (MyClass79Criteria criteria) 
	{
		return this.myClass79Repository.findByCriteria (criteria);	
	}

	
	public MyClass79 findById (Long id) 
	{
		return this.myClass79Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass79 save (MyClass79 myclass79) 
	{
		return this.myClass79Repository.save (myclass79);	
	}


}
