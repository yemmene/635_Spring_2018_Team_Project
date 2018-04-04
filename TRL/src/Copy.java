
public class Copy {
	private String copyID;
	private Patron PatronCheckOut;

	public Copy (String c)
	{
		copyID=c;
	}

	public String getCopyID() {
		return copyID;
	}
	
	public void setCopyTo(Patron p)
	{
		PatronCheckOut=p;
	}
	
	public Patron getCopyTo()
	{
		return PatronCheckOut;
	}
	
	public String toString()
	{
		return "\t Copy id:" + copyID + "\t";
	}

	
}
