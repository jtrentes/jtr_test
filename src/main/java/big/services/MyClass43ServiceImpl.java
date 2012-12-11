package big.services;

import big.domain.MyClass43;
import big.repositories.criteria.MyClass43Criteria;
import java.util.List;
import big.repositories.MyClass43Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass43Service")
@Transactional(readOnly = true)
public class MyClass43ServiceImpl implements MyClass43Service
{

	
	@Autowired
	private MyClass43Repository myClass43Repository;
    

	
	public List<MyClass43> findAll () 
	{
		return this.myClass43Repository.findAll();	
	}

	
	public List<MyClass43> findByCriteria (MyClass43Criteria criteria) 
	{
		return this.myClass43Repository.findByCriteria (criteria);	
	}

	
	public MyClass43 findById (Long id) 
	{
		return this.myClass43Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass43 save (MyClass43 myclass43) 
	{
		return this.myClass43Repository.save (myclass43);	
	}


}
