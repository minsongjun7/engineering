package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import service.member.MemberInfoService;
import service.member.MemberJoinService;
import service.member.MemberListService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	
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
	@RequestMapping("memberList")
	public String memberList(Model model) {
		memberListService.memberList(model);
		return "member/memberList";
	}
	@RequestMapping("memberInfo")
	public String memberInfo(@RequestParam(value="membId") String membId,
							 Model model) {
		memberInfoService.memberInfo(membId, model);
		return "member/memberInfo";
	}
}