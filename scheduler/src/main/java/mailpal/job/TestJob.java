package mailpal.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author tsv
 * @since 17.07.2016.
 */
public class TestJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("Hello World!  MyJob is executing.");
    }
}
