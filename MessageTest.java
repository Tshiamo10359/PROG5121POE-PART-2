import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class MessageNGTest {
    
    public MessageNGTest() {
        

        
public class MessageTest {

    @Test
    public void testCheckMessageID_Success() {
        Message msg = new Message();
        msg.setMessageID("1234567890");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testCheckMessageID_Failure() {
        Message msg = new Message();
        msg.setMessageID("12345678901");
        assertFalse(msg.checkMessageID());
    }

    @Test
    public void testCheckRecipientCell_Success() {
        Message msg = new Message();
        msg.setRecipient("+27718693002");
        assertEquals(1, msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Failure() {
        Message msg = new Message();
        msg.setRecipient("08575975889");
        assertEquals(0, msg.checkRecipientCell());
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message();
        msg.setMessageID("0098765432");
        msg.setMessageNumber(0);
        msg.setMessage("Hi Mike, can you join us for dinner tonight");
        String expected = "00:0:HITONIGHT";
        assertEquals(expected, msg.createMessageHash());
    }

    @Test
    public void testCheckMessageLength_Success() {
        Message msg = new Message();
        msg.setMessage("Hi Keegan, did you receive the payment?");
        assertTrue(msg.checkMessageLength());
    }

    @Test
    public void testCheckMessageLength_Failure() {
        Message msg = new Message();
        String longMessage = "A".repeat(260); // 260 characters
        msg.setMessage(longMessage);
        assertFalse(msg.checkMessageLength());
    }
}
}
        
    onicca
tshiamo10
0670173962
BUILD SUCCESSFUL (total time: 22 seconds)
