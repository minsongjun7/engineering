package service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.MemberDTO;
import repository.MemberRepository;

public class MemberInfoService {
	@Autowired
	MemberRepository memberRepository;
	
	public void memberInfo(String membId, Model model) {
		MemberDTO dto = memberRepository.memberInfo(membId);
		model.addAttribute("dto", dto);
	}
}