import java.util.ArrayList;

public class Manage 
{	
	private PatronList PatronList= new PatronList();
	private CopyStore copyStore= new CopyStore();
	private DueDate dueDate= new DueDate();
	private Patron Patron;
	private Copy copy;
	private ArrayList <Copy> copiesEntered;
 	
	Manage (PatronList ps, CopyStore cs)
	{
		PatronList= ps;
		copyStore= cs;
		copiesEntered= new ArrayList <Copy>();  
	}
	
	public Patron startNewTransaction (String PID)
	{
		copiesEntered.clear();
		Patron p = PatronList.fetchPatron(PID);
		return p;
	}
	
	public void setPatron (Patron p)
	{
		this.Patron=p;
	}
	
	public Copy checkOutCopy (String copyID)
	{
		copy = copyStore.fetchCopy(copyID);
		if (copy != null)
		copiesEntered.add(copy);
		return copy;
	}
	
	public void cancelTransaction ()
	{
		copiesEntered.clear();
	}
	
	public void endTransaction ()
	{
		for (Copy copy : copiesEntered)
		{
		Patron.checkOut(copy);	
		}	
	}
	public boolean checkCopyList()
	{
		boolean z= true;
		if (copiesEntered.isEmpty())
			z=false;
			return z;
	}
	
	public String assignDueDate()
	{
			String date= dueDate.resetDate();
			Patron.d.dueDate=date;
			return date;
	}
	  
	
	public Patron getPatronInfo (String PID)
	{
		return PatronList.fetchPatron(PID);
	}

}


