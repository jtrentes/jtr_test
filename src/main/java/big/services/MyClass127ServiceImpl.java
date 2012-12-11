package big.services;

import big.domain.MyClass127;
import big.repositories.MyClass127Repository;
import java.util.List;
import big.repositories.criteria.MyClass127Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass127Service")
@Transactional(readOnly = true)
public class MyClass127ServiceImpl implements MyClass127Service
{

	
	@Autowired
	private MyClass127Repository myClass127Repository;
    

	
	public List<MyClass127> findAll () 
	{
		return this.myClass127Repository.findAll();	
	}

	
	public List<MyClass127> findByCriteria (MyClass127Criteria criteria) 
	{
		return this.myClass127Repository.findByCriteria (criteria);	
	}

	
	public MyClass127 findById (Long id) 
	{
		return this.myClass127Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass127 save (MyClass127 myclass127) 
	{
		return this.myClass127Repository.save (myclass127);	
	}


}
