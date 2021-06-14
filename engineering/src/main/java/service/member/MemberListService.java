package service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.MemberDTO;
import repository.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	
	public void memberList(Model model) {
		List<MemberDTO> list = memberRepository.memberList();
		model.addAttribute("lists", list);
	}
}