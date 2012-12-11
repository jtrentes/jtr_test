package big.services;

import big.repositories.criteria.MyClass28Criteria;
import big.repositories.MyClass28Repository;
import big.domain.MyClass28;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass28Service")
@Transactional(readOnly = true)
public class MyClass28ServiceImpl implements MyClass28Service
{

	
	@Autowired
	private MyClass28Repository myClass28Repository;
    

	
	public List<MyClass28> findAll () 
	{
		return this.myClass28Repository.findAll();	
	}

	
	public List<MyClass28> findByCriteria (MyClass28Criteria criteria) 
	{
		return this.myClass28Repository.findByCriteria (criteria);	
	}

	
	public MyClass28 findById (Long id) 
	{
		return this.myClass28Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass28 save (MyClass28 myclass28) 
	{
		return this.myClass28Repository.save (myclass28);	
	}


}
