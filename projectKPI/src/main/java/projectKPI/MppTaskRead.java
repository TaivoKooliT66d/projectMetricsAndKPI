package projectKPI;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by taivo on 27.01.17.
 */
@Component
public class MppTaskRead {


        //private final static Logger logger = LoggerFactory.getLogger(MppTaskRead.class);

        private final JdbcTemplate jdbcTemplate;


        public MppTaskRead(JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }


        public List<String> findAllTasks() {
            return jdbcTemplate.query("SELECT TaskName FROM MPP_TASKS;",
                    (rs, rowNum) -> rs.getString("TaskName"));
        }


}
