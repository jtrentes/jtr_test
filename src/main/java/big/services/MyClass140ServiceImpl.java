package big.services;

import java.util.List;
import big.repositories.MyClass140Repository;
import big.repositories.criteria.MyClass140Criteria;
import big.domain.MyClass140;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass140Service")
@Transactional(readOnly = true)
public class MyClass140ServiceImpl implements MyClass140Service
{

	
	@Autowired
	private MyClass140Repository myClass140Repository;
    

	
	public List<MyClass140> findAll () 
	{
		return this.myClass140Repository.findAll();	
	}

	
	public List<MyClass140> findByCriteria (MyClass140Criteria criteria) 
	{
		return this.myClass140Repository.findByCriteria (criteria);	
	}

	
	public MyClass140 findById (Long id) 
	{
		return this.myClass140Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass140 save (MyClass140 myclass140) 
	{
		return this.myClass140Repository.save (myclass140);	
	}


}
