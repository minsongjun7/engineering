package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.MemberCommand;
import service.member.MemberJoinService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	
	@RequestMapping("agree")
	public String agree() {
		return "member/agree";
	}
	@RequestMapping("memberRegister")
	public String memberRegister() {
		return "member/memberForm";
	}
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberCommand memberCommand) {
		memberJoinService.memberInsert(memberCommand);
		System.out.println(memberCommand.getMembAddr());
		return "redirect:../main";
	}
}