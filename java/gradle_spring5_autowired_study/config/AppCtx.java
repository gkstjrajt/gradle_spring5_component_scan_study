package gradle_spring5_autowired_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle_spring5_autowired_study.spring.ChangePasswordService;
import gradle_spring5_autowired_study.spring.MemberDao;
import gradle_spring5_autowired_study.spring.MemberInfoPrinter;
import gradle_spring5_autowired_study.spring.MemberListPrinter;
import gradle_spring5_autowired_study.spring.MemberPrinter;
import gradle_spring5_autowired_study.spring.MemberRegisterService;
import gradle_spring5_autowired_study.spring.MemberSummaryPrinter;

@Configuration
public class AppCtx {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        return pwdSvc;
    }

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

    @Bean
    public MemberListPrinter listPrinter() {
		return new MemberListPrinter(/* memberDao(), memberPrinter() */);
    }
    
    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//        infoPrinter.setMemberDao(memberDao());
//        infoPrinter.setPrinter(memberPrinter());
        return infoPrinter;
    }

}
