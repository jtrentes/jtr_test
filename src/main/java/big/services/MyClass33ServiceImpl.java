package big.services;

import big.repositories.MyClass33Repository;
import java.util.List;
import big.domain.MyClass33;
import big.repositories.criteria.MyClass33Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass33Service")
@Transactional(readOnly = true)
public class MyClass33ServiceImpl implements MyClass33Service
{

	
	@Autowired
	private MyClass33Repository myClass33Repository;
    

	
	public List<MyClass33> findAll () 
	{
		return this.myClass33Repository.findAll();	
	}

	
	public List<MyClass33> findByCriteria (MyClass33Criteria criteria) 
	{
		return this.myClass33Repository.findByCriteria (criteria);	
	}

	
	public MyClass33 findById (Long id) 
	{
		return this.myClass33Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass33 save (MyClass33 myclass33) 
	{
		return this.myClass33Repository.save (myclass33);	
	}


}
