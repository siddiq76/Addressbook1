
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressbookUC6 implements ManageAddressBook1{
	static Scanner sc=new Scanner(System.in);
	static Map<String,AddressbookUC6> nameToAddressBookMap=new HashMap<String,AddressbookUC6>();
	public String name;
	public ArrayList<Contact5> contacts;
	public Map<String,Contact5> nameToContactMap;
	
	public AddressbookUC6(String name) {
		super();
		this.name=name;
		this.contacts = new ArrayList<Contact5>();
		this.nameToContactMap=new HashMap<String,Contact5>();
	}
	
	public void addContacts() {
		while(true) {
			System.out.println("1.Add next Contact\n2.Exit\nEnter your choice: ");
			int choice1=Integer.parseInt(sc.nextLine());
			if(choice1==1) {
				System.out.println("Enter the fields in order: \nfirst_name\nlastname\naddress\ncity\nstate\nzip\nphone no.\nemail");
				Contact5 contact=new Contact5(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()),Long.parseLong(sc.nextLine()),sc.nextLine());
				this.contacts.add(contact);
				this.nameToContactMap.put(contact.getFirstName()+" "+contact.getLastName(), contact);
			}
			else if(choice1==2) {
				break;
			}
			else {
				System.out.println("Invalid Choice. Try Again.");
			}
		}
		
	}
	
	public void editContact() {
		System.out.println("Enter name of person whose contact details are to be edited: ");
		String name=sc.nextLine();
		System.out.println("Enter the new fields in order: \naddress\ncity\nstate\nzip\nphone no.\nemail");
		nameToContactMap.get(name).setAddress(sc.nextLine());
		nameToContactMap.get(name).setCity(sc.nextLine());
		nameToContactMap.get(name).setState(sc.nextLine());
		nameToContactMap.get(name).setZip(Integer.parseInt(sc.nextLine()));
		nameToContactMap.get(name).setPhoneNumber(Long.parseLong(sc.nextLine()));
		nameToContactMap.get(name).setEmail(sc.nextLine());			
	}
	
	public void deleteContact() {
		System.out.println("Enter the name of Contact person to be deleted: ");
		String name=sc.nextLine();
		contacts.remove(nameToContactMap.get(name));
		nameToContactMap.remove(name);		
	}
	
	public static void addAddressBooks() {
		while(true) {
			System.out.println("1.Add an address book\n2.Exit\nEnter your choice: ");
			int choice=Integer.parseInt(sc.nextLine());
			if(choice==1) {
				System.out.println("Enter name of the address book");
				String name=sc.nextLine();
				nameToAddressBookMap.put(name,new AddressbookUC6(name));
			}
			else if(choice==2) {
				break;
			}
			else {
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
	@Override
	public String toString() {
		return "Address Book "+name+" with "+contacts.size()+(contacts.size()==1?" contact":" contacts");
	}
	public static void main(String[] args){	
		addAddressBooks();
		System.out.println("Enter the name of the address book to continue: ");
		AddressbookUC6 addressBook=nameToAddressBookMap.get(sc.nextLine());
		if(addressBook==null) {
				System.out.println("No address book found with that name.");;
		}
		else {
			addressBook.addContacts();
			System.out.println(addressBook);
			System.out.println("Before edit:");
			for(Contact5 contact: addressBook.contacts) {
				System.out.println(contact);
			}
			addressBook.editContact();		
			System.out.println("After edit");
			for(Contact5 contact: addressBook.contacts) {
				System.out.println(contact);
			}
			addressBook.deleteContact();
			System.out.println("After deletion of contact: \n"+addressBook);
		}			
		sc.close();	
	}
	
}
interface ManageAddressBook1{
	public void addContacts();
	public void editContact();
	public void deleteContact();
}
class Contact5{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String email;
	public Contact5(String firstName, String lastName, String address, String city, String state, int zip,
			long phoneNumber,String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email=email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact5: "+firstName +" "+ lastName+ ", "+address+", "+city+", " +state+ ", "+zip+", "+ phoneNumber + "\n"+email+".";
	}
	
}
