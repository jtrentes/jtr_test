package big.services;

import big.domain.MyClass73;
import big.repositories.MyClass73Repository;
import java.util.List;
import big.repositories.criteria.MyClass73Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass73Service")
@Transactional(readOnly = true)
public class MyClass73ServiceImpl implements MyClass73Service
{

	
	@Autowired
	private MyClass73Repository myClass73Repository;
    

	
	public List<MyClass73> findAll () 
	{
		return this.myClass73Repository.findAll();	
	}

	
	public List<MyClass73> findByCriteria (MyClass73Criteria criteria) 
	{
		return this.myClass73Repository.findByCriteria (criteria);	
	}

	
	public MyClass73 findById (Long id) 
	{
		return this.myClass73Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass73 save (MyClass73 myclass73) 
	{
		return this.myClass73Repository.save (myclass73);	
	}


}
