package org.example;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PermissionService {
    private static final Map<String, List<String>> permissions = Map.of(
            "1", List.of("1", "2", "3"),
            "2", List.of("4", "5"),
            "3", List.of("1", "2", "3", "4", "5")
    );

    public List<String> getPermissions(String memberId) {
        return permissions.getOrDefault(memberId, Collections.emptyList());
    }
}
