package big.services;

import big.repositories.MyClass110Repository;
import big.repositories.criteria.MyClass110Criteria;
import big.domain.MyClass110;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass110Service")
@Transactional(readOnly = true)
public class MyClass110ServiceImpl implements MyClass110Service
{

	
	@Autowired
	private MyClass110Repository myClass110Repository;
    

	
	public List<MyClass110> findAll () 
	{
		return this.myClass110Repository.findAll();	
	}

	
	public List<MyClass110> findByCriteria (MyClass110Criteria criteria) 
	{
		return this.myClass110Repository.findByCriteria (criteria);	
	}

	
	public MyClass110 findById (Long id) 
	{
		return this.myClass110Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass110 save (MyClass110 myclass110) 
	{
		return this.myClass110Repository.save (myclass110);	
	}


}
