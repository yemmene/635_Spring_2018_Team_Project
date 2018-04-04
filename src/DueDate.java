
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
  
public class DueDate {
	public String dueDate;
	SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy");
	Calendar calendar = new GregorianCalendar();
	
	public String resetDate()
	{
	// a semester is usually about 4 months, so we add 4 months to current date to assign a due date
		calendar.add(Calendar.MONTH, 4); 
		dueDate = date.format(calendar.getTime());
		calendar.add(Calendar.MONTH, -4);// resetting date after addition to be ready for any other transaction 
		return dueDate;	
		// no array list is needed here because we assume that books will be checked out 
		//in one transaction, so we need one date for all books
	}
 
	
	public String toString()
	{
		return "\tDue date:"+ dueDate;
	}
 
}