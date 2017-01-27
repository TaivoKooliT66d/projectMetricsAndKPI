package projectKPI;

import com.sun.deploy.util.StringUtils;
import net.sf.mpxj.Duration;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.ResourceContainer;
import net.sf.mpxj.TaskContainer;
import net.sf.mpxj.mpp.MPPReader;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.sqlite.date.DateFormatUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;



/**
 * Created by taivo on 17.01.17.
 */
@Component
public class MppTaskInsert {
    private static ResourceContainer resources;
    private static TaskContainer tasks;
    public static String file = "/home/taivo/School/i200/projectMetricsAndKPI/projectKPI/src/main/resources/I200.mpp";
    public static ProjectFile projectFile;
    private final static Logger logger = LoggerFactory.getLogger(MppTaskInsert.class);
    private static JdbcTemplate jdbcTemplate;


    public MppTaskInsert(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void printResources(ResourceContainer resources) { //printer1
        resources.stream().map(n -> n.getName()).forEach(System.out::println);
    }


    static ProjectFile readFile(String file) throws IOException { //file reader

        try {
            MPPReader reader = new MPPReader();
            ProjectFile projectFile = reader.read(file);
            return projectFile;
        } catch (Exception ex) {
            System.out.println("File not found! " + ex.getMessage());
        }
        return null;
    }


    @Transactional
    public static void insertTasks(TaskContainer tasks) {

        tasks.stream().map(n -> Stream.of(
            n.getText(2), //businessproject
            n.getText(11), //productmanager
            n.getText(24), //release
            n.getText(17),//projectmanager
            n.getText(20),//jiraid
            n.getName(), //taksname
            n.getStart(1), //start
            n.getFinish(1), //finish
            n.getPercentageComplete(), //CompletePercent
            n.getDeadline(), //deadline
            n.getNumber(18), //buffer or delay
            n.getFlag(18), //communicated
            n.getRemainingWork(), //work
            n.getWork(), //initialwork
            n.getID(), //taskid
            n.getFlag(20), //Important
            n.getSummary(), //issummary
            n.getOutlineNumber(), //outline number
            n.getOutlineLevel() //outline level
            ).map(MppTaskInsert::format).collect(Collectors.toList())
        ).forEach(

                n ->  {
                    logger.info("n from lambda: " + String.valueOf(n));
                    logger.info("jdbcTempalate from lambda: " +String.valueOf(jdbcTemplate));
                    jdbcTemplate.update("INSERT INTO MPP_TASKS(BusinessProject, ProductManager, Version, ProjectManager, JIRAID, TaskName, Start, " +
                            "Finish, CompletePercent, Deadline, BufferOrDelay, Communicated, Work, InitialWork, TaskID, Important, isSummary, OutlineNumber, OutlineLevel) " +
                            "VALUES (" + StringEscapeUtils.escapeJava(StringUtils.join(n, ",")) + ")");
                }

        );
    }


    static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Object o) {
        if (o == null) {
            return null;
        } else if (o instanceof Duration){
            return "'" + ((Duration) o).getDuration()+ "'";

        } else if (o instanceof String) {
            return "'" + o.toString() + "'";
        } else if (o instanceof Date) {
            return "str_to_date('" + sdFormat.format(o) + "','%Y-%m-%d %H:%i:%s')";
        } else {
            return o.toString();
        }
    }
}

