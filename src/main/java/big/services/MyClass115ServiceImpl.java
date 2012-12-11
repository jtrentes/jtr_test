package big.services;

import big.domain.MyClass115;
import big.repositories.criteria.MyClass115Criteria;
import java.util.List;
import big.repositories.MyClass115Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass115Service")
@Transactional(readOnly = true)
public class MyClass115ServiceImpl implements MyClass115Service
{

	
	@Autowired
	private MyClass115Repository myClass115Repository;
    

	
	public List<MyClass115> findAll () 
	{
		return this.myClass115Repository.findAll();	
	}

	
	public List<MyClass115> findByCriteria (MyClass115Criteria criteria) 
	{
		return this.myClass115Repository.findByCriteria (criteria);	
	}

	
	public MyClass115 findById (Long id) 
	{
		return this.myClass115Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass115 save (MyClass115 myclass115) 
	{
		return this.myClass115Repository.save (myclass115);	
	}


}
