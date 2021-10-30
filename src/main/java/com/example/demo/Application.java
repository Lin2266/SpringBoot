package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 當執行啟動類後。SpringBoot會自動掃描@SpringBootApplication註解的同級目錄和子目錄下
 * 的所有Spring組件類，並載入對象到Spring容器中。
 */

//@SpringBootApplication標註這是一個SpringBoot應用程式
//主程式會執行自己套件跟子套件的檔案，如果要用不同套件的檔案，可用下面@SpringBootApplication參數設定套件
//@SpringBootApplication(scanBasePackages = {"com.example.controller"})
@SpringBootApplication
@RestController
//@EnableScheduling //用於為您的應用程序啟用Scheduling程序。
public class Application {
    //Slf4的log
    //private static final Logger logger = LoggerFactory.getLogger(Slf4jApplication.class);

    //SpringBoot應用程式執行入口，是通過main函數啟動應用程式
    public static void main(String[] args) {
//        logger.info("this is a info message");
//        logger.warn("this is a warn message");
//        logger.error("this is a error message");

        // 通過SpringApplication調用run的方式啟動工程
        SpringApplication.run(Application.class, args);
    }
    //註釋編寫一個請求 URI 方法，http://localhost:8080/
    @RequestMapping("/")
    public String welcome(){
        //@ResponseBody //標註返回結果位JSON串
        return "welcome";

    }
}
