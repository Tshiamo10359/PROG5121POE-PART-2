import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class MessageManagerTest {
    private MessageManager manager;

    @Before
    public void setUp() {
        manager = new MessageManager("test_messages.json");  // Use test file
    }

    @Test
    public void testSendMessage() {
        boolean result = manager.sendMessage("1234567890", "Hello Test", "user1");
        assertTrue(result);
    }

    @Test
    public void testSearchById() {
        manager.sendMessage("1234567890", "Search Me", "user1");
        List<Message> all = manager.getAllMessages();
        Message last = all.get(all.size() - 1);
        Message found = manager.searchMessageById(last.getId());
        assertNotNull(found);
        assertEquals("Search Me", found.getMessageText());
    }

    @Test
    public void testSearchByRecipient() {
        manager.sendMessage("1111111111", "Recipient Test", "user1");
        List<Message> results = manager.searchMessagesByRecipient("1111111111");
        assertFalse(results.isEmpty());
    }

    @Test
    public void testGetAllMessages() {
        List<Message> messages = manager.getAllMessages();
        assertNotNull(messages);
    }
}
