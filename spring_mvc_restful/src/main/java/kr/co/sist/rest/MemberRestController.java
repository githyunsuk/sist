package kr.co.sist.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

	// 아이디를 키로 MemberDTO를 저장
	private final Map<String, MemberDTO> memberMap = new HashMap<String, MemberDTO>();

	@PostMapping("/member")
	public MessageDTO addMember(@RequestBody MemberDTO mDTO) {

		String id = mDTO.getId();
		String msg = "추가 실패 - 아이디가 존재합니다.";

		if (!memberMap.containsKey(id)) {
			memberMap.put(id, mDTO);
			msg = "추가 성공";
		}

		System.out.println(mDTO);
		MessageDTO msgDTO = new MessageDTO(msg);
		System.out.println(msgDTO);
		return msgDTO;
	}

	@GetMapping("/members")
	//RestController는 return 객체(Map, List, Set, DTO)를 JSON문자열로 변환하여 응답
	public Collection<MemberDTO> searchAllMember(){
		Collection<MemberDTO> collection = memberMap.values();
		System.out.println(collection);
		return collection;
	}

}
