import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class WorkerTest {

	@Test
	public void testCheckOut() {
		Patron Patron= new Patron("Edison", "08");
		Copy copy= new Copy("1000");
		Patron.checkOut(copy);
		assertEquals (Patron , copy.getCopyTo());
	}
	@Test
	public void testArraList()
	{
		ArrayList<Copy> array = new ArrayList<Copy>();
		assertEquals (0,array.size());
		Copy c1=new Copy ("0500");
		array.add(c1);
		assertEquals (1,array.size());
		Copy c2=new Copy ("0600");
		array.add(c2);
		assertEquals (2,array.size());
	}

}
