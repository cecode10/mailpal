package mailpal.scheduler;

import mailpal.job.TestJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author tsv
 * @since 17.07.2016.
 */
public class MailPalScheduler {

    private Scheduler scheduler;

    public void schedule() throws SchedulerException {

        scheduler = StdSchedulerFactory.getDefaultScheduler();

        // define the job and tie it to our MyJob class
        JobDetail job = newJob(TestJob.class)
                .withIdentity("testJob", "mailpal")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("testTrigger", "mailpal")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);


    }

    public void startScheduler() throws SchedulerException {

        scheduler.start();
    }
}
