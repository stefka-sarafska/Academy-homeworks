package connectionDB;

import Exception.DALException;
import person.Address;

public interface AddressStorage {
	public Address getAddress(int id) throws DALException; 
	public int insertAddress(Address address) throws DALException; 
}
