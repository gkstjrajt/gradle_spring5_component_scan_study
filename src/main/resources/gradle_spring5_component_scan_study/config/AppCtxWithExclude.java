package gradle_spring5_component_scan_study.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import gradle_spring5_component_scan_study.spring.ChangePasswordService;
import gradle_spring5_component_scan_study.spring.MemberDao;
import gradle_spring5_component_scan_study.spring.MemberInfoPrinter;
import gradle_spring5_component_scan_study.spring.MemberListPrinter;
import gradle_spring5_component_scan_study.spring.MemberPrinter;
import gradle_spring5_component_scan_study.spring.MemberRegisterService;
import gradle_spring5_component_scan_study.spring.MemberSummaryPrinter;

@Configuration
//@ComponentScan(basePackages = {"gradle_spring5_component_scan_study.spring"},
//			   excludeFilters = @Filter(type = FilterType.REGEX,
//					   					pattern = "gradle_spring5_component_scan_study.spring\\..*Dao"
//				   					)
//								)
@ComponentScan(basePackages = {"gradle_spring5_component_scan_study.spring"},
			   excludeFilters = @Filter(type = FilterType.ASPECTJ,
		   								pattern = "gradle_spring5_component_scan_study.spring.*Dao"
				   					)
								)
public class AppCtxWithExclude {
//    @Bean
//    public MemberDao memberDao() {
//        return new MemberDao();
//    }

//    @Bean
//    public MemberRegisterService memberRegSvc() {
//        return new MemberRegisterService();
//    }

//    @Bean
//    public ChangePasswordService changePwdSvc() {
//        ChangePasswordService pwdSvc = new ChangePasswordService();
//        return pwdSvc;
//    }

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

//    @Bean
//    public MemberListPrinter listPrinter() {
//		return new MemberListPrinter(/* memberDao(), memberPrinter() */);
//    }
    
//    @Bean
//    public MemberInfoPrinter infoPrinter() {
//        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
////        infoPrinter.setMemberDao(memberDao());
////        infoPrinter.setPrinter(memberPrinter());
//        return infoPrinter;
//    }

}
