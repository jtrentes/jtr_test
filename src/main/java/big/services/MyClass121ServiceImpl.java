package big.services;

import big.repositories.MyClass121Repository;
import java.util.List;
import big.domain.MyClass121;
import big.repositories.criteria.MyClass121Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass121Service")
@Transactional(readOnly = true)
public class MyClass121ServiceImpl implements MyClass121Service
{

	
	@Autowired
	private MyClass121Repository myClass121Repository;
    

	
	public List<MyClass121> findAll () 
	{
		return this.myClass121Repository.findAll();	
	}

	
	public List<MyClass121> findByCriteria (MyClass121Criteria criteria) 
	{
		return this.myClass121Repository.findByCriteria (criteria);	
	}

	
	public MyClass121 findById (Long id) 
	{
		return this.myClass121Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass121 save (MyClass121 myclass121) 
	{
		return this.myClass121Repository.save (myclass121);	
	}


}
