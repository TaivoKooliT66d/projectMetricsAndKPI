package projectKPI;

import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.ResourceContainer;
import net.sf.mpxj.TaskContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * Created by taivo on 26.01.17.
 */
@Component
public class MppRunner implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(MppRunner.class);
    private static ResourceContainer resources;


    private final MppTaskInsert mppTaskInsert;
    private static MppTaskRead mppTaskRead;
    private static TaskContainer tasks;

    public static String file = "/home/taivo/School/i200/projectMetricsAndKPI/projectKPI/src/main/resources/I200.mpp";

    public MppRunner(MppTaskInsert mppTaskInsert, MppTaskRead mppTaskRead) {

        this.mppTaskInsert = mppTaskInsert;
        MppRunner.mppTaskRead = mppTaskRead;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            resources = mppTaskInsert.readFile(file).getAllResources();
            mppTaskInsert.printResources(resources);
            tasks = mppTaskInsert.readFile(file).getAllTasks();
            mppTaskInsert.insertTasks(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String task : mppTaskRead.findAllTasks()) {
            logger.info("Taskid baasis: " + task );
        }

    }
}