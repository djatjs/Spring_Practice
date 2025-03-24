package kr.kh.tmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.tmp.dao.MemberDAO;
import kr.kh.tmp.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		//아이디, 비번, 이메일 유효성 검사
		
		//비번 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		try{
			//가입한 아이디로 가입한 경우
			return memberDao.insertMember(member);
		}catch (Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		//id는 not null로 설정해놓았기 때문에 null 체크 안해도됨
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//아이디를 잘못입력했을 때
		if(user == null) {
			return null;
		}
		//비밀번호가 다른경우
		if(!passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return null;
		}
		return user;
	}
}
