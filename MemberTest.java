import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberTest {

	@Test
	void testToFileFormat() {
		Member member = new Member("1", "John Doe", "123456789", "123 Main St");
		String expectedString = "1;John Doe; 123456789;123 Main St";
		try {
			String text = member.toFileFormat()
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(text, expectedString)
        }
}
