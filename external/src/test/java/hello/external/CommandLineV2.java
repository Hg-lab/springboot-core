package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {

    // 커맨드 라인 옵션 인수
    // --Durl=devdb --Dusername=dev_user --Dpassword=dev_pw mode=on
    public static void main(String[] args) {
        for (String arg : args) {
            // 단순 문자열로 출력됨
            log.info("arg {}", arg);
        }

        // Spring 에서 제공하는 커맨드 라인 옵션 인수 Arguments 인터페이스
        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
        log.info("NonOptionArgs = {}", List.of(appArgs.getNonOptionArgs()));
        log.info("OptionNames = {}", List.of(appArgs.getOptionNames()));

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode"); // NonOptionArgs 이므로 null을 반환함
        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);
        log.info("mode={}", mode);
    }
}
