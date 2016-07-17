package mailpal;


import mailpal.scheduler.MailPalScheduler;
import org.quartz.SchedulerException;

/**
 * @author tsv
 * @since 17.07.2016.
 */
public class RunScheduler {

    public static void main(String [] args) throws SchedulerException {

        MailPalScheduler mailPalScheduler = new MailPalScheduler();
        System.out.println("scheduling jobs");
        mailPalScheduler.schedule();
        System.out.println("starting scheduler");
        mailPalScheduler.startScheduler();
    }
}
