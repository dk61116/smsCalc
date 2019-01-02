import java.io.IOException;

import javax.servlet.http.HttpServlet;

import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

import static spark.Spark.get;
import static spark.Spark.post;

public class TwilioServlet extends HttpServlet {

    public static void main(String[] args) {

        get("/", (req, res) -> "Hello Web");

        post("/sms", (req, res) -> {
            String text = req.raw().getParameter("Body");
            String message = "Message";
            if (text.equals("hello")) {
                // Say hi
                message = "Hi there!";
            } else if (text.equals("bye")) {
                // Say goodbye
                message = "Goodbye!";
            }
            res.type("application/xml");
            Body body = new Body
                    .Builder(message)
                    .build();
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
            return twiml.toXml();
        });
    }
}