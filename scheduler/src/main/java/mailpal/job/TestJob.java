package mailpal.job;

import javax.mail.MessagingException;

import com.mailpal.mail.connector.ImapConnector;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tsv
 * @since 17.07.2016.
 */
public class TestJob implements Job {

    private ImapConnector imapConnector;

    @Autowired
    public TestJob(ImapConnector connector) {
        this.imapConnector = connector;
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Polling mail box ...");
        try {
            System.out.println("Inbox size is: " + imapConnector.connect());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
