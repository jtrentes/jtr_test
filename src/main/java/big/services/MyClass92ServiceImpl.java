package big.services;

import java.util.List;
import big.repositories.criteria.MyClass92Criteria;
import big.domain.MyClass92;
import big.repositories.MyClass92Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass92Service")
@Transactional(readOnly = true)
public class MyClass92ServiceImpl implements MyClass92Service
{

	
	@Autowired
	private MyClass92Repository myClass92Repository;
    

	
	public List<MyClass92> findAll () 
	{
		return this.myClass92Repository.findAll();	
	}

	
	public List<MyClass92> findByCriteria (MyClass92Criteria criteria) 
	{
		return this.myClass92Repository.findByCriteria (criteria);	
	}

	
	public MyClass92 findById (Long id) 
	{
		return this.myClass92Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass92 save (MyClass92 myclass92) 
	{
		return this.myClass92Repository.save (myclass92);	
	}


}
