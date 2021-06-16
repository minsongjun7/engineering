package service.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.MemberDTO;
import repository.MemberRepository;

public class MemberDetailService {
	@Autowired
	MemberRepository memberRepository;
	
	public void memberInfo(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		MemberDTO dto = memberRepository.memberInfo(membId);
		model.addAttribute("dto", dto);
	}
}