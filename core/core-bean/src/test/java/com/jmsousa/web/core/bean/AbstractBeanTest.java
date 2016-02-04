package com.jmsousa.web.core.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for <code>AbstractBean</code> class
 * 
 * @author jmsousa
 */
public class AbstractBeanTest {

	private BeanTest1	beanTest1_1;
	private BeanTest1	beanTest1_2;
	private BeanTest2	beanTest2_1;
	private BeanTest2	beanTest2_2;
	private BeanTest3	beanTest3_1;
	private BeanTest3	beanTest3_2;
	private BeanTest4	beanTest4_1;
	private BeanTest4	beanTest4_2;

	@Before
	public void createBeanTest() {
		beanTest1_1 = new BeanTest1();
		beanTest1_1.setId(1L);
		beanTest1_1.setCreationDate(new Date(1000));
		beanTest1_1.fieldString = "Test string";
		beanTest1_1.fieldList = Arrays.asList("item1", "item2");

		beanTest1_2 = new BeanTest1();
		beanTest1_2.setId(1L);
		beanTest1_2.setCreationDate(new Date(1000));
		beanTest1_2.fieldString = "Test string";
		beanTest1_2.fieldList = Arrays.asList("item1", "item2");

		beanTest2_1 = new BeanTest2();
		beanTest2_1.setId(1L);
		beanTest2_1.setCreationDate(new Date(1000));
		beanTest2_1.fieldString = "Test string";
		beanTest2_1.fieldList = Arrays.asList("item1", "item2");

		beanTest2_2 = new BeanTest2();
		beanTest2_2.setId(1L);
		beanTest2_2.setCreationDate(new Date(1000));
		beanTest2_2.fieldString = "Test string";
		beanTest2_2.fieldList = Arrays.asList("item1", "item2");

		beanTest3_1 = new BeanTest3();
		beanTest3_1.setId(1L);

		beanTest3_2 = new BeanTest3();
		beanTest3_2.setId(1L);

		beanTest4_1 = new BeanTest4();
		beanTest4_1.setId(1L);

		beanTest4_2 = new BeanTest4();
		beanTest4_2.setId(1L);
	}

	@Test
	public void equalsTest() {

		// Null object
		Assert.assertFalse("Null object", beanTest1_1.equals(null));

		// Same instances
		Assert.assertTrue("Same instances", beanTest1_1.equals(beanTest1_1));

		// Same objects, different instances, equality null
		Assert.assertTrue("Same objects, different instances, equality null", beanTest2_1.equals(beanTest2_2));

		// Same objects, different instances with same field values
		Assert.assertTrue("Same objects, different instances with same field values", beanTest1_1.equals(beanTest1_2));

		// Same objects, different instances and different field values
		Assert.assertFalse("Same objects, different instances and different field values", beanTest1_1
						.equals(new BeanTest1()));

		// Different objects, same field values
		Assert.assertFalse("Different objects, same field values", beanTest1_1.equals(beanTest2_1));

		// Same objects, equality = null
		Assert.assertTrue("Same objects, equality = null", beanTest3_1.equals(beanTest3_2));

		// Same objects, equality = this
		Assert.assertTrue("Same objects, equality = this", beanTest4_1.equals(beanTest4_2));
	}

	@Test
	public void toStringTest() {

		Assert.assertNotNull(beanTest1_1.toString());
		Assert.assertNotNull(beanTest2_1.toString());
		Assert.assertNotNull(beanTest3_1.toString());
		Assert.assertNotNull(beanTest4_1.toString());

	}

	private static class BeanTest1
		extends AbstractBean {

		private static final long	serialVersionUID	= 1L;

		private String				fieldString;

		private List<String>		fieldList;

		@Override
		protected Object getEquality() {
			return Arrays.asList(getId(), getCreationDate(), fieldString, fieldList);
		}

	}

	private static class BeanTest2
		extends AbstractBean {

		private static final long	serialVersionUID	= 1L;

		private String				fieldString;

		private List<String>		fieldList;

		@Override
		protected Object getEquality() {
			return Arrays.asList(getId(), getCreationDate(), fieldString, fieldList);
		}

	}

	private static class BeanTest3
		extends AbstractBean {

		private static final long	serialVersionUID	= 1L;

		private String				fieldString;

		private List<String>		fieldList;

		@Override
		protected Object getEquality() {
			return this;
		}

	}

	private static class BeanTest4
		extends AbstractBean {

		private static final long	serialVersionUID	= 1L;

		private String				fieldString;

		private List<String>		fieldList;

		@Override
		protected Object getEquality() {
			return null;
		}

	}
}
