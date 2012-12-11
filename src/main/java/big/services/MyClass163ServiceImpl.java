package big.services;

import java.util.List;
import big.repositories.MyClass163Repository;
import big.repositories.criteria.MyClass163Criteria;
import big.domain.MyClass163;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass163Service")
@Transactional(readOnly = true)
public class MyClass163ServiceImpl implements MyClass163Service
{

	
	@Autowired
	private MyClass163Repository myClass163Repository;
    

	
	public List<MyClass163> findAll () 
	{
		return this.myClass163Repository.findAll();	
	}

	
	public List<MyClass163> findByCriteria (MyClass163Criteria criteria) 
	{
		return this.myClass163Repository.findByCriteria (criteria);	
	}

	
	public MyClass163 findById (Long id) 
	{
		return this.myClass163Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass163 save (MyClass163 myclass163) 
	{
		return this.myClass163Repository.save (myclass163);	
	}


}
