package com.min.memberapp.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.min.memberapp.model.ResponseMessage;
import com.min.memberapp.service.IMemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {

  private final IMemberService memberService;
  
  @GetMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseMessage getMembers(HttpServletRequest request) {
    Map<String, Object> map = memberService.getMembers(request);
    return ResponseMessage.builder()
              .status(200)
              .message("회원 목록 조회 성공")
              .results(Map.of("count", map.get("count")
                            , "memberList", map.get("memberList")
                            , "paging", map.get("paging")))
            .build();
  }
  
  @GetMapping(value = "/members/{memId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseMessage getMemberById(@PathVariable(name = "memId") int memId) {
    Map<String, Object> map = memberService.getMemberById(memId);
    return ResponseMessage.builder()
              .status(200)
              .message("회원 상세 조회 성공")
              .results(Map.of("member", map.get("member"), "address", map.get("address")))
            .build();
  }
  
  @PostMapping(value = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseMessage registMember(@RequestBody Map<String, Object> params) {
    Map<String, Object> map = memberService.registMember(params);
    return ResponseMessage.builder()
              .status(200)
              .message("신규 회원 등록 성공")
              .results(Map.of("member", map.get("member"), "address", map.get("address")))
            .build();
  }
  
  @PutMapping(value = "/members/{memId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseMessage modifyMember(@PathVariable(name = "memId") int memId
                                    , @RequestBody Map<String, Object> params) {
    params.put("memId", memId);
    Map<String, Object> map = memberService.modifyMember(params);
    return ResponseMessage.builder()
              .status(200)
              .message("회원 정보 수정 성공")
              .results(Map.of("member", map.get("member"), "address", map.get("address")))
            .build();
  }
  
  // 단일 삭제 주소는 /member 입니다.
  @DeleteMapping(value = "/member/{memId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseMessage removeMember(@PathVariable(name = "memId") int memId) {
    memberService.removeMember(memId);
    return ResponseMessage.builder()
              .status(200)
              .message("회원 삭제 성공")
              .results(null)
            .build();
  }
  
  // 다중 삭제 주소는 /members 입니다.
  @DeleteMapping(value = "/members/{memIds}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseMessage removeSelectMember(@PathVariable(name = "memIds") String memIds) {
    memberService.removeSelectMember(memIds);
    return ResponseMessage.builder()
              .status(200)
              .message("선택한 회원 삭제 성공")
              .results(null)
            .build();
  }
  
}
