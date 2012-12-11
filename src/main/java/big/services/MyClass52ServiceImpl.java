package big.services;

import java.util.List;
import big.repositories.criteria.MyClass52Criteria;
import big.repositories.MyClass52Repository;
import big.domain.MyClass52;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass52Service")
@Transactional(readOnly = true)
public class MyClass52ServiceImpl implements MyClass52Service
{

	
	@Autowired
	private MyClass52Repository myClass52Repository;
    

	
	public List<MyClass52> findAll () 
	{
		return this.myClass52Repository.findAll();	
	}

	
	public List<MyClass52> findByCriteria (MyClass52Criteria criteria) 
	{
		return this.myClass52Repository.findByCriteria (criteria);	
	}

	
	public MyClass52 findById (Long id) 
	{
		return this.myClass52Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass52 save (MyClass52 myclass52) 
	{
		return this.myClass52Repository.save (myclass52);	
	}


}
