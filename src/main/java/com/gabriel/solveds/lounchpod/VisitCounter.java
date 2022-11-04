package com.gabriel.solveds.lounchpod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

class VisitCounter {

    public static void main(String[] args) {

        Map<String, UserStats> f = new HashMap<>();
        f.put("20", new UserStats(20L));
        Map<String, UserStats> f2 = new HashMap<>();
        f.put("60", new UserStats(60L));
        Map<String, UserStats> f4 = new HashMap<>();
        f.put("a", new UserStats(20L));

        VisitCounter v = new VisitCounter();
        Map<Long, Long> res = v.count(f, f2, f4);
        System.out.println(res);
    }

    Map<Long, Long> count(Map<String, UserStats>... visits) {

        Map<Long, Long> result = new HashMap<>();

        Stream<Map<String, UserStats>> stream = Arrays.stream(visits);

        stream.forEach((item) -> {
            item.forEach((key, value) -> {
                try {
                    Long id = Long.parseLong(key);
                    Long visitC = value.getVisitCount().get();
                    result.put(id, visitC);
                } catch (NumberFormatException nfe) {
                }
            });
        });

        return result != null ? result : new HashMap<>();
    }
}

class UserStats {
    private Optional<Long> visitCount;

    public UserStats(Long visitCount) {
        this.visitCount = Optional.of(visitCount);
    }

    public Optional<Long> getVisitCount() {
        return this.visitCount;
    }
}
