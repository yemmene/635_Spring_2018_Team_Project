import static org.junit.Assert.*;

import org.junit.Test;

public class CopyStoreTest {

	@Test
	public void testFetchCopy() {
		Copy c =null;
		CopyStore cs= new CopyStore();
		assertEquals( c, cs.fetchCopy("0600"));
 	}

}
// 