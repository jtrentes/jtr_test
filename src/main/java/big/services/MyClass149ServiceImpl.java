package big.services;

import big.repositories.MyClass149Repository;
import big.domain.MyClass149;
import big.repositories.criteria.MyClass149Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass149Service")
@Transactional(readOnly = true)
public class MyClass149ServiceImpl implements MyClass149Service
{

	
	@Autowired
	private MyClass149Repository myClass149Repository;
    

	
	public List<MyClass149> findAll () 
	{
		return this.myClass149Repository.findAll();	
	}

	
	public List<MyClass149> findByCriteria (MyClass149Criteria criteria) 
	{
		return this.myClass149Repository.findByCriteria (criteria);	
	}

	
	public MyClass149 findById (Long id) 
	{
		return this.myClass149Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass149 save (MyClass149 myclass149) 
	{
		return this.myClass149Repository.save (myclass149);	
	}


}
