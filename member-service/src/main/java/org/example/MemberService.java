package org.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private static List<Member> members = List.of(
            new Member("1", "사용자1", List.of("1", "2", "3")),
            new Member("2", "사용자2", List.of("4", "5")),
            new Member("3", "사용자3", List.of("1", "2", "3", "4", "5"))
    );

    public Member getMember(String memberId) {
        return members.stream().filter(member -> member.getId().equals(memberId)).findFirst().orElse(null);
    }
}

