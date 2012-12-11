package big.services;

import big.repositories.MyClass133Repository;
import big.domain.MyClass133;
import big.repositories.criteria.MyClass133Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass133Service")
@Transactional(readOnly = true)
public class MyClass133ServiceImpl implements MyClass133Service
{

	
	@Autowired
	private MyClass133Repository myClass133Repository;
    

	
	public List<MyClass133> findAll () 
	{
		return this.myClass133Repository.findAll();	
	}

	
	public List<MyClass133> findByCriteria (MyClass133Criteria criteria) 
	{
		return this.myClass133Repository.findByCriteria (criteria);	
	}

	
	public MyClass133 findById (Long id) 
	{
		return this.myClass133Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass133 save (MyClass133 myclass133) 
	{
		return this.myClass133Repository.save (myclass133);	
	}


}
