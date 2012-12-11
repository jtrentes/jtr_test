package big.services;

import big.repositories.criteria.MyClass153Criteria;
import java.util.List;
import big.repositories.MyClass153Repository;
import big.domain.MyClass153;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass153Service")
@Transactional(readOnly = true)
public class MyClass153ServiceImpl implements MyClass153Service
{

	
	@Autowired
	private MyClass153Repository myClass153Repository;
    

	
	public List<MyClass153> findAll () 
	{
		return this.myClass153Repository.findAll();	
	}

	
	public List<MyClass153> findByCriteria (MyClass153Criteria criteria) 
	{
		return this.myClass153Repository.findByCriteria (criteria);	
	}

	
	public MyClass153 findById (Long id) 
	{
		return this.myClass153Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass153 save (MyClass153 myclass153) 
	{
		return this.myClass153Repository.save (myclass153);	
	}


}
