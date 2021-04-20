package com.nagarro.user.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger log = LoggerFactory.getLogger(Schedule.class);

	/* @Scheduled(cron = "${cronExpression}") */
	public void scheduledTask() {
		log.info("Scheduled job is starting...");

		log.info("Running query to determine total user records...");
		String sql = "SELECT COUNT(*) FROM user_table";
		int size = jdbcTemplate.queryForObject(sql, Integer.class);
		log.info("{} total user record(s) found", size);

	}
}
