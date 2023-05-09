package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.document.Customer;
import in.ineuron.dto.CustomerDTO;
import in.ineuron.generator.IdGenerator;
import in.ineuron.repository.ICustomerRepo;


@Service("service")
public class CustomerManagementServiceImpl implements ICustomerManagementService {

	
	@Autowired
	private ICustomerRepo repo;
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		
		System.out.println("Get Class Name "+repo.getClass().getName());
		Customer document=new Customer();
		document.setId(IdGenerator.generateId());
		BeanUtils.copyProperties(dto,document);
//		document =  repo.insert(document);
		
		return "Document is saved with the id :: "+repo.save(document).getId();
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String removeCustomer(String id) {
	Optional<Customer> optional=repo.findById(id);
	
	if(optional.isPresent()) {
		repo.deleteById(id);
		return "Document is deleted";
	}
		return "Document is not present";
	}

	@Override
	public List<Customer> fetchCustomerByBillAmount(float start, float end) {
		// TODO Auto-generated method stub
		return repo.findByBillAmtBetween(start, end);
	}

//	@Override
//	public String updateCustomer(CustomerDTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
