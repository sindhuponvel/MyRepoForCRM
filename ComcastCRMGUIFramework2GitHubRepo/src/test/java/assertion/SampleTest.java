package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.Base1;
import com.comcast.crm.baseutility.BaseMainTest;

public class SampleTest extends Base1
{
	@Test
	public void createInvoiceTest() {
		System.out.println("Execute createInvoiceTest");
		String actTitle=d.getTitle();
		Assert.assertEquals(actTitle, "Home");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}

	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("Execute InvoiceWithContactTest");
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}


}
