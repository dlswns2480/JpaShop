package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @GetMapping("api/v1/members")
    public List<Member> showMemberV1(){
        return memberService.findMembers();
    }

    @GetMapping("api/v2/members")
    public Result showMemberV2(){
        List<Member> members = memberService.findMembers();
        List<MemberDto> collect = new ArrayList<>();
        for(Member member : members){
            collect.add(new MemberDto(member.getName()));
        }
        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String name;
    }

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member){
        Long memberId = memberService.join(member);
        return new CreateMemberResponse(memberId);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request){
        Member member = new Member();

        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);

    }

    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(@PathVariable("id") Long id, @RequestBody @Valid UpdateMemberRequest request){
        Member member = memberService.findOne(id);
        member.setName(request.getName());

        return new UpdateMemberResponse(member.getId(), request.getName());
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse{
        private Long id;
        public String name;
    }

    @Data
    static class UpdateMemberRequest{
        private String name;
    }

    @Data
    static class CreateMemberRequest{
        String name;


    }

    @Data
    static class CreateMemberResponse {
        Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }
}
