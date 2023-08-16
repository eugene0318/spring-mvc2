package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {
	private Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
	public String helloBasic() {
		log.info("hellobasic");
		return "ok";
	}

	/**
	 * 편리한 축약 애노테이션 (코드보기)
	 * 
	 * @GetMapping
	 * @PostMapping
	 * @PutMapping
	 * @DeleteMapping
	 * @PatchMapping
	 */
	@GetMapping(value = "/mapping-get-v2")
	public String mappingGetV2() {
		log.info("mapping-get-v2");
		return "ok";
	}

	/*
	 * PathVariable
	 * 
	 * @PathVariable("userId") String userId -> @PathViable userId
	 */
	@GetMapping("/mapping/{userId}")
	public String mappingPath(@PathVariable String userId) {
		log.info("mappingPath userId={}", userId);
		return "ok";
	}

	/**
	 * PathVariable 사용 다중
	 */
	@GetMapping("/mapping/users/{userId}/orders/{orderId}")
	public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
		log.info("mappingPath userId={}, orderId={}", userId, orderId);
		return "ok";
	}

	/**
	 * 파라미터로 추가 매핑 params="mode", params="!mode" params="mode=debug"
	 * params="mode!=debug" (! = ) params = {"mode=debug","data=good"}
	 */
	@GetMapping(value = "/mapping-param", params = "mode=debug")
	public String mappingParam() {
		log.info("mappingParam");
		return "ok";
	}
}
