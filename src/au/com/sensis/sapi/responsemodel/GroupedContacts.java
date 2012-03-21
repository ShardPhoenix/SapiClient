package au.com.sensis.sapi.responsemodel;

import java.util.List;

public class GroupedContacts<E> {
   
    private String name;
    private List<E> contacts;
    
    public GroupedContacts(String name, List<E> contacts) {
        this.name = name;
        this.contacts = contacts;
    }
    
    public GroupedContacts() {
		
	}

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
		this.name = name;
	}
    
    public List<E> getContacts() {
        return contacts;
    }
    
    public void setContacts(List<E> contacts) {
		this.contacts = contacts;
	}
}
