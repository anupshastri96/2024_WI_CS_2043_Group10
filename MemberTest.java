import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MemberTest {

	@Test
	void testToFileFormat() {
		Members member = new Members("1", "John Doe", "123456789", "123 Main St");
		String expectedString = "1;John Doe; 123456789;123 Main St";
		String text = "";
		try {
			text = member.toFileFormat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(text, expectedString);
        }
}
