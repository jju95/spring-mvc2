package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    //@RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    @GetMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok!";
    }

    // 경로변수
    @GetMapping("/mapping/{userId}") // 이름과 파라미터가 같다면 괄호 생략가능함
    public String mappingPath(@PathVariable("userId") String userId){
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    // pathVariable 다중 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}",userId, orderId);
        return "ok";
    }

    // 쿼리 파라미터로 조건 매핑 -> 파라미터에 'mode=debug'가 있어야 실행됌
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam(){
        return "ok";
    }

    // http header 조건 매핑 ( 조건 매핑 )
    @GetMapping(value ="/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappinHeader");
        return "ok";
    }

    // header 조건 매핑 ( data type 매핑 ) , 컨텐트 타입
    @PostMapping(value="/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes(){
        return "ok";
    }

    // Accept 기반 Media type 매핑 , 요청 타입
    @PostMapping(value="/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces(){
        log.info("mapping Produces={}");
        return "ok";
    }



}
