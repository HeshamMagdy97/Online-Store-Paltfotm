package adminServicesTest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SWII.Entity.BrandEntity;
import com.SWII.Services.AdminServices;

@RunWith(SpringJUnit4ClassRunner.class)
public class AddBrandTest {

	@Test
	public void addNew() {
		AdminServices service	= new AdminServices();

		BrandEntity s = new BrandEntity("Or","z");
		Assert.assertEquals(service.approveStore("h"),false);

		//Assert.assertEquals(service.addBrand(s),true);
	}
	
	@Test
	public void addExisitingBrandName() {
		AdminServices service	= new AdminServices();

		BrandEntity s = new BrandEntity("H","z");
		BrandEntity w = new BrandEntity("H","q");
		service.addBrand(s);
		Assert.assertEquals(service.approveStore("h"),false);
	}
	
	@Test
	public void addExisitingCategory() {
		AdminServices service	= new AdminServices();

		BrandEntity s = new BrandEntity("q","z");
		BrandEntity w = new BrandEntity("w","z");
		service.addBrand(s);
		Assert.assertEquals(service.addBrand(w),true);
	}
	
	@Test
	public void addEmpty() {
		AdminServices service	= new AdminServices();

		BrandEntity s = new BrandEntity("","");
		Assert.assertEquals(service.addBrand(s),false);
	}
	
	@Test
	public void addSpaces() {
		AdminServices service	= new AdminServices();

		BrandEntity s = new BrandEntity(" "," ");
		Assert.assertEquals(service.addBrand(s),false);
	}
	
	@Test
	public void addSpcial() {
		AdminServices service	= new AdminServices();

		BrandEntity s = new BrandEntity("%^&**^%","!@#$\'/");
		Assert.assertEquals(service.addBrand(s),false);
	}

}
