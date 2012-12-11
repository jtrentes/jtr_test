package big.services;

import java.util.List;
import big.repositories.MyClass70Repository;
import big.repositories.criteria.MyClass70Criteria;
import big.domain.MyClass70;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass70Service")
@Transactional(readOnly = true)
public class MyClass70ServiceImpl implements MyClass70Service
{

	
	@Autowired
	private MyClass70Repository myClass70Repository;
    

	
	public List<MyClass70> findAll () 
	{
		return this.myClass70Repository.findAll();	
	}

	
	public List<MyClass70> findByCriteria (MyClass70Criteria criteria) 
	{
		return this.myClass70Repository.findByCriteria (criteria);	
	}

	
	public MyClass70 findById (Long id) 
	{
		return this.myClass70Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass70 save (MyClass70 myclass70) 
	{
		return this.myClass70Repository.save (myclass70);	
	}


}
