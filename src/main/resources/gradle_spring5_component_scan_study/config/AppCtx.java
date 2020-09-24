package gradle_spring5_component_scan_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import gradle_spring5_component_scan_study.spring.MemberPrinter;
import gradle_spring5_component_scan_study.spring.MemberSummaryPrinter;

@Configuration
@ComponentScan(basePackages = {"gradle_spring5_component_scan_study.spring"})
public class AppCtx {

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }
    
    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberprinter2() {
    	return new MemberSummaryPrinter();
    }

}
