package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class LogTestController {

//	private final Logger log = LoggerFactory.getLogger(LogTestController.class);

	@RequestMapping("/log-test")
	public String logTest() {
		String name = "Spring";
		log.trace("info trace={}", name);
		log.info("info log={}", name);
		log.debug("info debug={}", name);
		log.warn("info warn={}", name);
		log.error("info error={}", name);
		return "ok";
	}
}
