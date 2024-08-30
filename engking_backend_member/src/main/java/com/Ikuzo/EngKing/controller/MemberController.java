package com.Ikuzo.EngKing.controller;


import com.Ikuzo.EngKing.dto.MemberRequestDto;
import com.Ikuzo.EngKing.dto.MemberResponseDto;
import com.Ikuzo.EngKing.entity.Member;
import com.Ikuzo.EngKing.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController //JSON 형식 반환
@RequiredArgsConstructor //final, @NonNull 에 대한 생성자 자동생성
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<Member> registerMember(@RequestBody MemberRequestDto memberRequestDto) throws Exception {
        Member member = memberService.registerMember(memberRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(member); //member 객체를 JSON으로 반환
    }

    @PostMapping("/login")
    public ResponseEntity<Member> loginMember(@RequestBody MemberRequestDto memberRequestDto) throws Exception {
        Member member = memberService.loginMember(memberRequestDto.getEmail(), memberRequestDto.getPassword());
        return ResponseEntity.ok(member);
    }

    @GetMapping("/info")
    public ResponseEntity<MemberResponseDto> memberInfo(@RequestParam String email) {
        //Member member = memberService.memberList(email);
        MemberRequestDto mrequestd= MemberRequestDto.builder().email(email).build();  //email을 가진 dto 생성
        //dto로 요청을 보내고 응답dto를 받자
        MemberResponseDto mrd=memberService.memberInfo(mrequestd);

        return ResponseEntity.ok(mrd);
    }  //email 관련 쿼리로 멤버 정보 조회



    @PatchMapping("/update")
    public ResponseEntity<MemberResponseDto> updateMember( @RequestBody MemberRequestDto memberRequestDto) {
        //Member member=memberService.updateMember(id,memberRequestDto);
        MemberResponseDto mrd=memberService.updateMember(memberRequestDto);
        return ResponseEntity.ok(mrd);  // email이 반환될 것

        //return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 수정 성공했지만 응답 본문 X. 204 No Content

        //ok의 인자로 Dto를 넣는 것이 안전하다!
    }

    @DeleteMapping("/delete")
    public ResponseEntity<MemberResponseDto> deleteMember(@RequestBody MemberRequestDto memberRequestDto) {
        Long id=memberRequestDto.getId();
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }



}
