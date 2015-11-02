package sample.btrace.traced;

/**
 * 
 * This is a Target Class to be debug
 *
 */
public class DebugedSample {
	
	private String privateFiledWithAccessor;
	private String privateFieldWithoutAccessor;
	public  String publicField;
	
	public String getPrivateFiledWithAccessor() {
		return privateFiledWithAccessor;
	}
	public void setPrivateFiledWithAccessor(String privateFiledWithAccessor) {
		this.privateFiledWithAccessor = privateFiledWithAccessor;
	}
	
	public void test(int count) throws InterruptedException{
		
		Thread.sleep(1000*5);
		
		setValues(count);
	}
	
	public void startTest() throws InterruptedException{
		for (int i=0; i<1000; i++){
			System.out.println("Start test round " + i);
			System.out.println("Reset values before new test.");
			resetValues(i);
			test(i);
		}
	}
	
	private void resetValues(int count){
		privateFiledWithAccessor     = "privateFiledWithAccessor reset " + count;
		privateFieldWithoutAccessor  = "privateFieldWithoutAccessor reset " + count;
		publicField                  = "publicField reset " + count;
	}
	private void setValues(int count){
		privateFiledWithAccessor     = "privateFiledWithAccessor set value " + count;
		privateFieldWithoutAccessor  = "privateFieldWithoutAccessor set value " + count;
		publicField                  = "publicField set value " + count;
	}
	
	public static void main(String[] args) throws Exception {
		DebugedSample sample = new DebugedSample();
		sample.startTest();
	}
}
