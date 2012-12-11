package big.services;

import big.domain.MyClass13;
import big.repositories.criteria.MyClass13Criteria;
import java.util.List;
import big.repositories.MyClass13Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass13Service")
@Transactional(readOnly = true)
public class MyClass13ServiceImpl implements MyClass13Service
{

	
	@Autowired
	private MyClass13Repository myClass13Repository;
    

	
	public List<MyClass13> findAll () 
	{
		return this.myClass13Repository.findAll();	
	}

	
	public List<MyClass13> findByCriteria (MyClass13Criteria criteria) 
	{
		return this.myClass13Repository.findByCriteria (criteria);	
	}

	
	public MyClass13 findById (Long id) 
	{
		return this.myClass13Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass13 save (MyClass13 myclass13) 
	{
		return this.myClass13Repository.save (myclass13);	
	}


}
