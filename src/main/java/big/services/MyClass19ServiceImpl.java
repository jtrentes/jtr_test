package big.services;

import java.util.List;
import big.repositories.criteria.MyClass19Criteria;
import big.repositories.MyClass19Repository;
import big.domain.MyClass19;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass19Service")
@Transactional(readOnly = true)
public class MyClass19ServiceImpl implements MyClass19Service
{

	
	@Autowired
	private MyClass19Repository myClass19Repository;
    

	
	public List<MyClass19> findAll () 
	{
		return this.myClass19Repository.findAll();	
	}

	
	public List<MyClass19> findByCriteria (MyClass19Criteria criteria) 
	{
		return this.myClass19Repository.findByCriteria (criteria);	
	}

	
	public MyClass19 findById (Long id) 
	{
		return this.myClass19Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass19 save (MyClass19 myclass19) 
	{
		return this.myClass19Repository.save (myclass19);	
	}


}
