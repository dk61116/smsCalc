import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACd36e707da19ccee63dddc1cda2c76ec2";
    public static final String AUTH_TOKEN = "d18db56553577527c32826ca6b2ce57c";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+14087754384"), // to
                        new PhoneNumber("+14153222279"), // from
                            "Where's NK?")
                .create();

        System.out.println(message.getSid());
    }
}
