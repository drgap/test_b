package ver01_2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {


	@Test
	@DisplayName("joinGroup-member has 1 group")
	void testJoinGroup() {
		LocalDateTime dateCreated = LocalDateTime.now();
		Member m = new Member("Les", "Wrigley", "Lesman", "lwrigley@gmail.com", dateCreated);
		Group g = new Group("Java Programming", "Questions related to programming in Java", "12345", dateCreated);
		m.joinGroup(g, dateCreated);
		assertEquals(1,m.getNumGroups());
	}

	@Test
	@DisplayName("joinGroup-member has 2 groups")
	void testGetNumGroups2() {
		LocalDateTime dateCreated = LocalDateTime.now();
		Member m = new Member("Les", "Wrigley", "Lesman", "lwrigley@gmail.com", dateCreated);
		Group g1 = new Group("Java Programming", "Questions related to programming in Java", "12345", dateCreated);
		Group g2 = new Group("PHP Programming", "Questions related to programming in PHP", "43221", dateCreated );
		m.joinGroup(g1, dateCreated);
		m.joinGroup(g2, dateCreated);
		assertEquals(2,m.getNumGroups());
	}

	@Test
	@DisplayName("getGroup")
	void testGetGroup() {
		LocalDateTime dateCreated = LocalDateTime.now();
		Member m = new Member("Les", "Wrigley", "Lesman", "lwrigley@gmail.com", dateCreated);
		Group g1 = new Group("Java Programming", "Questions related to programming in Java", "12345", dateCreated);
		Group g2 = new Group("PHP Programming", "Questions related to programming in PHP", "43221", dateCreated );
		m.joinGroup(g1, dateCreated);
		m.joinGroup(g2, dateCreated);
		Group actGroup = m.getGroup(g2.getGroupId());
		assertSame(g2,actGroup);
	}

	@Test
	@DisplayName("getGroups")
	void testGetGroups() {
		LocalDateTime dateCreated = LocalDateTime.now();
		Member m = new Member("Les", "Wrigley", "Lesman", "lwrigley@gmail.com", dateCreated);
		Group g1 = new Group("Java Programming", "Questions related to programming in Java", "12345", dateCreated);
		Group g2 = new Group("PHP Programming", "Questions related to programming in PHP", "43221", dateCreated );
		List<Group> expGroups = new ArrayList<>(Arrays.asList(g1,g2));

		m.joinGroup(g1, dateCreated);
		m.joinGroup(g2, dateCreated);

		List<Group> actGroups = m.getGroups();
		for(Group actGroup : actGroups) {
			assertTrue(expGroups.contains(actGroup));
		}
	}

	@Test
	@DisplayName("toString")
	void testToString() {
		LocalDateTime dateCreated = LocalDateTime.now();
		Member m = new Member("Les", "Wrigley", "Lesman", "lwrigley@gmail.com", dateCreated);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fmtDateCreated = dateCreated.format(formatter);
		
		String toString = m.toString();
		assertTrue(toString.contains("Les"));
		assertTrue(toString.contains("Wrigley"));
		assertTrue(toString.contains("Lesman"));
		assertTrue(toString.contains("lwrigley@gmail.com"));
		assertTrue(toString.contains(fmtDateCreated));
		assertEquals(0,m.getNumGroups());

	}

}
