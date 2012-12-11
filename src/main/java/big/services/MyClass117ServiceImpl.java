package big.services;

import big.repositories.criteria.MyClass117Criteria;
import java.util.List;
import big.repositories.MyClass117Repository;
import big.domain.MyClass117;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass117Service")
@Transactional(readOnly = true)
public class MyClass117ServiceImpl implements MyClass117Service
{

	
	@Autowired
	private MyClass117Repository myClass117Repository;
    

	
	public List<MyClass117> findAll () 
	{
		return this.myClass117Repository.findAll();	
	}

	
	public List<MyClass117> findByCriteria (MyClass117Criteria criteria) 
	{
		return this.myClass117Repository.findByCriteria (criteria);	
	}

	
	public MyClass117 findById (Long id) 
	{
		return this.myClass117Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass117 save (MyClass117 myclass117) 
	{
		return this.myClass117Repository.save (myclass117);	
	}


}
