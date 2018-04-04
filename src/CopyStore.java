import java.util.HashMap;
public class CopyStore {
	private HashMap <String, Copy> copyList;
	public CopyStore ()
	{
		copyList = new HashMap <String, Copy>();
		copyList.put("0100", new Copy ("0100"));
		copyList.put("0200", new Copy ("0200"));
		copyList.put("0300", new Copy ("0300"));
		copyList.put("0400", new Copy ("0400"));	
	}
		

	public Copy fetchCopy (String copyID )
	{
		return copyList.get(copyID);
	}
}
