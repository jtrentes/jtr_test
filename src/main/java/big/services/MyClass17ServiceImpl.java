package big.services;

import big.repositories.criteria.MyClass17Criteria;
import big.repositories.MyClass17Repository;
import big.domain.MyClass17;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass17Service")
@Transactional(readOnly = true)
public class MyClass17ServiceImpl implements MyClass17Service
{

	
	@Autowired
	private MyClass17Repository myClass17Repository;
    

	
	public List<MyClass17> findAll () 
	{
		return this.myClass17Repository.findAll();	
	}

	
	public List<MyClass17> findByCriteria (MyClass17Criteria criteria) 
	{
		return this.myClass17Repository.findByCriteria (criteria);	
	}

	
	public MyClass17 findById (Long id) 
	{
		return this.myClass17Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass17 save (MyClass17 myclass17) 
	{
		return this.myClass17Repository.save (myclass17);	
	}


}
