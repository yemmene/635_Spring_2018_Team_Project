import static org.junit.Assert.*;

import org.junit.Test;

public class CopyTest {
	Patron p= new Patron ("Darren", "04");
	Copy c= new Copy ("0500");
	
	@Test
	public void testSetCopyTo() {
		c.setCopyTo(p);
		assertEquals (c.getCopyTo(), p);
		//fail("Not yet implemented");
	}


}
