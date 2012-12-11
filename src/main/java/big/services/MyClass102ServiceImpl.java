package big.services;

import java.util.List;
import big.repositories.MyClass102Repository;
import big.domain.MyClass102;
import big.repositories.criteria.MyClass102Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass102Service")
@Transactional(readOnly = true)
public class MyClass102ServiceImpl implements MyClass102Service
{

	
	@Autowired
	private MyClass102Repository myClass102Repository;
    

	
	public List<MyClass102> findAll () 
	{
		return this.myClass102Repository.findAll();	
	}

	
	public List<MyClass102> findByCriteria (MyClass102Criteria criteria) 
	{
		return this.myClass102Repository.findByCriteria (criteria);	
	}

	
	public MyClass102 findById (Long id) 
	{
		return this.myClass102Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass102 save (MyClass102 myclass102) 
	{
		return this.myClass102Repository.save (myclass102);	
	}


}
