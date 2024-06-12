package com.example.strategy.navigation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Navigator {
    NavigationStrategy navigationStrategy;

    public void navigate(String from, String to) {
        navigationStrategy.navigate(from, to);
    }

}
