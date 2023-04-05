package hello.external;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV1 {

    // 커맨드 라인 인수
    // dataA dataB
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("args={}", arg);
        }
    }
}
