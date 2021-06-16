package controller.member;

import javax.annotation.RegEx;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import model.AuthInfo;
import service.member.MemberDeleteOkService;
import service.member.MemberDeleteService;
import service.member.MemberDetailService;
import service.member.MemberInfoService;
import service.member.MemberJoinService;
import service.member.MemberListService;
import service.member.MemberModifyService;
import service.member.MemberPwChangeService;
import service.member.MemberUpdateService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteOkService memberDeleteOkService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	MemberPwChangeService memberPwChangeService;
	
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
	@RequestMapping("memberModify")
	public String memberModify(@RequestParam(value="membId") String membId,
			 Model model) {
		memberInfoService.memberInfo(membId, model);
		return "member/memberModify";
	}
	@RequestMapping("memberModifyOk")
	public String memberModifyOk(MemberCommand memberCommand) {
		memberModifyService.memberUpdate(memberCommand);
		return "redirect:memberInfo?membId="+ memberCommand.getMembId();
	}
	@RequestMapping("memberDelete")
	public String memberDelete(@RequestParam(value="membId") String membId) {
		memberDeleteService.memberDelete(membId);
		System.out.println(membId);
		return "redirect:memberList";
	}
	@RequestMapping("memberMyPage")
	public String myPage() {
		return "member/memberMyPage";
	}
	@RequestMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		memberDetailService.memberInfo(session, model);
		return "member/memberDetail";
	}
	@RequestMapping("memberUpdate")
	public String memberUpdate(HttpSession session, Model model) {
		memberDetailService.memberInfo(session, model);
		return "member/memberUpdate";
	}
	@RequestMapping("memberUpdateOk")
	public String memberUpdateOk(MemberCommand memberCommand, HttpSession session) {
		int i = memberUpdateService.memberUpdate(memberCommand, session);
		if(i == 1) {
			return "redirect:myInfo";
		}
		else {
			return "redirect:memberUpdate";
		}
	}
	@RequestMapping("memDelete")
	public String memberDelete() {
		return "member/memberDelete";
	}
	@RequestMapping("memberDeleteOk")
	public String memberDeleteOk(@RequestParam(value="membPw") String membPw, HttpSession session) {
		memberDeleteOkService.del(session,membPw);
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("pwChange")
	public String pwChange() {
		return "member/pwChange";
	}
	@RequestMapping("pwChangeConfirm")
	public String pwChangeConfirm(HttpSession session, @RequestParam(value="membPw") String membPw) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userPw = authInfo.getUserPw();
		if(bCryptPasswordEncoder.matches(membPw, userPw)) {
			return "member/pwChangeConfirm";
		}
		else {
			return "member/pwChange";
		}
	}
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(HttpSession session, @RequestParam(value="membPw") String membPw,
							@RequestParam(value="newPw") String newPw, @RequestParam(value="newPwCon") String newPwCon) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		String pw = authInfo.getUserPw();
		if(bCryptPasswordEncoder.matches(membPw, pw)) {
			if(newPw.equals(newPwCon)) {
				//비밀번호 변경
				memberPwChangeService.pwOk(userId, newPw);
				return "redirect:/";
			}
			else {
				return "member/pwChangeConfirm";
			}
		}
		else {
			return "member/pwChangeConfirm";
		}
	}
}